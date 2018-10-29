/**
 * null
 */
package nec.necid.client.model.transform;

import javax.annotation.Generated;

import com.amazonaws.SdkClientException;
import nec.necid.client.model.*;

import com.amazonaws.protocol.*;
import com.amazonaws.annotation.SdkInternalApi;

/**
 * ApiSubjectsPostRequestMarshaller
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
@SdkInternalApi
public class ApiSubjectsPostRequestMarshaller {

    private static final ApiSubjectsPostRequestMarshaller instance = new ApiSubjectsPostRequestMarshaller();

    public static ApiSubjectsPostRequestMarshaller getInstance() {
        return instance;
    }

    /**
     * Marshall the given parameter object.
     */
    public void marshall(ApiSubjectsPostRequest apiSubjectsPostRequest, ProtocolMarshaller protocolMarshaller) {

        if (apiSubjectsPostRequest == null) {
            throw new SdkClientException("Invalid argument passed to marshall(...)");
        }

        try {
        } catch (Exception e) {
            throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
        }
    }

}
