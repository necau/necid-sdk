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
 * ApiFaceSearchPostRequestMarshaller
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
@SdkInternalApi
public class ApiFaceSearchPostRequestMarshaller {

    private static final ApiFaceSearchPostRequestMarshaller instance = new ApiFaceSearchPostRequestMarshaller();

    public static ApiFaceSearchPostRequestMarshaller getInstance() {
        return instance;
    }

    /**
     * Marshall the given parameter object.
     */
    public void marshall(ApiFaceSearchPostRequest apiFaceSearchPostRequest, ProtocolMarshaller protocolMarshaller) {

        if (apiFaceSearchPostRequest == null) {
            throw new SdkClientException("Invalid argument passed to marshall(...)");
        }

        try {
        } catch (Exception e) {
            throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
        }
    }

}
