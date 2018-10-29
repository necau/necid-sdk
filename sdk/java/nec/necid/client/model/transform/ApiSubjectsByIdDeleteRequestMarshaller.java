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
 * ApiSubjectsByIdDeleteRequestMarshaller
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
@SdkInternalApi
public class ApiSubjectsByIdDeleteRequestMarshaller {

    private static final MarshallingInfo<String> ID_BINDING = MarshallingInfo.builder(MarshallingType.STRING).marshallLocation(MarshallLocation.PATH)
            .marshallLocationName("id").build();

    private static final ApiSubjectsByIdDeleteRequestMarshaller instance = new ApiSubjectsByIdDeleteRequestMarshaller();

    public static ApiSubjectsByIdDeleteRequestMarshaller getInstance() {
        return instance;
    }

    /**
     * Marshall the given parameter object.
     */
    public void marshall(ApiSubjectsByIdDeleteRequest apiSubjectsByIdDeleteRequest, ProtocolMarshaller protocolMarshaller) {

        if (apiSubjectsByIdDeleteRequest == null) {
            throw new SdkClientException("Invalid argument passed to marshall(...)");
        }

        try {
            protocolMarshaller.marshall(apiSubjectsByIdDeleteRequest.getId(), ID_BINDING);
        } catch (Exception e) {
            throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
        }
    }

}
