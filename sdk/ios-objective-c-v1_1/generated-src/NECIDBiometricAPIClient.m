/*
 Copyright 2010-2016 Amazon.com, Inc. or its affiliates. All Rights Reserved.

 Licensed under the Apache License, Version 2.0 (the "License").
 You may not use this file except in compliance with the License.
 A copy of the License is located at

 http://aws.amazon.com/apache2.0

 or in the "license" file accompanying this file. This file is distributed
 on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 express or implied. See the License for the specific language governing
 permissions and limitations under the License.
 */
 


#import "NECIDBiometricAPIClient.h"
#import <AWSCore/AWSCore.h>
#import <AWSCore/AWSSignature.h>
#import <AWSCore/AWSSynchronizedMutableDictionary.h>

#import "NECIDExtractResult.h"
#import "NECIDSearchResult.h"
#import "NECIDCandidate.h"
#import "NECIDJob.h"
#import "NECIDJobSummary.h"
#import "NECIDSubjectList.h"
#import "NECIDSubject.h"
#import "NECIDEvents.h"
#import "NECIDEvent.h"
#import "NECIDTag.h"

@interface AWSAPIGatewayClient()

// Networking
@property (nonatomic, strong) NSURLSession *session;

// For requests
@property (nonatomic, strong) NSURL *baseURL;

// For responses
@property (nonatomic, strong) NSDictionary *HTTPHeaderFields;
@property (nonatomic, assign) NSInteger HTTPStatusCode;

- (AWSTask *)invokeHTTPRequest:(NSString *)HTTPMethod
                     URLString:(NSString *)URLString
                pathParameters:(NSDictionary *)pathParameters
               queryParameters:(NSDictionary *)queryParameters
              headerParameters:(NSDictionary *)headerParameters
                          body:(id)body
                 responseClass:(Class)responseClass;

@end

@interface NECIDBiometricAPIClient()

@property (nonatomic, strong) AWSServiceConfiguration *configuration;

@end

@interface AWSServiceConfiguration()

@property (nonatomic, strong) AWSEndpoint *endpoint;

@end

@implementation NECIDBiometricAPIClient

static NSString *const AWSInfoClientKey = @"NECIDBiometricAPIClient";

@synthesize configuration = _configuration;

static AWSSynchronizedMutableDictionary *_serviceClients = nil;

+ (instancetype)defaultClient {
    AWSServiceConfiguration *serviceConfiguration = nil;
    AWSServiceInfo *serviceInfo = [[AWSInfo defaultAWSInfo] defaultServiceInfo:AWSInfoClientKey];
    if (serviceInfo) {
        serviceConfiguration = [[AWSServiceConfiguration alloc] initWithRegion:serviceInfo.region
                                                           credentialsProvider:serviceInfo.cognitoCredentialsProvider];
    } else if ([AWSServiceManager defaultServiceManager].defaultServiceConfiguration) {
        serviceConfiguration = AWSServiceManager.defaultServiceManager.defaultServiceConfiguration;
    } else {
        serviceConfiguration = [[AWSServiceConfiguration alloc] initWithRegion:AWSRegionUnknown
                                                           credentialsProvider:nil];
    }

    static NECIDBiometricAPIClient *_defaultClient = nil;
    static dispatch_once_t onceToken;
    dispatch_once(&onceToken, ^{
        _defaultClient = [[NECIDBiometricAPIClient alloc] initWithConfiguration:serviceConfiguration];
    });

    return _defaultClient;
}

+ (void)registerClientWithConfiguration:(AWSServiceConfiguration *)configuration forKey:(NSString *)key {
    static dispatch_once_t onceToken;
    dispatch_once(&onceToken, ^{
        _serviceClients = [AWSSynchronizedMutableDictionary new];
    });
    [_serviceClients setObject:[[NECIDBiometricAPIClient alloc] initWithConfiguration:configuration]
                        forKey:key];
}

+ (instancetype)clientForKey:(NSString *)key {
    @synchronized(self) {
        NECIDBiometricAPIClient *serviceClient = [_serviceClients objectForKey:key];
        if (serviceClient) {
            return serviceClient;
        }

        AWSServiceInfo *serviceInfo = [[AWSInfo defaultAWSInfo] serviceInfo:AWSInfoClientKey
                                                                     forKey:key];
        if (serviceInfo) {
            AWSServiceConfiguration *serviceConfiguration = [[AWSServiceConfiguration alloc] initWithRegion:serviceInfo.region
                                                                                        credentialsProvider:serviceInfo.cognitoCredentialsProvider];
            [NECIDBiometricAPIClient registerClientWithConfiguration:serviceConfiguration
                                                    forKey:key];
        }

        return [_serviceClients objectForKey:key];
    }
}

