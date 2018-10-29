# Creating a client
To create a client, use the client builder. You can obtain an instance of the builder via a static factory method located on the client interface.

```java
NECIDClientBuilder builder = NECID.builder();
```

The builder exposes many fluent configuration methods that can be chained to configure a service client. Here's a simple example that sets a few optional configuration options and then builds the service client.
```java
NECID client = NECID.builder()
    .connectionConfiguration(new ConnectionConfiguration()
	    .maxConnections(100)
	    .connectionMaxIdleMillis(1000))
    .timeoutConfiguration(new TimeoutConfiguration()
	    .httpRequestTimeout(3000)
	    .totalExecutionTimeout(10000)
	    .socketTimeout(2000))
    .build();
```

# Client Lifecycle
Note that each client created has its own connection pool. It's recommended to treat the clients as long-lived objects. Clients are immutable and thread safe.
Clients clean up their resources when garbage collected but if you want to explicitly shut down the client you can do the following:
```java
NECID client = NECID.builder().build();
client.shutdown();
// Client is now unusable
```
# API keys
An API key must be provided by the service owner. After they key is available, it can be set via the client builder. It is recommended to treat the API key as sensitive and not hard-code it in your source code.

```java
NECID client = NECID.builder()
    .apiKey("customers-api-key")
    .build();
```

After it is configured, the API key is sent with every request made to the service via the `x-api-key` header.

