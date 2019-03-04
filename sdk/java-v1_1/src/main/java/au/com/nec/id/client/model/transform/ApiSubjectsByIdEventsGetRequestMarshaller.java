/**
 * null
 */
package au.com.nec.id.client.model.transform;

import javax.annotation.Generated;

import com.amazonaws.SdkClientException;
import au.com.nec.id.client.model.*;

import com.amazonaws.protocol.*;
import com.amazonaws.annotation.SdkInternalApi;

/**
 * ApiSubjectsByIdEventsGetRequestMarshaller
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
@SdkInternalApi
public class ApiSubjectsByIdEventsGetRequestMarshaller {

    private static final MarshallingInfo<String> SUBJECTID_BINDING = MarshallingInfo.builder(MarshallingType.STRING).marshallLocation(MarshallLocation.PATH)
            .marshallLocationName("subjectId").build();

    private static final ApiSubjectsByIdEventsGetRequestMarshaller instance = new ApiSubjectsByIdEventsGetRequestMarshaller();

    public static ApiSubjectsByIdEventsGetRequestMarshaller getInstance() {
        return instance;
    }

    /**
     * Marshall the given parameter object.
     */
    public void marshall(ApiSubjectsByIdEventsGetRequest apiSubjectsByIdEventsGetRequest, ProtocolMarshaller protocolMarshaller) {

        if (apiSubjectsByIdEventsGetRequest == null) {
            throw new SdkClientException("Invalid argument passed to marshall(...)");
        }

        try {
            protocolMarshaller.marshall(apiSubjectsByIdEventsGetRequest.getSubjectId(), SUBJECTID_BINDING);
        } catch (Exception e) {
            throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
        }
    }

}
