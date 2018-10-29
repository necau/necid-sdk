/**
 * null
 */
package nec.necid.client.model.transform;

import javax.annotation.Generated;

import com.amazonaws.SdkClientException;
import nec.necid.client.model.*;

import com.amazonaws.protocol.*;
import com.amazonaws.annotation.SdkInternalApi;

/**
 * AttributesMarshaller
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
@SdkInternalApi
public class AttributesMarshaller {

    private static final MarshallingInfo<StructuredPojo> FACEAREA_BINDING = MarshallingInfo.builder(MarshallingType.STRUCTURED)
            .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("faceArea").build();
    private static final MarshallingInfo<String> FACEPAN_BINDING = MarshallingInfo.builder(MarshallingType.STRING).marshallLocation(MarshallLocation.PAYLOAD)
            .marshallLocationName("facePan").build();
    private static final MarshallingInfo<String> FACEQUALITYSCORE_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
            .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("faceQualityScore").build();
    private static final MarshallingInfo<String> FACEROLL_BINDING = MarshallingInfo.builder(MarshallingType.STRING).marshallLocation(MarshallLocation.PAYLOAD)
            .marshallLocationName("faceRoll").build();
    private static final MarshallingInfo<String> FACESCORE_BINDING = MarshallingInfo.builder(MarshallingType.STRING).marshallLocation(MarshallLocation.PAYLOAD)
            .marshallLocationName("faceScore").build();
    private static final MarshallingInfo<String> FACETILT_BINDING = MarshallingInfo.builder(MarshallingType.STRING).marshallLocation(MarshallLocation.PAYLOAD)
            .marshallLocationName("faceTilt").build();
    private static final MarshallingInfo<String> FRONTALFACESCORE_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
            .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("frontalFaceScore").build();
    private static final MarshallingInfo<StructuredPojo> HEADAREA_BINDING = MarshallingInfo.builder(MarshallingType.STRUCTURED)
            .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("headArea").build();
    private static final MarshallingInfo<StructuredPojo> LEFTEYECENTER_BINDING = MarshallingInfo.builder(MarshallingType.STRUCTURED)
            .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("leftEyeCenter").build();
    private static final MarshallingInfo<StructuredPojo> RIGHTEYECENTER_BINDING = MarshallingInfo.builder(MarshallingType.STRUCTURED)
            .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("rightEyeCenter").build();

    private static final AttributesMarshaller instance = new AttributesMarshaller();

    public static AttributesMarshaller getInstance() {
        return instance;
    }

    /**
     * Marshall the given parameter object.
     */
    public void marshall(Attributes attributes, ProtocolMarshaller protocolMarshaller) {

        if (attributes == null) {
            throw new SdkClientException("Invalid argument passed to marshall(...)");
        }

        try {
            protocolMarshaller.marshall(attributes.getFaceArea(), FACEAREA_BINDING);
            protocolMarshaller.marshall(attributes.getFacePan(), FACEPAN_BINDING);
            protocolMarshaller.marshall(attributes.getFaceQualityScore(), FACEQUALITYSCORE_BINDING);
            protocolMarshaller.marshall(attributes.getFaceRoll(), FACEROLL_BINDING);
            protocolMarshaller.marshall(attributes.getFaceScore(), FACESCORE_BINDING);
            protocolMarshaller.marshall(attributes.getFaceTilt(), FACETILT_BINDING);
            protocolMarshaller.marshall(attributes.getFrontalFaceScore(), FRONTALFACESCORE_BINDING);
            protocolMarshaller.marshall(attributes.getHeadArea(), HEADAREA_BINDING);
            protocolMarshaller.marshall(attributes.getLeftEyeCenter(), LEFTEYECENTER_BINDING);
            protocolMarshaller.marshall(attributes.getRightEyeCenter(), RIGHTEYECENTER_BINDING);
        } catch (Exception e) {
            throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
        }
    }

}
