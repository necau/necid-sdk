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
 * ApiSubjectsByIdEventByIdDeleteRequestMarshaller
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
@SdkInternalApi
public class ApiSubjectsByIdEventByIdDeleteRequestMarshaller {

    private static final MarshallingInfo<String> EVENTID_BINDING = MarshallingInfo.builder(MarshallingType.STRING).marshallLocation(MarshallLocation.PATH)
            .marshallLocationName("eventId").build();
    private static final MarshallingInfo<String> SUBJECTID_BINDING = MarshallingInfo.builder(MarshallingType.STRING).marshallLocation(MarshallLocation.PATH)
            .marshallLocationName("subjectId").build();

    private static final ApiSubjectsByIdEventByIdDeleteRequestMarshaller instance = new ApiSubjectsByIdEventByIdDeleteRequestMarshaller();

    public static ApiSubjectsByIdEventByIdDeleteRequestMarshaller getInstance() {
        return instance;
    }

    /**
     * Marshall the given parameter object.
     */
    public void marshall(ApiSubjectsByIdEventByIdDeleteRequest apiSubjectsByIdEventByIdDeleteRequest, ProtocolMarshaller protocolMarshaller) {

        if (apiSubjectsByIdEventByIdDeleteRequest == null) {
            throw new SdkClientException("Invalid argument passed to marshall(...)");
        }

        try {
            protocolMarshaller.marshall(apiSubjectsByIdEventByIdDeleteRequest.getEventId(), EVENTID_BINDING);
            protocolMarshaller.marshall(apiSubjectsByIdEventByIdDeleteRequest.getSubjectId(), SUBJECTID_BINDING);
        } catch (Exception e) {
            throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
        }
    }

}
