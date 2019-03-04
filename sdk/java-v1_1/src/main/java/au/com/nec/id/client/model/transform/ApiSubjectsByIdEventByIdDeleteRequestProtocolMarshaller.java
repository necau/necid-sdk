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
 * ApiSubjectsByIdEventByIdDeleteRequest Marshaller
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
@SdkInternalApi
public class ApiSubjectsByIdEventByIdDeleteRequestProtocolMarshaller implements
        Marshaller<Request<ApiSubjectsByIdEventByIdDeleteRequest>, ApiSubjectsByIdEventByIdDeleteRequest> {

    private static final OperationInfo SDK_OPERATION_BINDING = OperationInfo.builder().protocol(Protocol.API_GATEWAY)
            .requestUri("/v1.1/subjects/{subjectId}/events/{eventId}").httpMethodName(HttpMethodName.DELETE).hasExplicitPayloadMember(false)
            .hasPayloadMembers(false).serviceName("NECID").build();

    private final com.amazonaws.opensdk.protect.protocol.ApiGatewayProtocolFactoryImpl protocolFactory;

    public ApiSubjectsByIdEventByIdDeleteRequestProtocolMarshaller(com.amazonaws.opensdk.protect.protocol.ApiGatewayProtocolFactoryImpl protocolFactory) {
        this.protocolFactory = protocolFactory;
    }

    public Request<ApiSubjectsByIdEventByIdDeleteRequest> marshall(ApiSubjectsByIdEventByIdDeleteRequest apiSubjectsByIdEventByIdDeleteRequest) {

        if (apiSubjectsByIdEventByIdDeleteRequest == null) {
            throw new SdkClientException("Invalid argument passed to marshall(...)");
        }

        try {
            final ProtocolRequestMarshaller<ApiSubjectsByIdEventByIdDeleteRequest> protocolMarshaller = protocolFactory.createProtocolMarshaller(
                    SDK_OPERATION_BINDING, apiSubjectsByIdEventByIdDeleteRequest);

            protocolMarshaller.startMarshalling();
            ApiSubjectsByIdEventByIdDeleteRequestMarshaller.getInstance().marshall(apiSubjectsByIdEventByIdDeleteRequest, protocolMarshaller);
            return protocolMarshaller.finishMarshalling();
        } catch (Exception e) {
            throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
        }
    }

}
