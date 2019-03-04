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
 * GetBulkRegisterProgressRequestMarshaller
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
@SdkInternalApi
public class GetBulkRegisterProgressRequestMarshaller {

    private static final MarshallingInfo<String> BATCHID_BINDING = MarshallingInfo.builder(MarshallingType.STRING).marshallLocation(MarshallLocation.PATH)
            .marshallLocationName("batchId").build();

    private static final GetBulkRegisterProgressRequestMarshaller instance = new GetBulkRegisterProgressRequestMarshaller();

    public static GetBulkRegisterProgressRequestMarshaller getInstance() {
        return instance;
    }

    /**
     * Marshall the given parameter object.
     */
    public void marshall(GetBulkRegisterProgressRequest getBulkRegisterProgressRequest, ProtocolMarshaller protocolMarshaller) {

        if (getBulkRegisterProgressRequest == null) {
            throw new SdkClientException("Invalid argument passed to marshall(...)");
        }

        try {
            protocolMarshaller.marshall(getBulkRegisterProgressRequest.getBatchId(), BATCHID_BINDING);
        } catch (Exception e) {
            throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
        }
    }

}
