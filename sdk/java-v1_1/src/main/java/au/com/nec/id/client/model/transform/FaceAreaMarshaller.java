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
 * FaceAreaMarshaller
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
@SdkInternalApi
public class FaceAreaMarshaller {

    private static final MarshallingInfo<String> BOTTOM_BINDING = MarshallingInfo.builder(MarshallingType.STRING).marshallLocation(MarshallLocation.PAYLOAD)
            .marshallLocationName("bottom").build();
    private static final MarshallingInfo<String> LEFT_BINDING = MarshallingInfo.builder(MarshallingType.STRING).marshallLocation(MarshallLocation.PAYLOAD)
            .marshallLocationName("left").build();
    private static final MarshallingInfo<String> RIGHT_BINDING = MarshallingInfo.builder(MarshallingType.STRING).marshallLocation(MarshallLocation.PAYLOAD)
            .marshallLocationName("right").build();
    private static final MarshallingInfo<String> TOP_BINDING = MarshallingInfo.builder(MarshallingType.STRING).marshallLocation(MarshallLocation.PAYLOAD)
            .marshallLocationName("top").build();

    private static final FaceAreaMarshaller instance = new FaceAreaMarshaller();

    public static FaceAreaMarshaller getInstance() {
        return instance;
    }

    /**
     * Marshall the given parameter object.
     */
    public void marshall(FaceArea faceArea, ProtocolMarshaller protocolMarshaller) {

        if (faceArea == null) {
            throw new SdkClientException("Invalid argument passed to marshall(...)");
        }

        try {
            protocolMarshaller.marshall(faceArea.getBottom(), BOTTOM_BINDING);
            protocolMarshaller.marshall(faceArea.getLeft(), LEFT_BINDING);
            protocolMarshaller.marshall(faceArea.getRight(), RIGHT_BINDING);
            protocolMarshaller.marshall(faceArea.getTop(), TOP_BINDING);
        } catch (Exception e) {
            throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
        }
    }

}
