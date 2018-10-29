/**
 * null
 */
package nec.necid.client;

import java.net.*;
import java.util.*;

import javax.annotation.Generated;

import org.apache.commons.logging.*;

import com.amazonaws.*;
import com.amazonaws.opensdk.*;
import com.amazonaws.opensdk.model.*;
import com.amazonaws.opensdk.protect.model.transform.*;
import com.amazonaws.auth.*;
import com.amazonaws.handlers.*;
import com.amazonaws.http.*;
import com.amazonaws.internal.*;
import com.amazonaws.metrics.*;
import com.amazonaws.regions.*;
import com.amazonaws.transform.*;
import com.amazonaws.util.*;
import com.amazonaws.protocol.json.*;

import com.amazonaws.annotation.ThreadSafe;
import com.amazonaws.client.AwsSyncClientParams;

import com.amazonaws.client.ClientHandler;
import com.amazonaws.client.ClientHandlerParams;
import com.amazonaws.client.ClientExecutionParams;
import com.amazonaws.opensdk.protect.client.SdkClientHandler;
import com.amazonaws.SdkBaseException;

import nec.necid.client.model.*;
import nec.necid.client.model.transform.*;

/**
 * Client for accessing NECID. All service calls made using this client are blocking, and will not return until the
 * service call completes.
 * <p>
 * 
 */
@ThreadSafe
@Generated("com.amazonaws:aws-java-sdk-code-generator")
class NECIDClient implements NECID {

    private final ClientHandler clientHandler;

    private static final com.amazonaws.opensdk.protect.protocol.ApiGatewayProtocolFactoryImpl protocolFactory = new com.amazonaws.opensdk.protect.protocol.ApiGatewayProtocolFactoryImpl(
            new JsonClientMetadata()
                    .withProtocolVersion("1.1")
                    .withSupportsCbor(false)
                    .withSupportsIon(false)
                    .withContentTypeOverride("application/json")
                    .addErrorMetadata(
                            new JsonErrorShapeMetadata().withErrorCode("NotFoundException").withModeledClass(nec.necid.client.model.NotFoundException.class))
                    .withBaseServiceExceptionClass(nec.necid.client.model.NECIDException.class));

    /**
     * Constructs a new client to invoke service methods on NECID using the specified parameters.
     *
     * <p>
     * All service calls made using this new client object are blocking, and will not return until the service call
     * completes.
     *
     * @param clientParams
     *        Object providing client parameters.
     */
    NECIDClient(AwsSyncClientParams clientParams) {
        this.clientHandler = new SdkClientHandler(new ClientHandlerParams().withClientParams(clientParams));
    }

