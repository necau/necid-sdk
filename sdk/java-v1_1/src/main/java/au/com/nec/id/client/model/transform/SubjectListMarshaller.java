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
 * SubjectListMarshaller
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
@SdkInternalApi
public class SubjectListMarshaller {

    private static final MarshallingInfo<List> SUBJECTS_BINDING = MarshallingInfo.builder(MarshallingType.LIST).marshallLocation(MarshallLocation.PAYLOAD)
            .marshallLocationName("subjects").build();
    private static final MarshallingInfo<Integer> TOTAL_BINDING = MarshallingInfo.builder(MarshallingType.INTEGER).marshallLocation(MarshallLocation.PAYLOAD)
            .marshallLocationName("total").build();

    private static final SubjectListMarshaller instance = new SubjectListMarshaller();

    public static SubjectListMarshaller getInstance() {
        return instance;
    }

    /**
     * Marshall the given parameter object.
     */
    public void marshall(SubjectList subjectList, ProtocolMarshaller protocolMarshaller) {

        if (subjectList == null) {
            throw new SdkClientException("Invalid argument passed to marshall(...)");
        }

        try {
            protocolMarshaller.marshall(subjectList.getSubjects(), SUBJECTS_BINDING);
            protocolMarshaller.marshall(subjectList.getTotal(), TOTAL_BINDING);
        } catch (Exception e) {
            throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
        }
    }

}
