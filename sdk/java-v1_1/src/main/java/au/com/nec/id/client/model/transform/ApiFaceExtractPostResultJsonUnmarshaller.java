/**
 * null
 */
package au.com.nec.id.client.model.transform;

import java.math.*;

import javax.annotation.Generated;

import au.com.nec.id.client.model.*;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers.*;
import com.amazonaws.transform.*;

import com.fasterxml.jackson.core.JsonToken;
import static com.fasterxml.jackson.core.JsonToken.*;

/**
 * ApiFaceExtractPostResult JSON Unmarshaller
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
public class ApiFaceExtractPostResultJsonUnmarshaller implements Unmarshaller<ApiFaceExtractPostResult, JsonUnmarshallerContext> {

    public ApiFaceExtractPostResult unmarshall(JsonUnmarshallerContext context) throws Exception {
        ApiFaceExtractPostResult apiFaceExtractPostResult = new ApiFaceExtractPostResult();

        int originalDepth = context.getCurrentDepth();
        String currentParentElement = context.getCurrentParentElement();
        int targetDepth = originalDepth + 1;

        JsonToken token = context.getCurrentToken();
        if (token == null)
            token = context.nextToken();
        if (token == VALUE_NULL) {
            return apiFaceExtractPostResult;
        }

        while (true) {
            if (token == null)
                break;

            apiFaceExtractPostResult.setExtractResult(ExtractResultJsonUnmarshaller.getInstance().unmarshall(context));
            token = context.nextToken();
        }

        return apiFaceExtractPostResult;
    }

    private static ApiFaceExtractPostResultJsonUnmarshaller instance;

    public static ApiFaceExtractPostResultJsonUnmarshaller getInstance() {
        if (instance == null)
            instance = new ApiFaceExtractPostResultJsonUnmarshaller();
        return instance;
    }
}
