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
 * ApiSubjectsByIdEventByIdPutRequest Marshaller
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
@SdkInternalApi
public class ApiSubjectsByIdEventByIdPutRequestProtocolMarshaller implements
        Marshaller<Request<ApiSubjectsByIdEventByIdPutRequest>, ApiSubjectsByIdEventByIdPutRequest> {

    private static final OperationInfo SDK_OPERATION_BINDING = OperationInfo.builder().protocol(Protocol.API_GATEWAY)
            .requestUri("/v1.1/subjects/{subjectId}/events/{eventId}").httpMethodName(HttpMethodName.PUT).hasExplicitPayloadMember(false)
            .hasPayloadMembers(false).serviceName("NECID").build();

    private final com.amazonaws.opensdk.protect.protocol.ApiGatewayProtocolFactoryImpl protocolFactory;

    public ApiSubjectsByIdEventByIdPutRequestProtocolMarshaller(com.amazonaws.opensdk.protect.protocol.ApiGatewayProtocolFactoryImpl protocolFactory) {
        this.protocolFactory = protocolFactory;
    }

    public Request<ApiSubjectsByIdEventByIdPutRequest> marshall(ApiSubjectsByIdEventByIdPutRequest apiSubjectsByIdEventByIdPutRequest) {

        if (apiSubjectsByIdEventByIdPutRequest == null) {
            throw new SdkClientException("Invalid argument passed to marshall(...)");
        }

        try {
            final ProtocolRequestMarshaller<ApiSubjectsByIdEventByIdPutRequest> protocolMarshaller = protocolFactory.createProtocolMarshaller(
                    SDK_OPERATION_BINDING, apiSubjectsByIdEventByIdPutRequest);

            protocolMarshaller.startMarshalling();
            ApiSubjectsByIdEventByIdPutRequestMarshaller.getInstance().marshall(apiSubjectsByIdEventByIdPutRequest, protocolMarshaller);
            return protocolMarshaller.finishMarshalling();
        } catch (Exception e) {
            throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
        }
    }

}