    /**
     * @param apiFaceExtractPostRequest
     * @return Result of the ApiFaceExtractPost operation returned by the service.
     * @throws NotFoundException
     * @sample NECID.ApiFaceExtractPost
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/api-2018-10-29T02:37:36Z/ApiFaceExtractPost"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public ApiFaceExtractPostResult apiFaceExtractPost(ApiFaceExtractPostRequest apiFaceExtractPostRequest) {
        HttpResponseHandler<ApiFaceExtractPostResult> responseHandler = protocolFactory.createResponseHandler(new JsonOperationMetadata().withPayloadJson(true)
                .withHasStreamingSuccessResponse(false), new ApiFaceExtractPostResultJsonUnmarshaller());

        HttpResponseHandler<SdkBaseException> errorResponseHandler = createErrorResponseHandler(new JsonErrorShapeMetadata().withModeledClass(
                NotFoundException.class).withHttpStatusCode(404));

        return clientHandler.execute(new ClientExecutionParams<ApiFaceExtractPostRequest, ApiFaceExtractPostResult>()
                .withMarshaller(new ApiFaceExtractPostRequestProtocolMarshaller(protocolFactory)).withResponseHandler(responseHandler)
                .withErrorResponseHandler(errorResponseHandler).withInput(apiFaceExtractPostRequest));
    }

    /**
     * @param apiFaceSearchPostRequest
     * @return Result of the ApiFaceSearchPost operation returned by the service.
     * @throws NotFoundException
     * @sample NECID.ApiFaceSearchPost
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/api-2018-10-29T02:37:36Z/ApiFaceSearchPost"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public ApiFaceSearchPostResult apiFaceSearchPost(ApiFaceSearchPostRequest apiFaceSearchPostRequest) {
        HttpResponseHandler<ApiFaceSearchPostResult> responseHandler = protocolFactory.createResponseHandler(new JsonOperationMetadata().withPayloadJson(true)
                .withHasStreamingSuccessResponse(false), new ApiFaceSearchPostResultJsonUnmarshaller());

        HttpResponseHandler<SdkBaseException> errorResponseHandler = createErrorResponseHandler(new JsonErrorShapeMetadata().withModeledClass(
                NotFoundException.class).withHttpStatusCode(404));

        return clientHandler.execute(new ClientExecutionParams<ApiFaceSearchPostRequest, ApiFaceSearchPostResult>()
                .withMarshaller(new ApiFaceSearchPostRequestProtocolMarshaller(protocolFactory)).withResponseHandler(responseHandler)
                .withErrorResponseHandler(errorResponseHandler).withInput(apiFaceSearchPostRequest));
    }

    /**
     * @param apiFaceVerifyPostRequest
     * @return Result of the ApiFaceVerifyPost operation returned by the service.
     * @throws NotFoundException
     * @sample NECID.ApiFaceVerifyPost
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/api-2018-10-29T02:37:36Z/ApiFaceVerifyPost"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public ApiFaceVerifyPostResult apiFaceVerifyPost(ApiFaceVerifyPostRequest apiFaceVerifyPostRequest) {
        HttpResponseHandler<ApiFaceVerifyPostResult> responseHandler = protocolFactory.createResponseHandler(new JsonOperationMetadata().withPayloadJson(true)
                .withHasStreamingSuccessResponse(false), new ApiFaceVerifyPostResultJsonUnmarshaller());

        HttpResponseHandler<SdkBaseException> errorResponseHandler = createErrorResponseHandler(new JsonErrorShapeMetadata().withModeledClass(
                NotFoundException.class).withHttpStatusCode(404));

        return clientHandler.execute(new ClientExecutionParams<ApiFaceVerifyPostRequest, ApiFaceVerifyPostResult>()
                .withMarshaller(new ApiFaceVerifyPostRequestProtocolMarshaller(protocolFactory)).withResponseHandler(responseHandler)
                .withErrorResponseHandler(errorResponseHandler).withInput(apiFaceVerifyPostRequest));
    }

    /**
     * @param apiSubjectsByIdDeleteRequest
     * @return Result of the ApiSubjectsByIdDelete operation returned by the service.
     * @throws NotFoundException
     * @sample NECID.ApiSubjectsByIdDelete
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/api-2018-10-29T02:37:36Z/ApiSubjectsByIdDelete"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public ApiSubjectsByIdDeleteResult apiSubjectsByIdDelete(ApiSubjectsByIdDeleteRequest apiSubjectsByIdDeleteRequest) {
        HttpResponseHandler<ApiSubjectsByIdDeleteResult> responseHandler = protocolFactory.createResponseHandler(
                new JsonOperationMetadata().withPayloadJson(true).withHasStreamingSuccessResponse(false), new ApiSubjectsByIdDeleteResultJsonUnmarshaller());

        HttpResponseHandler<SdkBaseException> errorResponseHandler = createErrorResponseHandler(new JsonErrorShapeMetadata().withModeledClass(
                NotFoundException.class).withHttpStatusCode(404));

        return clientHandler.execute(new ClientExecutionParams<ApiSubjectsByIdDeleteRequest, ApiSubjectsByIdDeleteResult>()
                .withMarshaller(new ApiSubjectsByIdDeleteRequestProtocolMarshaller(protocolFactory)).withResponseHandler(responseHandler)
                .withErrorResponseHandler(errorResponseHandler).withInput(apiSubjectsByIdDeleteRequest));
    }

    /**
     * @param apiSubjectsByIdPutRequest
     * @return Result of the ApiSubjectsByIdPut operation returned by the service.
     * @throws NotFoundException
     * @sample NECID.ApiSubjectsByIdPut
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/api-2018-10-29T02:37:36Z/ApiSubjectsByIdPut"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public ApiSubjectsByIdPutResult apiSubjectsByIdPut(ApiSubjectsByIdPutRequest apiSubjectsByIdPutRequest) {
        HttpResponseHandler<ApiSubjectsByIdPutResult> responseHandler = protocolFactory.createResponseHandler(new JsonOperationMetadata().withPayloadJson(true)
                .withHasStreamingSuccessResponse(false), new ApiSubjectsByIdPutResultJsonUnmarshaller());

        HttpResponseHandler<SdkBaseException> errorResponseHandler = createErrorResponseHandler(new JsonErrorShapeMetadata().withModeledClass(
                NotFoundException.class).withHttpStatusCode(404));

        return clientHandler.execute(new ClientExecutionParams<ApiSubjectsByIdPutRequest, ApiSubjectsByIdPutResult>()
                .withMarshaller(new ApiSubjectsByIdPutRequestProtocolMarshaller(protocolFactory)).withResponseHandler(responseHandler)
                .withErrorResponseHandler(errorResponseHandler).withInput(apiSubjectsByIdPutRequest));
    }

    /**
     * @param apiSubjectsPostRequest
     * @return Result of the ApiSubjectsPost operation returned by the service.
     * @sample NECID.ApiSubjectsPost
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/api-2018-10-29T02:37:36Z/ApiSubjectsPost" target="_top">AWS
     *      API Documentation</a>
     */
    @Override
    public ApiSubjectsPostResult apiSubjectsPost(ApiSubjectsPostRequest apiSubjectsPostRequest) {
        HttpResponseHandler<ApiSubjectsPostResult> responseHandler = protocolFactory.createResponseHandler(new JsonOperationMetadata().withPayloadJson(true)
                .withHasStreamingSuccessResponse(false), new ApiSubjectsPostResultJsonUnmarshaller());

        HttpResponseHandler<SdkBaseException> errorResponseHandler = createErrorResponseHandler();

        return clientHandler.execute(new ClientExecutionParams<ApiSubjectsPostRequest, ApiSubjectsPostResult>()
                .withMarshaller(new ApiSubjectsPostRequestProtocolMarshaller(protocolFactory)).withResponseHandler(responseHandler)
                .withErrorResponseHandler(errorResponseHandler).withInput(apiSubjectsPostRequest));
    }

