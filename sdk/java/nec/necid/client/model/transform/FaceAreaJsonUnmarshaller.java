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
 * FaceArea JSON Unmarshaller
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
public class FaceAreaJsonUnmarshaller implements Unmarshaller<FaceArea, JsonUnmarshallerContext> {

    public FaceArea unmarshall(JsonUnmarshallerContext context) throws Exception {
        FaceArea faceArea = new FaceArea();

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
                    faceArea.setBottom(context.getUnmarshaller(String.class).unmarshall(context));
                }
                if (context.testExpression("left", targetDepth)) {
                    context.nextToken();
                    faceArea.setLeft(context.getUnmarshaller(String.class).unmarshall(context));
                }
                if (context.testExpression("right", targetDepth)) {
                    context.nextToken();
                    faceArea.setRight(context.getUnmarshaller(String.class).unmarshall(context));
                }
                if (context.testExpression("top", targetDepth)) {
                    context.nextToken();
                    faceArea.setTop(context.getUnmarshaller(String.class).unmarshall(context));
                }
            } else if (token == END_ARRAY || token == END_OBJECT) {
                if (context.getLastParsedParentElement() == null || context.getLastParsedParentElement().equals(currentParentElement)) {
                    if (context.getCurrentDepth() <= originalDepth)
                        break;
                }
            }
            token = context.nextToken();
        }

        return faceArea;
    }

    private static FaceAreaJsonUnmarshaller instance;

    public static FaceAreaJsonUnmarshaller getInstance() {
        if (instance == null)
            instance = new FaceAreaJsonUnmarshaller();
        return instance;
    }
}
