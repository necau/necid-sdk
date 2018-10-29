/**
 * null
 */
package nec.necid.client.model.transform;

import java.math.*;

import javax.annotation.Generated;

import nec.necid.client.model.*;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers.*;
import com.amazonaws.transform.*;

import com.fasterxml.jackson.core.JsonToken;
import static com.fasterxml.jackson.core.JsonToken.*;

/**
 * ApiFaceSearchPostResult JSON Unmarshaller
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
public class ApiFaceSearchPostResultJsonUnmarshaller implements Unmarshaller<ApiFaceSearchPostResult, JsonUnmarshallerContext> {

    public ApiFaceSearchPostResult unmarshall(JsonUnmarshallerContext context) throws Exception {
        ApiFaceSearchPostResult apiFaceSearchPostResult = new ApiFaceSearchPostResult();

        int originalDepth = context.getCurrentDepth();
        String currentParentElement = context.getCurrentParentElement();
        int targetDepth = originalDepth + 1;

        JsonToken token = context.getCurrentToken();
        if (token == null)
            token = context.nextToken();
        if (token == VALUE_NULL) {
            return apiFaceSearchPostResult;
        }

        while (true) {
            if (token == null)
                break;

            apiFaceSearchPostResult.setSearchResult(SearchResultJsonUnmarshaller.getInstance().unmarshall(context));
            token = context.nextToken();
        }

        return apiFaceSearchPostResult;
    }

    private static ApiFaceSearchPostResultJsonUnmarshaller instance;

    public static ApiFaceSearchPostResultJsonUnmarshaller getInstance() {
        if (instance == null)
            instance = new ApiFaceSearchPostResultJsonUnmarshaller();
        return instance;
    }
}
