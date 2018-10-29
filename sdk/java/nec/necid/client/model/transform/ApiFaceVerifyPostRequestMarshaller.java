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
 * ApiFaceVerifyPostRequestMarshaller
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
@SdkInternalApi
public class ApiFaceVerifyPostRequestMarshaller {

    private static final ApiFaceVerifyPostRequestMarshaller instance = new ApiFaceVerifyPostRequestMarshaller();

    public static ApiFaceVerifyPostRequestMarshaller getInstance() {
        return instance;
    }

    /**
     * Marshall the given parameter object.
     */
    public void marshall(ApiFaceVerifyPostRequest apiFaceVerifyPostRequest, ProtocolMarshaller protocolMarshaller) {

        if (apiFaceVerifyPostRequest == null) {
            throw new SdkClientException("Invalid argument passed to marshall(...)");
        }

        try {
        } catch (Exception e) {
            throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
        }
    }

}
