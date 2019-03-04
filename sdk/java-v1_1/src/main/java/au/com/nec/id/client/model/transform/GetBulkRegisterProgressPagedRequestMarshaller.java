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
 * GetBulkRegisterProgressPagedRequestMarshaller
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
@SdkInternalApi
public class GetBulkRegisterProgressPagedRequestMarshaller {

    private static final MarshallingInfo<String> BATCHID_BINDING = MarshallingInfo.builder(MarshallingType.STRING).marshallLocation(MarshallLocation.PATH)
            .marshallLocationName("batchId").build();
    private static final MarshallingInfo<String> PAGINGID_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
            .marshallLocation(MarshallLocation.QUERY_PARAM).marshallLocationName("pagingId").build();

    private static final GetBulkRegisterProgressPagedRequestMarshaller instance = new GetBulkRegisterProgressPagedRequestMarshaller();

    public static GetBulkRegisterProgressPagedRequestMarshaller getInstance() {
        return instance;
    }

    /**
     * Marshall the given parameter object.
     */
    public void marshall(GetBulkRegisterProgressPagedRequest getBulkRegisterProgressPagedRequest, ProtocolMarshaller protocolMarshaller) {

        if (getBulkRegisterProgressPagedRequest == null) {
            throw new SdkClientException("Invalid argument passed to marshall(...)");
        }

        try {
            protocolMarshaller.marshall(getBulkRegisterProgressPagedRequest.getBatchId(), BATCHID_BINDING);
            protocolMarshaller.marshall(getBulkRegisterProgressPagedRequest.getPagingId(), PAGINGID_BINDING);
        } catch (Exception e) {
            throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
        }
    }

}
