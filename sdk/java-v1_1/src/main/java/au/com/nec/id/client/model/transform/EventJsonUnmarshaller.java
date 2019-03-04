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
 * Event JSON Unmarshaller
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
public class EventJsonUnmarshaller implements Unmarshaller<Event, JsonUnmarshallerContext> {

    public Event unmarshall(JsonUnmarshallerContext context) throws Exception {
        Event event = new Event();

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
                if (context.testExpression("id", targetDepth)) {
                    context.nextToken();
                    event.setId(context.getUnmarshaller(String.class).unmarshall(context));
                }
                if (context.testExpression("score", targetDepth)) {
                    context.nextToken();
                    event.setScore(context.getUnmarshaller(Integer.class).unmarshall(context));
                }
            } else if (token == END_ARRAY || token == END_OBJECT) {
                if (context.getLastParsedParentElement() == null || context.getLastParsedParentElement().equals(currentParentElement)) {
                    if (context.getCurrentDepth() <= originalDepth)
                        break;
                }
            }
            token = context.nextToken();
        }

        return event;
    }

    private static EventJsonUnmarshaller instance;

    public static EventJsonUnmarshaller getInstance() {
        if (instance == null)
            instance = new EventJsonUnmarshaller();
        return instance;
    }
}
