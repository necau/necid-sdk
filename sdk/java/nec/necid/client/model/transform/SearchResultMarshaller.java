/**
 * null
 */
package nec.necid.client.model.transform;

import java.util.List;
import javax.annotation.Generated;

import com.amazonaws.SdkClientException;
import nec.necid.client.model.*;

import com.amazonaws.protocol.*;
import com.amazonaws.annotation.SdkInternalApi;

/**
 * SearchResultMarshaller
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
@SdkInternalApi
public class SearchResultMarshaller {

    private static final MarshallingInfo<StructuredPojo> ATTRIBUTES_BINDING = MarshallingInfo.builder(MarshallingType.STRUCTURED)
            .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("attributes").build();
    private static final MarshallingInfo<List> CANDIDATES_BINDING = MarshallingInfo.builder(MarshallingType.LIST).marshallLocation(MarshallLocation.PAYLOAD)
            .marshallLocationName("candidates").build();

    private static final SearchResultMarshaller instance = new SearchResultMarshaller();

    public static SearchResultMarshaller getInstance() {
        return instance;
    }

    /**
     * Marshall the given parameter object.
     */
    public void marshall(SearchResult searchResult, ProtocolMarshaller protocolMarshaller) {

        if (searchResult == null) {
            throw new SdkClientException("Invalid argument passed to marshall(...)");
        }

        try {
            protocolMarshaller.marshall(searchResult.getAttributes(), ATTRIBUTES_BINDING);
            protocolMarshaller.marshall(searchResult.getCandidates(), CANDIDATES_BINDING);
        } catch (Exception e) {
            throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
        }
    }

}