See [http://docs.aws.amazon.com/apigateway/latest/developerguide/how-to-api-keys.html](http://docs.aws.amazon.com/apigateway/latest/developerguide/how-to-api-keys.html) for more information.

# Authorization
# AWS Identity and Access Management (IAM) authentication
The service client natively supports AWS_IAM authentication using AWS credentials. To configure the AWS credentials used by the client, use the `iamCredentials` fluent setter.
```java
NECID client = NECID.builder()
    .iamCredentials(new ProfileCredentialsProvider("personal"))
    .build();
```
The `iamCredentials` method takes an instance of [AWSCredentialsProvider](http://docs.aws.amazon.com/AWSJavaSDK/latest/javadoc/com/amazonaws/auth/AWSCredentialsProvider.html). There are several implementations of AWSCredentialsProvider available and you can also implement your own.

# Making requests
After a client is configured and created, you can make a request to the service. A method on the client interface (`NECID`) is created for all actions (resource + method) in your API.

For each API method, classes are generated that represent the request and response of that API. The request class has setters for any path parameters, query parameters, headers, and payload model that are defined in the API. The response class exposes getters for any modeled headers and for the modeled payload.
```java
NECID client = NECID.builder().build();
ApiFaceExtractPostResult result = client.apiFaceExtractPost(new ApiFaceExtractPostRequest());
```

# Request Configuration
In addition to client-level configuration configured by the builder, each request class exposes configuration methods that are scoped to that request alone. Request level configuration takes precedence over client level configuration.

The request config also allows adding headers and query parameters that aren't modeled by the API.

```java
NECID client = NECID.builder().build();
client.apiFaceExtractPost(new ApiFaceExtractPostRequest().sdkRequestConfig(
    SdkRequestConfig.builder()
	.httpRequestTimeout(1500)
	.totalExecutionTimeout(5000)
	.customHeader("CustomHeaderName", "foo")
	.customQueryParam("CustomQueryParamName", "bar")
	.build()
));
```

# Response Metadata
In addition to the modeled data present in result objects, the SDK exposes access to additional HTTP metadata. This metadata is useful for debugging issues or accessing unmodeled data from the HTTP response.
```java
ApiFaceExtractPostResult result = client.apiFaceExtractPost(new ApiFaceExtractPostRequest());
System.out.println(result.sdkResponseMetadata().requestId());
System.out.println(result.sdkResponseMetadata().httpStatusCode());
// Full access to all HTTP headers (including modeled ones)
result.sdkResponseMetadata().header("Content-Length").ifPresent(System.out::println);
```

# Exception Handling

Service exceptions and client exceptions can be handled separately. Any exceptions modeled in the API will be a subtype of NECIDException.
```java
try {
    client.apiFaceExtractPost(...);
} catch(NotFoundException e) {
    // This is a modeled exception defined in the API
} catch(NECIDException e) {
   // All service exceptions will extend from NECIDException.
   // Any unknown or unmodeled service exceptions will be represented as a NECIDException.
} catch(SdkClientException e) {
   // Client exceptions include timeouts, IOExceptions, or any other exceptional situation where a response
   // is not received from the service.
}
```

All exceptions that can be thrown by the SDK are a subtype of SdkBaseException. To handle any exception in the same way, you can directly catch this exception. This covers both client and service exceptions.
```java
try {
    client.apiFaceExtractPost(...);
} catch(SdkBaseException e) {
    // All exceptions thrown from the client will be a subtype of SdkBaseException.
}
```

All service exceptions expose metadata about the HTTP response for logging or debugging purposes.
```java
try {
    client.apiFaceExtractPost(...);
} catch(NECIDException e) {
    int statusCode = e.sdkHttpMetadata().httpStatusCode();
    String requestId = e.sdkHttpMetadata().requestId();
    Optional<String> contentLength = e.sdkHttpMetadata().header("Content-Length");
    ByteBuffer responseContent = e.sdkHttpMetadata().responseContent();
}
```

Some client exceptions thrown are subtypes of SdkClientException. This provides greater granularity to deal with client-side exceptions.
```java
try {
    client.apiFaceExtractPost(...);
} catch(ClientExecutionTimeoutException e) {
    // Specific client exception thrown when the totalExecutionTimeout is triggered.
} catch(AbortedException e) {
    // Thrown when the client thread is interrupted while making a request.
} catch(SdkClientException e) {
    // All other exceptions can be handled here.
}
```

# Retries
Out of the box, the generated client retries on throttling errors (HTTP status code 429) and connection exceptions. If a different retry policy is desired, a custom one can be set via the client builder.

The easiest way to create a custom retry policy is to use the RetryPolicyBuilder. It provides a declarative API to specify when to retry.

```java
/**
 * The policy below will retry if the cause of the failed request matches any of the exceptions
 * given OR if the HTTP response from the service has one of the provided status codes.
 */
NECID client = NECID.builder()
        .retryPolicy(RetryPolicyBuilder.standard()
                             .retryOnExceptions(NotFoundException.class, SocketTimeoutException.class)
                             .retryOnStatusCodes(429, 500)
                             .maxNumberOfRetries(10)
                             .fixedBackoff(100)
                             .build())
        .build();
```

You can also directly implement the RetryPolicy interface to define your own implementation. RetryPolicyContext contains useful metadata about the state of the failed request that can be used to drive dynamic retry decisions or compute backoff delays.

```java
/**
 * Simple implementation of {@link com.amazonaws.retry.v2.RetryPolicy}
 */
public static class CustomRetryPolicy implements RetryPolicy {

    @Override
    public long computeDelayBeforeNextRetry(RetryPolicyContext context) {
        return 100;
    }

    @Override
    public boolean shouldRetry(RetryPolicyContext context) {
        return context.retriesAttempted() < 3;
    }
}
// Using a custom retry policy via the builder
NECID client = NECID.builder()
        .retryPolicy(new CustomRetryPolicy())
        .build();
```

You can implement a RetryCondition and BackoffStrategy separately and combine them into a single policy.

```java
/**
 * Retry on 429 status codes. It's important to note that status code may be null if no response was returned from the
 * service. See {@link com.amazonaws.retry.v2.RetryCondition}
 */
public static class RetryOnThrottlingCondition implements RetryCondition {

    @Override
    public boolean shouldRetry(RetryPolicyContext context) {
        return context.httpStatusCode() != null && context.httpStatusCode() == 429;
    }
}

/**
 * Simple implementation of {@link BackoffStrategy} that always backs off 100 milliseconds.
 */
public static class Backoff100MillisecondsStrategy implements BackoffStrategy {
    @Override
    public long computeDelayBeforeNextRetry(RetryPolicyContext context) {
        return 100;
    }
}

/**
 * Uses {@link com.amazonaws.retry.v2.SimpleRetryPolicy} to combine a separately implemented RetryCondition and BackoffStrategy.
 */
NECID client = NECID.builder()
        .retryPolicy(new SimpleRetryPolicy(new RetryOnThrottlingCondition(), new Backoff100MillisecondsStrategy()))
        .build();

/**
 * The RetryCondition and BackoffStrategy interfaces are functional interfaces so lambda expressions and method
 * references may also be used. This is equivalent to the above example.
 */
NECID client = NECID.builder()
        .retryPolicy(new SimpleRetryPolicy(c -> c.httpStatusCode() != null && c.httpStatusCode() == 429,
                                           c -> 100))
        .build();
```