+ (void)removeClientForKey:(NSString *)key {
    [_serviceClients removeObjectForKey:key];
}

- (instancetype)init {
    @throw [NSException exceptionWithName:NSInternalInconsistencyException
                                   reason:@"`- init` is not a valid initializer. Use `+ defaultClient` or `+ clientForKey:` instead."
                                 userInfo:nil];
    return nil;
}

- (instancetype)initWithConfiguration:(AWSServiceConfiguration *)configuration {
    if (self = [super init]) {
        _configuration = [configuration copy];

        NSString *URLString = @"https://api.id.nec.com.au/v1.1";
        if ([URLString hasSuffix:@"/"]) {
            URLString = [URLString substringToIndex:[URLString length] - 1];
        }
        _configuration.endpoint = [[AWSEndpoint alloc] initWithRegion:_configuration.regionType
                                                              service:AWSServiceAPIGateway
                                                                  URL:[NSURL URLWithString:URLString]];

        AWSSignatureV4Signer *signer =  [[AWSSignatureV4Signer alloc] initWithCredentialsProvider:_configuration.credentialsProvider
                                                                                         endpoint:_configuration.endpoint];

        _configuration.baseURL = _configuration.endpoint.URL;
        _configuration.requestInterceptors = @[[AWSNetworkingRequestInterceptor new], signer];
    }
    
    return self;
}

- (AWSTask *)faceExtractPost {
    NSDictionary *headerParameters = @{
                                       @"Content-Type": @"application/json",
                                       @"Accept": @"application/json",
                                       
                                       };
    NSDictionary *queryParameters = @{
                                      
                                      };
    NSDictionary *pathParameters = @{
                                     
                                     };
    
    return [self invokeHTTPRequest:@"POST"
                         URLString:@"/face/extract"
                    pathParameters:pathParameters
                   queryParameters:queryParameters
                  headerParameters:headerParameters
                              body:nil
                     responseClass:[NECIDExtractResult class]];
}

- (AWSTask *)faceExtractOptions {
    NSDictionary *headerParameters = @{
                                       @"Content-Type": @"application/json",
                                       @"Accept": @"application/json",
                                       
                                       };
    NSDictionary *queryParameters = @{
                                      
                                      };
    NSDictionary *pathParameters = @{
                                     
                                     };
    
    return [self invokeHTTPRequest:@"OPTIONS"
                         URLString:@"/face/extract"
                    pathParameters:pathParameters
                   queryParameters:queryParameters
                  headerParameters:headerParameters
                              body:nil
                     responseClass:nil];
}

- (AWSTask *)faceSearchPost {
    NSDictionary *headerParameters = @{
                                       @"Content-Type": @"application/json",
                                       @"Accept": @"application/json",
                                       
                                       };
    NSDictionary *queryParameters = @{
                                      
                                      };
    NSDictionary *pathParameters = @{
                                     
                                     };
    
    return [self invokeHTTPRequest:@"POST"
                         URLString:@"/face/search"
                    pathParameters:pathParameters
                   queryParameters:queryParameters
                  headerParameters:headerParameters
                              body:nil
                     responseClass:[NECIDSearchResult class]];
}

- (AWSTask *)faceSearchOptions {
    NSDictionary *headerParameters = @{
                                       @"Content-Type": @"application/json",
                                       @"Accept": @"application/json",
                                       
                                       };
    NSDictionary *queryParameters = @{
                                      
                                      };
    NSDictionary *pathParameters = @{
                                     
                                     };
    
    return [self invokeHTTPRequest:@"OPTIONS"
                         URLString:@"/face/search"
                    pathParameters:pathParameters
                   queryParameters:queryParameters
                  headerParameters:headerParameters
                              body:nil
                     responseClass:nil];
}

- (AWSTask *)faceVerifyPost {
    NSDictionary *headerParameters = @{
                                       @"Content-Type": @"application/json",
                                       @"Accept": @"application/json",
                                       
                                       };
    NSDictionary *queryParameters = @{
                                      
                                      };
    NSDictionary *pathParameters = @{
                                     
                                     };
    
    return [self invokeHTTPRequest:@"POST"
                         URLString:@"/face/verify"
                    pathParameters:pathParameters
                   queryParameters:queryParameters
                  headerParameters:headerParameters
                              body:nil
                     responseClass:[NECIDCandidate class]];
}

