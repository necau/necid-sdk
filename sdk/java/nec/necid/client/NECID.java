/**
 * null
 */
package nec.necid.client;

import javax.annotation.Generated;

import com.amazonaws.*;
import com.amazonaws.opensdk.*;
import com.amazonaws.opensdk.model.*;
import com.amazonaws.regions.*;

import nec.necid.client.model.*;

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
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/api-2018-10-29T02:37:36Z/ApiFaceExtractPost"
     *      target="_top">AWS API Documentation</a>
     */
    ApiFaceExtractPostResult apiFaceExtractPost(ApiFaceExtractPostRequest apiFaceExtractPostRequest);

    /**
     * @param apiFaceSearchPostRequest
     * @return Result of the ApiFaceSearchPost operation returned by the service.
     * @throws NotFoundException
     * @sample NECID.ApiFaceSearchPost
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/api-2018-10-29T02:37:36Z/ApiFaceSearchPost"
     *      target="_top">AWS API Documentation</a>
     */
    ApiFaceSearchPostResult apiFaceSearchPost(ApiFaceSearchPostRequest apiFaceSearchPostRequest);

    /**
     * @param apiFaceVerifyPostRequest
     * @return Result of the ApiFaceVerifyPost operation returned by the service.
     * @throws NotFoundException
     * @sample NECID.ApiFaceVerifyPost
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/api-2018-10-29T02:37:36Z/ApiFaceVerifyPost"
     *      target="_top">AWS API Documentation</a>
     */
    ApiFaceVerifyPostResult apiFaceVerifyPost(ApiFaceVerifyPostRequest apiFaceVerifyPostRequest);

    /**
     * @param apiSubjectsByIdDeleteRequest
     * @return Result of the ApiSubjectsByIdDelete operation returned by the service.
     * @throws NotFoundException
     * @sample NECID.ApiSubjectsByIdDelete
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/api-2018-10-29T02:37:36Z/ApiSubjectsByIdDelete"
     *      target="_top">AWS API Documentation</a>
     */
    ApiSubjectsByIdDeleteResult apiSubjectsByIdDelete(ApiSubjectsByIdDeleteRequest apiSubjectsByIdDeleteRequest);

    /**
     * @param apiSubjectsByIdPutRequest
     * @return Result of the ApiSubjectsByIdPut operation returned by the service.
     * @throws NotFoundException
     * @sample NECID.ApiSubjectsByIdPut
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/api-2018-10-29T02:37:36Z/ApiSubjectsByIdPut"
     *      target="_top">AWS API Documentation</a>
     */
    ApiSubjectsByIdPutResult apiSubjectsByIdPut(ApiSubjectsByIdPutRequest apiSubjectsByIdPutRequest);

    /**
     * @param apiSubjectsPostRequest
     * @return Result of the ApiSubjectsPost operation returned by the service.
     * @sample NECID.ApiSubjectsPost
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/api-2018-10-29T02:37:36Z/ApiSubjectsPost" target="_top">AWS
     *      API Documentation</a>
     */
    ApiSubjectsPostResult apiSubjectsPost(ApiSubjectsPostRequest apiSubjectsPostRequest);

    /**
     * @param getHealthRequest
     * @return Result of the GetHealth operation returned by the service.
     * @sample NECID.GetHealth
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/api-2018-10-29T02:37:36Z/GetHealth" target="_top">AWS API
     *      Documentation</a>
     */
    GetHealthResult getHealth(GetHealthRequest getHealthRequest);

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
