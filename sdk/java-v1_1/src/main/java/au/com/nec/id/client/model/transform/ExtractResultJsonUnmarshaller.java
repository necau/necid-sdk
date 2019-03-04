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
 * ExtractResult JSON Unmarshaller
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
public class ExtractResultJsonUnmarshaller implements Unmarshaller<ExtractResult, JsonUnmarshallerContext> {

    public ExtractResult unmarshall(JsonUnmarshallerContext context) throws Exception {
        ExtractResult extractResult = new ExtractResult();

        int originalDepth = context.getCurrentDepth();
        String currentParentElement = context.getCurrentParentElement();
        int targetDepth = originalDepth + 1;

        JsonToken token = context.getCurrentToken();
        if (token == null)
            token = context.nextToken();
        if (token == VALUE_NULL) {
            return null;
        }

        while (true) {
            if (token == null)
                break;

            if (token == FIELD_NAME || token == START_OBJECT) {
                if (context.testExpression("faces", targetDepth)) {
                    context.nextToken();
                    extractResult.setFaces(new ListUnmarshaller<Attributes>(AttributesJsonUnmarshaller.getInstance()).unmarshall(context));
                }
            } else if (token == END_ARRAY || token == END_OBJECT) {
                if (context.getLastParsedParentElement() == null || context.getLastParsedParentElement().equals(currentParentElement)) {
                    if (context.getCurrentDepth() <= originalDepth)
                        break;
                }
            }
            token = context.nextToken();
        }

        return extractResult;
    }

    private static ExtractResultJsonUnmarshaller instance;

    public static ExtractResultJsonUnmarshaller getInstance() {
        if (instance == null)
            instance = new ExtractResultJsonUnmarshaller();
        return instance;
    }
}
