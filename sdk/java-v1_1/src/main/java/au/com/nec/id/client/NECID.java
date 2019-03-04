/**
 * null
 */
package au.com.nec.id.client;

import javax.annotation.Generated;

import com.amazonaws.*;
import com.amazonaws.opensdk.*;
import com.amazonaws.opensdk.model.*;
import com.amazonaws.regions.*;

import au.com.nec.id.client.model.*;

/**
 * Interface for accessing NECID.
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
public interface NECID {

    /**
     * @param apiFaceExtractPostRequest
     * @return Result of the ApiFaceExtractPost operation returned by the service.
     * @throws NotFoundException
     * @sample NECID.ApiFaceExtractPost
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/api-1.1/ApiFaceExtractPost" target="_top">AWS API
     *      Documentation</a>
     */
    ApiFaceExtractPostResult apiFaceExtractPost(ApiFaceExtractPostRequest apiFaceExtractPostRequest);

    /**
     * @param apiFaceSearchPostRequest
     * @return Result of the ApiFaceSearchPost operation returned by the service.
     * @throws NotFoundException
     * @sample NECID.ApiFaceSearchPost
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/api-1.1/ApiFaceSearchPost" target="_top">AWS API
     *      Documentation</a>
     */
    ApiFaceSearchPostResult apiFaceSearchPost(ApiFaceSearchPostRequest apiFaceSearchPostRequest);

    /**
     * @param apiFaceVerifyPostRequest
     * @return Result of the ApiFaceVerifyPost operation returned by the service.
     * @throws NotFoundException
     * @sample NECID.ApiFaceVerifyPost
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/api-1.1/ApiFaceVerifyPost" target="_top">AWS API
     *      Documentation</a>
     */
    ApiFaceVerifyPostResult apiFaceVerifyPost(ApiFaceVerifyPostRequest apiFaceVerifyPostRequest);

    /**
     * @param apiSubjectsByIdDeleteRequest
     * @return Result of the ApiSubjectsByIdDelete operation returned by the service.
     * @throws NotFoundException
     * @sample NECID.ApiSubjectsByIdDelete
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/api-1.1/ApiSubjectsByIdDelete" target="_top">AWS API
     *      Documentation</a>
     */
    ApiSubjectsByIdDeleteResult apiSubjectsByIdDelete(ApiSubjectsByIdDeleteRequest apiSubjectsByIdDeleteRequest);

    /**
     * @param apiSubjectsByIdEventByIdDeleteRequest
     * @return Result of the ApiSubjectsByIdEventByIdDelete operation returned by the service.
     * @throws NotFoundException
     * @sample NECID.ApiSubjectsByIdEventByIdDelete
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/api-1.1/ApiSubjectsByIdEventByIdDelete" target="_top">AWS
     *      API Documentation</a>
     */
    ApiSubjectsByIdEventByIdDeleteResult apiSubjectsByIdEventByIdDelete(ApiSubjectsByIdEventByIdDeleteRequest apiSubjectsByIdEventByIdDeleteRequest);

    /**
     * @param apiSubjectsByIdEventByIdPutRequest
     * @return Result of the ApiSubjectsByIdEventByIdPut operation returned by the service.
     * @throws NotFoundException
     * @sample NECID.ApiSubjectsByIdEventByIdPut
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/api-1.1/ApiSubjectsByIdEventByIdPut" target="_top">AWS API
     *      Documentation</a>
     */
    ApiSubjectsByIdEventByIdPutResult apiSubjectsByIdEventByIdPut(ApiSubjectsByIdEventByIdPutRequest apiSubjectsByIdEventByIdPutRequest);

    /**
     * @param apiSubjectsByIdEventsGetRequest
     * @return Result of the ApiSubjectsByIdEventsGet operation returned by the service.
     * @throws NotFoundException
     * @sample NECID.ApiSubjectsByIdEventsGet
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/api-1.1/ApiSubjectsByIdEventsGet" target="_top">AWS API
     *      Documentation</a>
     */
    ApiSubjectsByIdEventsGetResult apiSubjectsByIdEventsGet(ApiSubjectsByIdEventsGetRequest apiSubjectsByIdEventsGetRequest);

    /**
     * @param apiSubjectsByIdEventsPostRequest
     * @return Result of the ApiSubjectsByIdEventsPost operation returned by the service.
     * @throws NotFoundException
     * @sample NECID.ApiSubjectsByIdEventsPost
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/api-1.1/ApiSubjectsByIdEventsPost" target="_top">AWS API
     *      Documentation</a>
     */
    ApiSubjectsByIdEventsPostResult apiSubjectsByIdEventsPost(ApiSubjectsByIdEventsPostRequest apiSubjectsByIdEventsPostRequest);

    /**
     * @param apiSubjectsByIdPutRequest
     * @return Result of the ApiSubjectsByIdPut operation returned by the service.
     * @throws NotFoundException
     * @sample NECID.ApiSubjectsByIdPut
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/api-1.1/ApiSubjectsByIdPut" target="_top">AWS API
     *      Documentation</a>
     */
    ApiSubjectsByIdPutResult apiSubjectsByIdPut(ApiSubjectsByIdPutRequest apiSubjectsByIdPutRequest);

    /**
     * @param apiSubjectsGetRequest
     * @return Result of the ApiSubjectsGet operation returned by the service.
     * @sample NECID.ApiSubjectsGet
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/api-1.1/ApiSubjectsGet" target="_top">AWS API
     *      Documentation</a>
     */
    ApiSubjectsGetResult apiSubjectsGet(ApiSubjectsGetRequest apiSubjectsGetRequest);

    /**
     * @param apiSubjectsPostRequest
     * @return Result of the ApiSubjectsPost operation returned by the service.
     * @sample NECID.ApiSubjectsPost
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/api-1.1/ApiSubjectsPost" target="_top">AWS API
     *      Documentation</a>
     */
    ApiSubjectsPostResult apiSubjectsPost(ApiSubjectsPostRequest apiSubjectsPostRequest);

    /**
     * @param bulkRegisterRequest
     * @return Result of the BulkRegister operation returned by the service.
     * @sample NECID.BulkRegister
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/api-1.1/BulkRegister" target="_top">AWS API
     *      Documentation</a>
     */
    BulkRegisterResult bulkRegister(BulkRegisterRequest bulkRegisterRequest);

    /**
     * @param createTagRequest
     * @return Result of the CreateTag operation returned by the service.
     * @sample NECID.CreateTag
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/api-1.1/CreateTag" target="_top">AWS API Documentation</a>
     */
    CreateTagResult createTag(CreateTagRequest createTagRequest);

    /**
     * @param deleteTagRequest
     * @return Result of the DeleteTag operation returned by the service.
     * @sample NECID.DeleteTag
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/api-1.1/DeleteTag" target="_top">AWS API Documentation</a>
     */
    DeleteTagResult deleteTag(DeleteTagRequest deleteTagRequest);

    /**
     * @param getRequest
     * @return Result of the Get operation returned by the service.
     * @sample NECID.Get
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/api-1.1/Get" target="_top">AWS API Documentation</a>
     */
    GetResult get(GetRequest getRequest);

    /**
     * @param getBulkRegisterProgressRequest
     * @return Result of the GetBulkRegisterProgress operation returned by the service.
     * @sample NECID.GetBulkRegisterProgress
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/api-1.1/GetBulkRegisterProgress" target="_top">AWS API
     *      Documentation</a>
     */
    GetBulkRegisterProgressResult getBulkRegisterProgress(GetBulkRegisterProgressRequest getBulkRegisterProgressRequest);

    /**
     * @param getBulkRegisterProgressPagedRequest
     * @return Result of the GetBulkRegisterProgressPaged operation returned by the service.
     * @sample NECID.GetBulkRegisterProgressPaged
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/api-1.1/GetBulkRegisterProgressPaged" target="_top">AWS API
     *      Documentation</a>
     */
    GetBulkRegisterProgressPagedResult getBulkRegisterProgressPaged(GetBulkRegisterProgressPagedRequest getBulkRegisterProgressPagedRequest);

    /**
     * @param getHealthRequest
     * @return Result of the GetHealth operation returned by the service.
     * @sample NECID.GetHealth
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/api-1.1/GetHealth" target="_top">AWS API Documentation</a>
     */
    GetHealthResult getHealth(GetHealthRequest getHealthRequest);

    /**
     * @param updateTagRequest
     * @return Result of the UpdateTag operation returned by the service.
     * @sample NECID.UpdateTag
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/api-1.1/UpdateTag" target="_top">AWS API Documentation</a>
     */
    UpdateTagResult updateTag(UpdateTagRequest updateTagRequest);

    /**
     * @return Create new instance of builder with all defaults set.
     */
    public static NECIDClientBuilder builder() {
        return new NECIDClientBuilder();
    }

    /**
     * Shuts down this client object, releasing any resources that might be held open. This is an optional method, and
     * callers are not expected to call it, but can if they want to explicitly release any open resources. Once a client
     * has been shutdown, it should not be used to make any more requests.
     */
    void shutdown();

}
