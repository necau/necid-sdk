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
 * JobStatusMarshaller
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
@SdkInternalApi
public class JobStatusMarshaller {

    private static final MarshallingInfo<Integer> ATTEMPTS_BINDING = MarshallingInfo.builder(MarshallingType.INTEGER)
            .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("attempts").build();
    private static final MarshallingInfo<String> ATTRIBUTESJSON_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
            .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("attributesJson").build();
    private static final MarshallingInfo<String> EVENTID_BINDING = MarshallingInfo.builder(MarshallingType.STRING).marshallLocation(MarshallLocation.PAYLOAD)
            .marshallLocationName("eventId").build();
    private static final MarshallingInfo<String> FILENAME_BINDING = MarshallingInfo.builder(MarshallingType.STRING).marshallLocation(MarshallLocation.PAYLOAD)
            .marshallLocationName("filename").build();
    private static final MarshallingInfo<String> ID_BINDING = MarshallingInfo.builder(MarshallingType.STRING).marshallLocation(MarshallLocation.PAYLOAD)
            .marshallLocationName("id").build();
    private static final MarshallingInfo<String> REASON_BINDING = MarshallingInfo.builder(MarshallingType.STRING).marshallLocation(MarshallLocation.PAYLOAD)
            .marshallLocationName("reason").build();
    private static final MarshallingInfo<String> REGISTERSTATUS_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
            .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("registerStatus").build();
    private static final MarshallingInfo<String> STATUS_BINDING = MarshallingInfo.builder(MarshallingType.STRING).marshallLocation(MarshallLocation.PAYLOAD)
            .marshallLocationName("status").build();
    private static final MarshallingInfo<String> SUBJECTID_BINDING = MarshallingInfo.builder(MarshallingType.STRING).marshallLocation(MarshallLocation.PAYLOAD)
            .marshallLocationName("subjectId").build();

    private static final JobStatusMarshaller instance = new JobStatusMarshaller();

    public static JobStatusMarshaller getInstance() {
        return instance;
    }

    /**
     * Marshall the given parameter object.
     */
    public void marshall(JobStatus jobStatus, ProtocolMarshaller protocolMarshaller) {

        if (jobStatus == null) {
            throw new SdkClientException("Invalid argument passed to marshall(...)");
        }

        try {
            protocolMarshaller.marshall(jobStatus.getAttempts(), ATTEMPTS_BINDING);
            protocolMarshaller.marshall(jobStatus.getAttributesJson(), ATTRIBUTESJSON_BINDING);
            protocolMarshaller.marshall(jobStatus.getEventId(), EVENTID_BINDING);
            protocolMarshaller.marshall(jobStatus.getFilename(), FILENAME_BINDING);
            protocolMarshaller.marshall(jobStatus.getId(), ID_BINDING);
            protocolMarshaller.marshall(jobStatus.getReason(), REASON_BINDING);
            protocolMarshaller.marshall(jobStatus.getRegisterStatus(), REGISTERSTATUS_BINDING);
            protocolMarshaller.marshall(jobStatus.getStatus(), STATUS_BINDING);
            protocolMarshaller.marshall(jobStatus.getSubjectId(), SUBJECTID_BINDING);
        } catch (Exception e) {
            throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
        }
    }

}
