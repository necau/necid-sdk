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
 * Attributes JSON Unmarshaller
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
public class AttributesJsonUnmarshaller implements Unmarshaller<Attributes, JsonUnmarshallerContext> {

    public Attributes unmarshall(JsonUnmarshallerContext context) throws Exception {
        Attributes attributes = new Attributes();

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
                if (context.testExpression("faceArea", targetDepth)) {
                    context.nextToken();
                    attributes.setFaceArea(FaceAreaJsonUnmarshaller.getInstance().unmarshall(context));
                }
                if (context.testExpression("facePan", targetDepth)) {
                    context.nextToken();
                    attributes.setFacePan(context.getUnmarshaller(String.class).unmarshall(context));
                }
                if (context.testExpression("faceQualityScore", targetDepth)) {
                    context.nextToken();
                    attributes.setFaceQualityScore(context.getUnmarshaller(String.class).unmarshall(context));
                }
                if (context.testExpression("faceRoll", targetDepth)) {
                    context.nextToken();
                    attributes.setFaceRoll(context.getUnmarshaller(String.class).unmarshall(context));
                }
                if (context.testExpression("faceScore", targetDepth)) {
                    context.nextToken();
                    attributes.setFaceScore(context.getUnmarshaller(String.class).unmarshall(context));
                }
                if (context.testExpression("faceTilt", targetDepth)) {
                    context.nextToken();
                    attributes.setFaceTilt(context.getUnmarshaller(String.class).unmarshall(context));
                }
                if (context.testExpression("frontalFaceScore", targetDepth)) {
                    context.nextToken();
                    attributes.setFrontalFaceScore(context.getUnmarshaller(String.class).unmarshall(context));
                }
                if (context.testExpression("headArea", targetDepth)) {
                    context.nextToken();
                    attributes.setHeadArea(HeadAreaJsonUnmarshaller.getInstance().unmarshall(context));
                }
                if (context.testExpression("leftEyeCenter", targetDepth)) {
                    context.nextToken();
                    attributes.setLeftEyeCenter(LeftEyeCenterJsonUnmarshaller.getInstance().unmarshall(context));
                }
                if (context.testExpression("rightEyeCenter", targetDepth)) {
                    context.nextToken();
                    attributes.setRightEyeCenter(RightEyeCenterJsonUnmarshaller.getInstance().unmarshall(context));
                }
            } else if (token == END_ARRAY || token == END_OBJECT) {
                if (context.getLastParsedParentElement() == null || context.getLastParsedParentElement().equals(currentParentElement)) {
                    if (context.getCurrentDepth() <= originalDepth)
                        break;
                }
            }
            token = context.nextToken();
        }

        return attributes;
    }

    private static AttributesJsonUnmarshaller instance;

    public static AttributesJsonUnmarshaller getInstance() {
        if (instance == null)
            instance = new AttributesJsonUnmarshaller();
        return instance;
    }
}