- (AWSTask *)faceVerifyOptions {
    NSDictionary *headerParameters = @{
                                       @"Content-Type": @"application/json",
                                       @"Accept": @"application/json",
                                       
                                       };
    NSDictionary *queryParameters = @{
                                      
                                      };
    NSDictionary *pathParameters = @{
                                     
                                     };
    
    return [self invokeHTTPRequest:@"OPTIONS"
                         URLString:@"/face/verify"
                    pathParameters:pathParameters
                   queryParameters:queryParameters
                  headerParameters:headerParameters
                              body:nil
                     responseClass:nil];
}

- (AWSTask *)healthGet {
    NSDictionary *headerParameters = @{
                                       @"Content-Type": @"application/json",
                                       @"Accept": @"application/json",
                                       
                                       };
    NSDictionary *queryParameters = @{
                                      
                                      };
    NSDictionary *pathParameters = @{
                                     
                                     };
    
    return [self invokeHTTPRequest:@"GET"
                         URLString:@"/health"
                    pathParameters:pathParameters
                   queryParameters:queryParameters
                  headerParameters:headerParameters
                              body:nil
                     responseClass:nil];
}

- (AWSTask *)healthOptions {
    NSDictionary *headerParameters = @{
                                       @"Content-Type": @"application/json",
                                       @"Accept": @"application/json",
                                       
                                       };
    NSDictionary *queryParameters = @{
                                      
                                      };
    NSDictionary *pathParameters = @{
                                     
                                     };
    
    return [self invokeHTTPRequest:@"OPTIONS"
                         URLString:@"/health"
                    pathParameters:pathParameters
                   queryParameters:queryParameters
                  headerParameters:headerParameters
                              body:nil
                     responseClass:nil];
}

- (AWSTask *)jobsBulkregisterPost {
    NSDictionary *headerParameters = @{
                                       @"Content-Type": @"application/json",
                                       @"Accept": @"application/json",
                                       
                                       };
    NSDictionary *queryParameters = @{
                                      
                                      };
    NSDictionary *pathParameters = @{
                                     
                                     };
    
    return [self invokeHTTPRequest:@"POST"
                         URLString:@"/jobs/bulkregister"
                    pathParameters:pathParameters
                   queryParameters:queryParameters
                  headerParameters:headerParameters
                              body:nil
                     responseClass:[NECIDJob class]];
}

- (AWSTask *)jobsBulkregisterOptions {
    NSDictionary *headerParameters = @{
                                       @"Content-Type": @"application/json",
                                       @"Accept": @"application/json",
                                       
                                       };
    NSDictionary *queryParameters = @{
                                      
                                      };
    NSDictionary *pathParameters = @{
                                     
                                     };
    
    return [self invokeHTTPRequest:@"OPTIONS"
                         URLString:@"/jobs/bulkregister"
                    pathParameters:pathParameters
                   queryParameters:queryParameters
                  headerParameters:headerParameters
                              body:nil
                     responseClass:nil];
}

- (AWSTask *)jobsBulkregisterBatchIdGet:(NSString *)batchId {
    NSDictionary *headerParameters = @{
                                       @"Content-Type": @"application/json",
                                       @"Accept": @"application/json",
                                       
                                       };
    NSDictionary *queryParameters = @{
                                      
                                      };
    NSDictionary *pathParameters = @{
                                     @"batchId": batchId
                                     };
    
    return [self invokeHTTPRequest:@"GET"
                         URLString:@"/jobs/bulkregister/{batchId}"
                    pathParameters:pathParameters
                   queryParameters:queryParameters
                  headerParameters:headerParameters
                              body:nil
                     responseClass:[NECIDJobSummary class]];
}

- (AWSTask *)jobsBulkregisterBatchIdOptions:(NSString *)batchId pagingId:(NSString *)pagingId {
    NSDictionary *headerParameters = @{
                                       @"Content-Type": @"application/json",
                                       @"Accept": @"application/json",
                                       
                                       };
    NSDictionary *queryParameters = @{
                                      @"pagingId": pagingId
                                      };
    NSDictionary *pathParameters = @{
                                     @"batchId": batchId,
                                     
                                     };
    
    return [self invokeHTTPRequest:@"OPTIONS"
                         URLString:@"/jobs/bulkregister/{batchId}"
                    pathParameters:pathParameters
                   queryParameters:queryParameters
                  headerParameters:headerParameters
                              body:nil
                     responseClass:nil];
}

