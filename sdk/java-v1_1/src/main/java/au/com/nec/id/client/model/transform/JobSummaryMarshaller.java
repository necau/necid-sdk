/**
 * null
 */
package au.com.nec.id.client.model.transform;

import java.util.List;
import javax.annotation.Generated;

import com.amazonaws.SdkClientException;
import au.com.nec.id.client.model.*;

import com.amazonaws.protocol.*;
import com.amazonaws.annotation.SdkInternalApi;

/**
 * JobSummaryMarshaller
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
@SdkInternalApi
public class JobSummaryMarshaller {

    private static final MarshallingInfo<String> BATCHID_BINDING = MarshallingInfo.builder(MarshallingType.STRING).marshallLocation(MarshallLocation.PAYLOAD)
            .marshallLocationName("batchId").build();
    private static final MarshallingInfo<String> LASTEVALUATEDKEY_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
            .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("lastEvaluatedKey").build();
    private static final MarshallingInfo<List> PROCESSED_BINDING = MarshallingInfo.builder(MarshallingType.LIST).marshallLocation(MarshallLocation.PAYLOAD)
            .marshallLocationName("processed").build();

    private static final JobSummaryMarshaller instance = new JobSummaryMarshaller();

    public static JobSummaryMarshaller getInstance() {
        return instance;
    }

    /**
     * Marshall the given parameter object.
     */
    public void marshall(JobSummary jobSummary, ProtocolMarshaller protocolMarshaller) {

        if (jobSummary == null) {
            throw new SdkClientException("Invalid argument passed to marshall(...)");
        }

        try {
            protocolMarshaller.marshall(jobSummary.getBatchId(), BATCHID_BINDING);
            protocolMarshaller.marshall(jobSummary.getLastEvaluatedKey(), LASTEVALUATEDKEY_BINDING);
            protocolMarshaller.marshall(jobSummary.getProcessed(), PROCESSED_BINDING);
        } catch (Exception e) {
            throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
        }
    }

}
