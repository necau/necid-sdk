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
 * ApiSubjectsByIdPutRequestMarshaller
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
@SdkInternalApi
public class ApiSubjectsByIdPutRequestMarshaller {

    private static final MarshallingInfo<String> ID_BINDING = MarshallingInfo.builder(MarshallingType.STRING).marshallLocation(MarshallLocation.PATH)
            .marshallLocationName("id").build();

    private static final ApiSubjectsByIdPutRequestMarshaller instance = new ApiSubjectsByIdPutRequestMarshaller();

    public static ApiSubjectsByIdPutRequestMarshaller getInstance() {
        return instance;
    }

    /**
     * Marshall the given parameter object.
     */
    public void marshall(ApiSubjectsByIdPutRequest apiSubjectsByIdPutRequest, ProtocolMarshaller protocolMarshaller) {

        if (apiSubjectsByIdPutRequest == null) {
            throw new SdkClientException("Invalid argument passed to marshall(...)");
        }

        try {
            protocolMarshaller.marshall(apiSubjectsByIdPutRequest.getId(), ID_BINDING);
        } catch (Exception e) {
            throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
        }
    }

}
