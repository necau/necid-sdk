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
 * HeadAreaMarshaller
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
@SdkInternalApi
public class HeadAreaMarshaller {

    private static final MarshallingInfo<String> BOTTOM_BINDING = MarshallingInfo.builder(MarshallingType.STRING).marshallLocation(MarshallLocation.PAYLOAD)
            .marshallLocationName("bottom").build();
    private static final MarshallingInfo<String> LEFT_BINDING = MarshallingInfo.builder(MarshallingType.STRING).marshallLocation(MarshallLocation.PAYLOAD)
            .marshallLocationName("left").build();
    private static final MarshallingInfo<String> RIGHT_BINDING = MarshallingInfo.builder(MarshallingType.STRING).marshallLocation(MarshallLocation.PAYLOAD)
            .marshallLocationName("right").build();
    private static final MarshallingInfo<String> TOP_BINDING = MarshallingInfo.builder(MarshallingType.STRING).marshallLocation(MarshallLocation.PAYLOAD)
            .marshallLocationName("top").build();

    private static final HeadAreaMarshaller instance = new HeadAreaMarshaller();

    public static HeadAreaMarshaller getInstance() {
        return instance;
    }

    /**
     * Marshall the given parameter object.
     */
    public void marshall(HeadArea headArea, ProtocolMarshaller protocolMarshaller) {

        if (headArea == null) {
            throw new SdkClientException("Invalid argument passed to marshall(...)");
        }

        try {
            protocolMarshaller.marshall(headArea.getBottom(), BOTTOM_BINDING);
            protocolMarshaller.marshall(headArea.getLeft(), LEFT_BINDING);
            protocolMarshaller.marshall(headArea.getRight(), RIGHT_BINDING);
            protocolMarshaller.marshall(headArea.getTop(), TOP_BINDING);
        } catch (Exception e) {
            throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
        }
    }

}
