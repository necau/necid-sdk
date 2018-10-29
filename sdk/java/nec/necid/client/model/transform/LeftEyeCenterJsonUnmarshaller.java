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
 * LeftEyeCenter JSON Unmarshaller
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
public class LeftEyeCenterJsonUnmarshaller implements Unmarshaller<LeftEyeCenter, JsonUnmarshallerContext> {

    public LeftEyeCenter unmarshall(JsonUnmarshallerContext context) throws Exception {
        LeftEyeCenter leftEyeCenter = new LeftEyeCenter();

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
                if (context.testExpression("x", targetDepth)) {
                    context.nextToken();
                    leftEyeCenter.setX(context.getUnmarshaller(String.class).unmarshall(context));
                }
                if (context.testExpression("y", targetDepth)) {
                    context.nextToken();
                    leftEyeCenter.setY(context.getUnmarshaller(String.class).unmarshall(context));
                }
            } else if (token == END_ARRAY || token == END_OBJECT) {
                if (context.getLastParsedParentElement() == null || context.getLastParsedParentElement().equals(currentParentElement)) {
                    if (context.getCurrentDepth() <= originalDepth)
                        break;
                }
            }
            token = context.nextToken();
        }

        return leftEyeCenter;
    }

    private static LeftEyeCenterJsonUnmarshaller instance;

    public static LeftEyeCenterJsonUnmarshaller getInstance() {
        if (instance == null)
            instance = new LeftEyeCenterJsonUnmarshaller();
        return instance;
    }
}
