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
 * HeadArea JSON Unmarshaller
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
public class HeadAreaJsonUnmarshaller implements Unmarshaller<HeadArea, JsonUnmarshallerContext> {

    public HeadArea unmarshall(JsonUnmarshallerContext context) throws Exception {
        HeadArea headArea = new HeadArea();

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
                if (context.testExpression("bottom", targetDepth)) {
                    context.nextToken();
                    headArea.setBottom(context.getUnmarshaller(String.class).unmarshall(context));
                }
                if (context.testExpression("left", targetDepth)) {
                    context.nextToken();
                    headArea.setLeft(context.getUnmarshaller(String.class).unmarshall(context));
                }
                if (context.testExpression("right", targetDepth)) {
                    context.nextToken();
                    headArea.setRight(context.getUnmarshaller(String.class).unmarshall(context));
                }
                if (context.testExpression("top", targetDepth)) {
                    context.nextToken();
                    headArea.setTop(context.getUnmarshaller(String.class).unmarshall(context));
                }
            } else if (token == END_ARRAY || token == END_OBJECT) {
                if (context.getLastParsedParentElement() == null || context.getLastParsedParentElement().equals(currentParentElement)) {
                    if (context.getCurrentDepth() <= originalDepth)
                        break;
                }
            }
            token = context.nextToken();
        }

        return headArea;
    }

    private static HeadAreaJsonUnmarshaller instance;

    public static HeadAreaJsonUnmarshaller getInstance() {
        if (instance == null)
            instance = new HeadAreaJsonUnmarshaller();
        return instance;
    }
}