- (AWSTask *)jobsBulkregisterBatchIdPagingIdGet:(NSString *)pagingId batchId:(NSString *)batchId {
    NSDictionary *headerParameters = @{
                                       @"Content-Type": @"application/json",
                                       @"Accept": @"application/json",
                                       
                                       };
    NSDictionary *queryParameters = @{
                                      @"pagingId": pagingId,
                                     
                                      };
    NSDictionary *pathParameters = @{
                                     @"batchId": batchId
                                     };
    
    return [self invokeHTTPRequest:@"GET"
                         URLString:@"/jobs/bulkregister/{batchId}/{pagingId}"
                    pathParameters:pathParameters
                   queryParameters:queryParameters
                  headerParameters:headerParameters
                              body:nil
                     responseClass:[NECIDJobSummary class]];
}

- (AWSTask *)jobsBulkregisterBatchIdPagingIdOptions:(NSString *)batchId pagingId:(NSString *)pagingId {
    NSDictionary *headerParameters = @{
                                       @"Content-Type": @"application/json",
                                       @"Accept": @"application/json",
                                       
                                       };
    NSDictionary *queryParameters = @{
                                      @"pagingId": pagingId
                                      };
    NSDictionary *pathParameters = @{
                                     @"batchId": batchId,
                                     
                                     };
    
    return [self invokeHTTPRequest:@"OPTIONS"
                         URLString:@"/jobs/bulkregister/{batchId}/{pagingId}"
                    pathParameters:pathParameters
                   queryParameters:queryParameters
                  headerParameters:headerParameters
                              body:nil
                     responseClass:nil];
}

- (AWSTask *)subjectsGet {
    NSDictionary *headerParameters = @{
                                       @"Content-Type": @"application/json",
                                       @"Accept": @"application/json",
                                       
                                       };
    NSDictionary *queryParameters = @{
                                      
                                      };
    NSDictionary *pathParameters = @{
                                     
                                     };
    
    return [self invokeHTTPRequest:@"GET"
                         URLString:@"/subjects"
                    pathParameters:pathParameters
                   queryParameters:queryParameters
                  headerParameters:headerParameters
                              body:nil
                     responseClass:[NECIDSubjectList class]];
}

- (AWSTask *)subjectsPost {
    NSDictionary *headerParameters = @{
                                       @"Content-Type": @"application/json",
                                       @"Accept": @"application/json",
                                       
                                       };
    NSDictionary *queryParameters = @{
                                      
                                      };
    NSDictionary *pathParameters = @{
                                     
                                     };
    
    return [self invokeHTTPRequest:@"POST"
                         URLString:@"/subjects"
                    pathParameters:pathParameters
                   queryParameters:queryParameters
                  headerParameters:headerParameters
                              body:nil
                     responseClass:[NECIDSubject class]];
}

- (AWSTask *)subjectsOptions {
    NSDictionary *headerParameters = @{
                                       @"Content-Type": @"application/json",
                                       @"Accept": @"application/json",
                                       
                                       };
    NSDictionary *queryParameters = @{
                                      
                                      };
    NSDictionary *pathParameters = @{
                                     
                                     };
    
    return [self invokeHTTPRequest:@"OPTIONS"
                         URLString:@"/subjects"
                    pathParameters:pathParameters
                   queryParameters:queryParameters
                  headerParameters:headerParameters
                              body:nil
                     responseClass:nil];
}

- (AWSTask *)subjectsSubjectIdPut:(NSString *)subjectId {
    NSDictionary *headerParameters = @{
                                       @"Content-Type": @"application/json",
                                       @"Accept": @"application/json",
                                       
                                       };
    NSDictionary *queryParameters = @{
                                      
                                      };
    NSDictionary *pathParameters = @{
                                     @"subjectId": subjectId
                                     };
    
    return [self invokeHTTPRequest:@"PUT"
                         URLString:@"/subjects/{subjectId}"
                    pathParameters:pathParameters
                   queryParameters:queryParameters
                  headerParameters:headerParameters
                              body:nil
                     responseClass:[NECIDSubject class]];
}

- (AWSTask *)subjectsSubjectIdDelete:(NSString *)subjectId {
    NSDictionary *headerParameters = @{
                                       @"Content-Type": @"application/json",
                                       @"Accept": @"application/json",
                                       
                                       };
    NSDictionary *queryParameters = @{
                                      
                                      };
    NSDictionary *pathParameters = @{
                                     @"subjectId": subjectId
                                     };
    
    return [self invokeHTTPRequest:@"DELETE"
                         URLString:@"/subjects/{subjectId}"
                    pathParameters:pathParameters
                   queryParameters:queryParameters
                  headerParameters:headerParameters
                              body:nil
                     responseClass:nil];
}

