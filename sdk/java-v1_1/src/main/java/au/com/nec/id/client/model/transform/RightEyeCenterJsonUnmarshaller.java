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
 * RightEyeCenter JSON Unmarshaller
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
public class RightEyeCenterJsonUnmarshaller implements Unmarshaller<RightEyeCenter, JsonUnmarshallerContext> {

    public RightEyeCenter unmarshall(JsonUnmarshallerContext context) throws Exception {
        RightEyeCenter rightEyeCenter = new RightEyeCenter();

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
                    rightEyeCenter.setX(context.getUnmarshaller(String.class).unmarshall(context));
                }
                if (context.testExpression("y", targetDepth)) {
                    context.nextToken();
                    rightEyeCenter.setY(context.getUnmarshaller(String.class).unmarshall(context));
                }
            } else if (token == END_ARRAY || token == END_OBJECT) {
                if (context.getLastParsedParentElement() == null || context.getLastParsedParentElement().equals(currentParentElement)) {
                    if (context.getCurrentDepth() <= originalDepth)
                        break;
                }
            }
            token = context.nextToken();
        }

        return rightEyeCenter;
    }

    private static RightEyeCenterJsonUnmarshaller instance;

    public static RightEyeCenterJsonUnmarshaller getInstance() {
        if (instance == null)
            instance = new RightEyeCenterJsonUnmarshaller();
        return instance;
    }
}