    /**
     * @param getHealthRequest
     * @return Result of the GetHealth operation returned by the service.
     * @sample NECID.GetHealth
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/api-2018-10-29T02:37:36Z/GetHealth" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public GetHealthResult getHealth(GetHealthRequest getHealthRequest) {
        HttpResponseHandler<GetHealthResult> responseHandler = protocolFactory.createResponseHandler(new JsonOperationMetadata().withPayloadJson(true)
                .withHasStreamingSuccessResponse(false), new GetHealthResultJsonUnmarshaller());

        HttpResponseHandler<SdkBaseException> errorResponseHandler = createErrorResponseHandler();

        return clientHandler.execute(new ClientExecutionParams<GetHealthRequest, GetHealthResult>()
                .withMarshaller(new GetHealthRequestProtocolMarshaller(protocolFactory)).withResponseHandler(responseHandler)
                .withErrorResponseHandler(errorResponseHandler).withInput(getHealthRequest));
    }

    /**
     * Create the error response handler for the operation.
     * 
     * @param errorShapeMetadata
     *        Error metadata for the given operation
     * @return Configured error response handler to pass to HTTP layer
     */
    private HttpResponseHandler<SdkBaseException> createErrorResponseHandler(JsonErrorShapeMetadata... errorShapeMetadata) {
        return protocolFactory.createErrorResponseHandler(new JsonErrorResponseMetadata().withErrorShapes(Arrays.asList(errorShapeMetadata)));
    }

    @Override
    public void shutdown() {
        clientHandler.shutdown();
    }

}
