/**
 * null
 */
package au.com.nec.id.client;

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

import au.com.nec.id.client.model.*;
import au.com.nec.id.client.model.transform.*;

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
                            new JsonErrorShapeMetadata().withErrorCode("NotFoundException")
                                    .withModeledClass(au.com.nec.id.client.model.NotFoundException.class))
                    .withBaseServiceExceptionClass(au.com.nec.id.client.model.NECIDException.class));

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
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/api-1.1/ApiFaceExtractPost" target="_top">AWS API
     *      Documentation</a>
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
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/api-1.1/ApiFaceSearchPost" target="_top">AWS API
     *      Documentation</a>
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
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/api-1.1/ApiFaceVerifyPost" target="_top">AWS API
     *      Documentation</a>
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
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/api-1.1/ApiSubjectsByIdDelete" target="_top">AWS API
     *      Documentation</a>
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
     * @param apiSubjectsByIdEventByIdDeleteRequest
     * @return Result of the ApiSubjectsByIdEventByIdDelete operation returned by the service.
     * @throws NotFoundException
     * @sample NECID.ApiSubjectsByIdEventByIdDelete
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/api-1.1/ApiSubjectsByIdEventByIdDelete" target="_top">AWS
     *      API Documentation</a>
     */
    @Override
    public ApiSubjectsByIdEventByIdDeleteResult apiSubjectsByIdEventByIdDelete(ApiSubjectsByIdEventByIdDeleteRequest apiSubjectsByIdEventByIdDeleteRequest) {
        HttpResponseHandler<ApiSubjectsByIdEventByIdDeleteResult> responseHandler = protocolFactory.createResponseHandler(new JsonOperationMetadata()
                .withPayloadJson(true).withHasStreamingSuccessResponse(false), new ApiSubjectsByIdEventByIdDeleteResultJsonUnmarshaller());

        HttpResponseHandler<SdkBaseException> errorResponseHandler = createErrorResponseHandler(new JsonErrorShapeMetadata().withModeledClass(
                NotFoundException.class).withHttpStatusCode(404));

        return clientHandler.execute(new ClientExecutionParams<ApiSubjectsByIdEventByIdDeleteRequest, ApiSubjectsByIdEventByIdDeleteResult>()
                .withMarshaller(new ApiSubjectsByIdEventByIdDeleteRequestProtocolMarshaller(protocolFactory)).withResponseHandler(responseHandler)
                .withErrorResponseHandler(errorResponseHandler).withInput(apiSubjectsByIdEventByIdDeleteRequest));
    }

    /**
     * @param apiSubjectsByIdEventByIdPutRequest
     * @return Result of the ApiSubjectsByIdEventByIdPut operation returned by the service.
     * @throws NotFoundException
     * @sample NECID.ApiSubjectsByIdEventByIdPut
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/api-1.1/ApiSubjectsByIdEventByIdPut" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public ApiSubjectsByIdEventByIdPutResult apiSubjectsByIdEventByIdPut(ApiSubjectsByIdEventByIdPutRequest apiSubjectsByIdEventByIdPutRequest) {
        HttpResponseHandler<ApiSubjectsByIdEventByIdPutResult> responseHandler = protocolFactory.createResponseHandler(new JsonOperationMetadata()
                .withPayloadJson(true).withHasStreamingSuccessResponse(false), new ApiSubjectsByIdEventByIdPutResultJsonUnmarshaller());

        HttpResponseHandler<SdkBaseException> errorResponseHandler = createErrorResponseHandler(new JsonErrorShapeMetadata().withModeledClass(
                NotFoundException.class).withHttpStatusCode(404));

        return clientHandler.execute(new ClientExecutionParams<ApiSubjectsByIdEventByIdPutRequest, ApiSubjectsByIdEventByIdPutResult>()
                .withMarshaller(new ApiSubjectsByIdEventByIdPutRequestProtocolMarshaller(protocolFactory)).withResponseHandler(responseHandler)
                .withErrorResponseHandler(errorResponseHandler).withInput(apiSubjectsByIdEventByIdPutRequest));
    }

    /**
     * @param apiSubjectsByIdEventsGetRequest
     * @return Result of the ApiSubjectsByIdEventsGet operation returned by the service.
     * @throws NotFoundException
     * @sample NECID.ApiSubjectsByIdEventsGet
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/api-1.1/ApiSubjectsByIdEventsGet" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public ApiSubjectsByIdEventsGetResult apiSubjectsByIdEventsGet(ApiSubjectsByIdEventsGetRequest apiSubjectsByIdEventsGetRequest) {
        HttpResponseHandler<ApiSubjectsByIdEventsGetResult> responseHandler = protocolFactory.createResponseHandler(new JsonOperationMetadata()
                .withPayloadJson(true).withHasStreamingSuccessResponse(false), new ApiSubjectsByIdEventsGetResultJsonUnmarshaller());

        HttpResponseHandler<SdkBaseException> errorResponseHandler = createErrorResponseHandler(new JsonErrorShapeMetadata().withModeledClass(
                NotFoundException.class).withHttpStatusCode(404));

        return clientHandler.execute(new ClientExecutionParams<ApiSubjectsByIdEventsGetRequest, ApiSubjectsByIdEventsGetResult>()
                .withMarshaller(new ApiSubjectsByIdEventsGetRequestProtocolMarshaller(protocolFactory)).withResponseHandler(responseHandler)
                .withErrorResponseHandler(errorResponseHandler).withInput(apiSubjectsByIdEventsGetRequest));
    }

    /**
     * @param apiSubjectsByIdEventsPostRequest
     * @return Result of the ApiSubjectsByIdEventsPost operation returned by the service.
     * @throws NotFoundException
     * @sample NECID.ApiSubjectsByIdEventsPost
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/api-1.1/ApiSubjectsByIdEventsPost" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public ApiSubjectsByIdEventsPostResult apiSubjectsByIdEventsPost(ApiSubjectsByIdEventsPostRequest apiSubjectsByIdEventsPostRequest) {
        HttpResponseHandler<ApiSubjectsByIdEventsPostResult> responseHandler = protocolFactory.createResponseHandler(new JsonOperationMetadata()
                .withPayloadJson(true).withHasStreamingSuccessResponse(false), new ApiSubjectsByIdEventsPostResultJsonUnmarshaller());

        HttpResponseHandler<SdkBaseException> errorResponseHandler = createErrorResponseHandler(new JsonErrorShapeMetadata().withModeledClass(
                NotFoundException.class).withHttpStatusCode(404));

        return clientHandler.execute(new ClientExecutionParams<ApiSubjectsByIdEventsPostRequest, ApiSubjectsByIdEventsPostResult>()
                .withMarshaller(new ApiSubjectsByIdEventsPostRequestProtocolMarshaller(protocolFactory)).withResponseHandler(responseHandler)
                .withErrorResponseHandler(errorResponseHandler).withInput(apiSubjectsByIdEventsPostRequest));
    }

    /**
     * @param apiSubjectsByIdPutRequest
     * @return Result of the ApiSubjectsByIdPut operation returned by the service.
     * @throws NotFoundException
     * @sample NECID.ApiSubjectsByIdPut
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/api-1.1/ApiSubjectsByIdPut" target="_top">AWS API
     *      Documentation</a>
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
     * @param apiSubjectsGetRequest
     * @return Result of the ApiSubjectsGet operation returned by the service.
     * @sample NECID.ApiSubjectsGet
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/api-1.1/ApiSubjectsGet" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public ApiSubjectsGetResult apiSubjectsGet(ApiSubjectsGetRequest apiSubjectsGetRequest) {
        HttpResponseHandler<ApiSubjectsGetResult> responseHandler = protocolFactory.createResponseHandler(new JsonOperationMetadata().withPayloadJson(true)
                .withHasStreamingSuccessResponse(false), new ApiSubjectsGetResultJsonUnmarshaller());

        HttpResponseHandler<SdkBaseException> errorResponseHandler = createErrorResponseHandler();

        return clientHandler.execute(new ClientExecutionParams<ApiSubjectsGetRequest, ApiSubjectsGetResult>()
                .withMarshaller(new ApiSubjectsGetRequestProtocolMarshaller(protocolFactory)).withResponseHandler(responseHandler)
                .withErrorResponseHandler(errorResponseHandler).withInput(apiSubjectsGetRequest));
    }

    /**
     * @param apiSubjectsPostRequest
     * @return Result of the ApiSubjectsPost operation returned by the service.
     * @sample NECID.ApiSubjectsPost
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/api-1.1/ApiSubjectsPost" target="_top">AWS API
     *      Documentation</a>
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
     * @param bulkRegisterRequest
     * @return Result of the BulkRegister operation returned by the service.
     * @sample NECID.BulkRegister
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/api-1.1/BulkRegister" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public BulkRegisterResult bulkRegister(BulkRegisterRequest bulkRegisterRequest) {
        HttpResponseHandler<BulkRegisterResult> responseHandler = protocolFactory.createResponseHandler(new JsonOperationMetadata().withPayloadJson(true)
                .withHasStreamingSuccessResponse(false), new BulkRegisterResultJsonUnmarshaller());

        HttpResponseHandler<SdkBaseException> errorResponseHandler = createErrorResponseHandler();

        return clientHandler.execute(new ClientExecutionParams<BulkRegisterRequest, BulkRegisterResult>()
                .withMarshaller(new BulkRegisterRequestProtocolMarshaller(protocolFactory)).withResponseHandler(responseHandler)
                .withErrorResponseHandler(errorResponseHandler).withInput(bulkRegisterRequest));
    }

    /**
     * @param createTagRequest
     * @return Result of the CreateTag operation returned by the service.
     * @sample NECID.CreateTag
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/api-1.1/CreateTag" target="_top">AWS API Documentation</a>
     */
    @Override
    public CreateTagResult createTag(CreateTagRequest createTagRequest) {
        HttpResponseHandler<CreateTagResult> responseHandler = protocolFactory.createResponseHandler(new JsonOperationMetadata().withPayloadJson(true)
                .withHasStreamingSuccessResponse(false), new CreateTagResultJsonUnmarshaller());

        HttpResponseHandler<SdkBaseException> errorResponseHandler = createErrorResponseHandler();

        return clientHandler.execute(new ClientExecutionParams<CreateTagRequest, CreateTagResult>()
                .withMarshaller(new CreateTagRequestProtocolMarshaller(protocolFactory)).withResponseHandler(responseHandler)
                .withErrorResponseHandler(errorResponseHandler).withInput(createTagRequest));
    }

    /**
     * @param deleteTagRequest
     * @return Result of the DeleteTag operation returned by the service.
     * @sample NECID.DeleteTag
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/api-1.1/DeleteTag" target="_top">AWS API Documentation</a>
     */
    @Override
    public DeleteTagResult deleteTag(DeleteTagRequest deleteTagRequest) {
        HttpResponseHandler<DeleteTagResult> responseHandler = protocolFactory.createResponseHandler(new JsonOperationMetadata().withPayloadJson(true)
                .withHasStreamingSuccessResponse(false), new DeleteTagResultJsonUnmarshaller());

        HttpResponseHandler<SdkBaseException> errorResponseHandler = createErrorResponseHandler();

        return clientHandler.execute(new ClientExecutionParams<DeleteTagRequest, DeleteTagResult>()
                .withMarshaller(new DeleteTagRequestProtocolMarshaller(protocolFactory)).withResponseHandler(responseHandler)
                .withErrorResponseHandler(errorResponseHandler).withInput(deleteTagRequest));
    }

    /**
     * @param getRequest
     * @return Result of the Get operation returned by the service.
     * @sample NECID.Get
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/api-1.1/Get" target="_top">AWS API Documentation</a>
     */
    @Override
    public GetResult get(GetRequest getRequest) {
        HttpResponseHandler<GetResult> responseHandler = protocolFactory.createResponseHandler(new JsonOperationMetadata().withPayloadJson(true)
                .withHasStreamingSuccessResponse(false), new GetResultJsonUnmarshaller());

        HttpResponseHandler<SdkBaseException> errorResponseHandler = createErrorResponseHandler();

        return clientHandler.execute(new ClientExecutionParams<GetRequest, GetResult>().withMarshaller(new GetRequestProtocolMarshaller(protocolFactory))
                .withResponseHandler(responseHandler).withErrorResponseHandler(errorResponseHandler).withInput(getRequest));
    }

    /**
     * @param getBulkRegisterProgressRequest
     * @return Result of the GetBulkRegisterProgress operation returned by the service.
     * @sample NECID.GetBulkRegisterProgress
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/api-1.1/GetBulkRegisterProgress" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public GetBulkRegisterProgressResult getBulkRegisterProgress(GetBulkRegisterProgressRequest getBulkRegisterProgressRequest) {
        HttpResponseHandler<GetBulkRegisterProgressResult> responseHandler = protocolFactory.createResponseHandler(
                new JsonOperationMetadata().withPayloadJson(true).withHasStreamingSuccessResponse(false), new GetBulkRegisterProgressResultJsonUnmarshaller());

        HttpResponseHandler<SdkBaseException> errorResponseHandler = createErrorResponseHandler();

        return clientHandler.execute(new ClientExecutionParams<GetBulkRegisterProgressRequest, GetBulkRegisterProgressResult>()
                .withMarshaller(new GetBulkRegisterProgressRequestProtocolMarshaller(protocolFactory)).withResponseHandler(responseHandler)
                .withErrorResponseHandler(errorResponseHandler).withInput(getBulkRegisterProgressRequest));
    }

    /**
     * @param getBulkRegisterProgressPagedRequest
     * @return Result of the GetBulkRegisterProgressPaged operation returned by the service.
     * @sample NECID.GetBulkRegisterProgressPaged
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/api-1.1/GetBulkRegisterProgressPaged" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public GetBulkRegisterProgressPagedResult getBulkRegisterProgressPaged(GetBulkRegisterProgressPagedRequest getBulkRegisterProgressPagedRequest) {
        HttpResponseHandler<GetBulkRegisterProgressPagedResult> responseHandler = protocolFactory.createResponseHandler(new JsonOperationMetadata()
                .withPayloadJson(true).withHasStreamingSuccessResponse(false), new GetBulkRegisterProgressPagedResultJsonUnmarshaller());

        HttpResponseHandler<SdkBaseException> errorResponseHandler = createErrorResponseHandler();

        return clientHandler.execute(new ClientExecutionParams<GetBulkRegisterProgressPagedRequest, GetBulkRegisterProgressPagedResult>()
                .withMarshaller(new GetBulkRegisterProgressPagedRequestProtocolMarshaller(protocolFactory)).withResponseHandler(responseHandler)
                .withErrorResponseHandler(errorResponseHandler).withInput(getBulkRegisterProgressPagedRequest));
    }

    /**
     * @param getHealthRequest
     * @return Result of the GetHealth operation returned by the service.
     * @sample NECID.GetHealth
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/api-1.1/GetHealth" target="_top">AWS API Documentation</a>
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
     * @param updateTagRequest
     * @return Result of the UpdateTag operation returned by the service.
     * @sample NECID.UpdateTag
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/api-1.1/UpdateTag" target="_top">AWS API Documentation</a>
     */
    @Override
    public UpdateTagResult updateTag(UpdateTagRequest updateTagRequest) {
        HttpResponseHandler<UpdateTagResult> responseHandler = protocolFactory.createResponseHandler(new JsonOperationMetadata().withPayloadJson(true)
                .withHasStreamingSuccessResponse(false), new UpdateTagResultJsonUnmarshaller());

        HttpResponseHandler<SdkBaseException> errorResponseHandler = createErrorResponseHandler();

        return clientHandler.execute(new ClientExecutionParams<UpdateTagRequest, UpdateTagResult>()
                .withMarshaller(new UpdateTagRequestProtocolMarshaller(protocolFactory)).withResponseHandler(responseHandler)
                .withErrorResponseHandler(errorResponseHandler).withInput(updateTagRequest));
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
