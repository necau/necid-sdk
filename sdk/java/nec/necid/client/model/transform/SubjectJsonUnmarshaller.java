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
 * Subject JSON Unmarshaller
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
public class SubjectJsonUnmarshaller implements Unmarshaller<Subject, JsonUnmarshallerContext> {

    public Subject unmarshall(JsonUnmarshallerContext context) throws Exception {
        Subject subject = new Subject();

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
                if (context.testExpression("attributes", targetDepth)) {
                    context.nextToken();
                    subject.setAttributes(AttributesJsonUnmarshaller.getInstance().unmarshall(context));
                }
                if (context.testExpression("id", targetDepth)) {
                    context.nextToken();
                    subject.setId(context.getUnmarshaller(String.class).unmarshall(context));
                }
            } else if (token == END_ARRAY || token == END_OBJECT) {
                if (context.getLastParsedParentElement() == null || context.getLastParsedParentElement().equals(currentParentElement)) {
                    if (context.getCurrentDepth() <= originalDepth)
                        break;
                }
            }
            token = context.nextToken();
        }

        return subject;
    }

    private static SubjectJsonUnmarshaller instance;

    public static SubjectJsonUnmarshaller getInstance() {
        if (instance == null)
            instance = new SubjectJsonUnmarshaller();
        return instance;
    }
}
