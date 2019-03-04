/**
 * null
 */
package au.com.nec.id.client.model.transform;

import javax.annotation.Generated;

import com.amazonaws.SdkClientException;
import com.amazonaws.Request;

import com.amazonaws.http.HttpMethodName;
import au.com.nec.id.client.model.*;
import com.amazonaws.transform.Marshaller;

import com.amazonaws.protocol.*;
import com.amazonaws.annotation.SdkInternalApi;

/**
 * GetBulkRegisterProgressPagedRequest Marshaller
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
@SdkInternalApi
public class GetBulkRegisterProgressPagedRequestProtocolMarshaller implements
        Marshaller<Request<GetBulkRegisterProgressPagedRequest>, GetBulkRegisterProgressPagedRequest> {

    private static final OperationInfo SDK_OPERATION_BINDING = OperationInfo.builder().protocol(Protocol.API_GATEWAY)
            .requestUri("/v1.1/jobs/bulkregister/{batchId}/{pagingId}").httpMethodName(HttpMethodName.GET).hasExplicitPayloadMember(false)
            .hasPayloadMembers(false).serviceName("NECID").build();

    private final com.amazonaws.opensdk.protect.protocol.ApiGatewayProtocolFactoryImpl protocolFactory;

    public GetBulkRegisterProgressPagedRequestProtocolMarshaller(com.amazonaws.opensdk.protect.protocol.ApiGatewayProtocolFactoryImpl protocolFactory) {
        this.protocolFactory = protocolFactory;
    }

    public Request<GetBulkRegisterProgressPagedRequest> marshall(GetBulkRegisterProgressPagedRequest getBulkRegisterProgressPagedRequest) {

        if (getBulkRegisterProgressPagedRequest == null) {
            throw new SdkClientException("Invalid argument passed to marshall(...)");
        }

        try {
            final ProtocolRequestMarshaller<GetBulkRegisterProgressPagedRequest> protocolMarshaller = protocolFactory.createProtocolMarshaller(
                    SDK_OPERATION_BINDING, getBulkRegisterProgressPagedRequest);

            protocolMarshaller.startMarshalling();
            GetBulkRegisterProgressPagedRequestMarshaller.getInstance().marshall(getBulkRegisterProgressPagedRequest, protocolMarshaller);
            return protocolMarshaller.finishMarshalling();
        } catch (Exception e) {
            throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
        }
    }

}
