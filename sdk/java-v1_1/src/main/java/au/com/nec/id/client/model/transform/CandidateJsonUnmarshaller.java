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
 * Candidate JSON Unmarshaller
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
public class CandidateJsonUnmarshaller implements Unmarshaller<Candidate, JsonUnmarshallerContext> {

    public Candidate unmarshall(JsonUnmarshallerContext context) throws Exception {
        Candidate candidate = new Candidate();

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
                if (context.testExpression("events", targetDepth)) {
                    context.nextToken();
                    candidate.setEvents(new ListUnmarshaller<Event>(EventJsonUnmarshaller.getInstance()).unmarshall(context));
                }
                if (context.testExpression("id", targetDepth)) {
                    context.nextToken();
                    candidate.setId(context.getUnmarshaller(String.class).unmarshall(context));
                }
                if (context.testExpression("score", targetDepth)) {
                    context.nextToken();
                    candidate.setScore(context.getUnmarshaller(Integer.class).unmarshall(context));
                }
            } else if (token == END_ARRAY || token == END_OBJECT) {
                if (context.getLastParsedParentElement() == null || context.getLastParsedParentElement().equals(currentParentElement)) {
                    if (context.getCurrentDepth() <= originalDepth)
                        break;
                }
            }
            token = context.nextToken();
        }

        return candidate;
    }

    private static CandidateJsonUnmarshaller instance;

    public static CandidateJsonUnmarshaller getInstance() {
        if (instance == null)
            instance = new CandidateJsonUnmarshaller();
        return instance;
    }
}