- (AWSTask *)subjectsSubjectIdOptions:(NSString *)subjectId {
    NSDictionary *headerParameters = @{
                                       @"Content-Type": @"application/json",
                                       @"Accept": @"application/json",
                                       
                                       };
    NSDictionary *queryParameters = @{
                                      
                                      };
    NSDictionary *pathParameters = @{
                                     @"subjectId": subjectId
                                     };
    
    return [self invokeHTTPRequest:@"OPTIONS"
                         URLString:@"/subjects/{subjectId}"
                    pathParameters:pathParameters
                   queryParameters:queryParameters
                  headerParameters:headerParameters
                              body:nil
                     responseClass:nil];
}

- (AWSTask *)subjectsSubjectIdEventsGet:(NSString *)subjectId {
    NSDictionary *headerParameters = @{
                                       @"Content-Type": @"application/json",
                                       @"Accept": @"application/json",
                                       
                                       };
    NSDictionary *queryParameters = @{
                                      
                                      };
    NSDictionary *pathParameters = @{
                                     @"subjectId": subjectId
                                     };
    
    return [self invokeHTTPRequest:@"GET"
                         URLString:@"/subjects/{subjectId}/events"
                    pathParameters:pathParameters
                   queryParameters:queryParameters
                  headerParameters:headerParameters
                              body:nil
                     responseClass:[NECIDEvents class]];
}

- (AWSTask *)subjectsSubjectIdEventsPost:(NSString *)subjectId {
    NSDictionary *headerParameters = @{
                                       @"Content-Type": @"application/json",
                                       @"Accept": @"application/json",
                                       
                                       };
    NSDictionary *queryParameters = @{
                                      
                                      };
    NSDictionary *pathParameters = @{
                                     @"subjectId": subjectId
                                     };
    
    return [self invokeHTTPRequest:@"POST"
                         URLString:@"/subjects/{subjectId}/events"
                    pathParameters:pathParameters
                   queryParameters:queryParameters
                  headerParameters:headerParameters
                              body:nil
                     responseClass:[NECIDEvent class]];
}

- (AWSTask *)subjectsSubjectIdEventsOptions:(NSString *)subjectId {
    NSDictionary *headerParameters = @{
                                       @"Content-Type": @"application/json",
                                       @"Accept": @"application/json",
                                       
                                       };
    NSDictionary *queryParameters = @{
                                      
                                      };
    NSDictionary *pathParameters = @{
                                     @"subjectId": subjectId
                                     };
    
    return [self invokeHTTPRequest:@"OPTIONS"
                         URLString:@"/subjects/{subjectId}/events"
                    pathParameters:pathParameters
                   queryParameters:queryParameters
                  headerParameters:headerParameters
                              body:nil
                     responseClass:nil];
}

- (AWSTask *)subjectsSubjectIdEventsEventIdPut:(NSString *)eventId subjectId:(NSString *)subjectId {
    NSDictionary *headerParameters = @{
                                       @"Content-Type": @"application/json",
                                       @"Accept": @"application/json",
                                       
                                       };
    NSDictionary *queryParameters = @{
                                      
                                      };
    NSDictionary *pathParameters = @{
                                     @"eventId": eventId,
                                     @"subjectId": subjectId
                                     };
    
    return [self invokeHTTPRequest:@"PUT"
                         URLString:@"/subjects/{subjectId}/events/{eventId}"
                    pathParameters:pathParameters
                   queryParameters:queryParameters
                  headerParameters:headerParameters
                              body:nil
                     responseClass:[NECIDEvent class]];
}

- (AWSTask *)subjectsSubjectIdEventsEventIdDelete:(NSString *)eventId subjectId:(NSString *)subjectId {
    NSDictionary *headerParameters = @{
                                       @"Content-Type": @"application/json",
                                       @"Accept": @"application/json",
                                       
                                       };
    NSDictionary *queryParameters = @{
                                      
                                      };
    NSDictionary *pathParameters = @{
                                     @"eventId": eventId,
                                     @"subjectId": subjectId
                                     };
    
    return [self invokeHTTPRequest:@"DELETE"
                         URLString:@"/subjects/{subjectId}/events/{eventId}"
                    pathParameters:pathParameters
                   queryParameters:queryParameters
                  headerParameters:headerParameters
                              body:nil
                     responseClass:nil];
}

- (AWSTask *)subjectsSubjectIdEventsEventIdOptions:(NSString *)eventId subjectId:(NSString *)subjectId {
    NSDictionary *headerParameters = @{
                                       @"Content-Type": @"application/json",
                                       @"Accept": @"application/json",
                                       
                                       };
    NSDictionary *queryParameters = @{
                                      
                                      };
    NSDictionary *pathParameters = @{
                                     @"eventId": eventId,
                                     @"subjectId": subjectId
                                     };
    
    return [self invokeHTTPRequest:@"OPTIONS"
                         URLString:@"/subjects/{subjectId}/events/{eventId}"
                    pathParameters:pathParameters
                   queryParameters:queryParameters
                  headerParameters:headerParameters
                              body:nil
                     responseClass:nil];
}

- (AWSTask *)tagsGet {
    NSDictionary *headerParameters = @{
                                       @"Content-Type": @"application/json",
                                       @"Accept": @"application/json",
                                       
                                       };
    NSDictionary *queryParameters = @{
                                      
                                      };
    NSDictionary *pathParameters = @{
                                     
                                     };
    
    return [self invokeHTTPRequest:@"GET"
                         URLString:@"/tags"
                    pathParameters:pathParameters
                   queryParameters:queryParameters
                  headerParameters:headerParameters
                              body:nil
                     responseClass:[NECIDTag class]];
}

- (AWSTask *)tagsOptions {
    NSDictionary *headerParameters = @{
                                       @"Content-Type": @"application/json",
                                       @"Accept": @"application/json",
                                       
                                       };
    NSDictionary *queryParameters = @{
                                      
                                      };
    NSDictionary *pathParameters = @{
                                     
                                     };
    
    return [self invokeHTTPRequest:@"OPTIONS"
                         URLString:@"/tags"
                    pathParameters:pathParameters
                   queryParameters:queryParameters
                  headerParameters:headerParameters
                              body:nil
                     responseClass:nil];
}

- (AWSTask *)tagsNamePut:(NSString *)name {
    NSDictionary *headerParameters = @{
                                       @"Content-Type": @"application/json",
                                       @"Accept": @"application/json",
                                       
                                       };
    NSDictionary *queryParameters = @{
                                      
                                      };
    NSDictionary *pathParameters = @{
                                     @"name": name
                                     };
    
    return [self invokeHTTPRequest:@"PUT"
                         URLString:@"/tags/{name}"
                    pathParameters:pathParameters
                   queryParameters:queryParameters
                  headerParameters:headerParameters
                              body:nil
                     responseClass:nil];
}

- (AWSTask *)tagsNamePost:(NSString *)name {
    NSDictionary *headerParameters = @{
                                       @"Content-Type": @"application/json",
                                       @"Accept": @"application/json",
                                       
                                       };
    NSDictionary *queryParameters = @{
                                      
                                      };
    NSDictionary *pathParameters = @{
                                     @"name": name
                                     };
    
    return [self invokeHTTPRequest:@"POST"
                         URLString:@"/tags/{name}"
                    pathParameters:pathParameters
                   queryParameters:queryParameters
                  headerParameters:headerParameters
                              body:nil
                     responseClass:nil];
}

- (AWSTask *)tagsNameDelete:(NSString *)name {
    NSDictionary *headerParameters = @{
                                       @"Content-Type": @"application/json",
                                       @"Accept": @"application/json",
                                       
                                       };
    NSDictionary *queryParameters = @{
                                      
                                      };
    NSDictionary *pathParameters = @{
                                     @"name": name
                                     };
    
    return [self invokeHTTPRequest:@"DELETE"
                         URLString:@"/tags/{name}"
                    pathParameters:pathParameters
                   queryParameters:queryParameters
                  headerParameters:headerParameters
                              body:nil
                     responseClass:nil];
}

- (AWSTask *)tagsNameOptions:(NSString *)name {
    NSDictionary *headerParameters = @{
                                       @"Content-Type": @"application/json",
                                       @"Accept": @"application/json",
                                       
                                       };
    NSDictionary *queryParameters = @{
                                      
                                      };
    NSDictionary *pathParameters = @{
                                     @"name": name
                                     };
    
    return [self invokeHTTPRequest:@"OPTIONS"
                         URLString:@"/tags/{name}"
                    pathParameters:pathParameters
                   queryParameters:queryParameters
                  headerParameters:headerParameters
                              body:nil
                     responseClass:nil];
}



@end
