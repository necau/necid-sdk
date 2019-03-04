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
 * JobStatus JSON Unmarshaller
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
public class JobStatusJsonUnmarshaller implements Unmarshaller<JobStatus, JsonUnmarshallerContext> {

    public JobStatus unmarshall(JsonUnmarshallerContext context) throws Exception {
        JobStatus jobStatus = new JobStatus();

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
                if (context.testExpression("attempts", targetDepth)) {
                    context.nextToken();
                    jobStatus.setAttempts(context.getUnmarshaller(Integer.class).unmarshall(context));
                }
                if (context.testExpression("attributesJson", targetDepth)) {
                    context.nextToken();
                    jobStatus.setAttributesJson(context.getUnmarshaller(String.class).unmarshall(context));
                }
                if (context.testExpression("eventId", targetDepth)) {
                    context.nextToken();
                    jobStatus.setEventId(context.getUnmarshaller(String.class).unmarshall(context));
                }
                if (context.testExpression("filename", targetDepth)) {
                    context.nextToken();
                    jobStatus.setFilename(context.getUnmarshaller(String.class).unmarshall(context));
                }
                if (context.testExpression("id", targetDepth)) {
                    context.nextToken();
                    jobStatus.setId(context.getUnmarshaller(String.class).unmarshall(context));
                }
                if (context.testExpression("reason", targetDepth)) {
                    context.nextToken();
                    jobStatus.setReason(context.getUnmarshaller(String.class).unmarshall(context));
                }
                if (context.testExpression("registerStatus", targetDepth)) {
                    context.nextToken();
                    jobStatus.setRegisterStatus(context.getUnmarshaller(String.class).unmarshall(context));
                }
                if (context.testExpression("status", targetDepth)) {
                    context.nextToken();
                    jobStatus.setStatus(context.getUnmarshaller(String.class).unmarshall(context));
                }
                if (context.testExpression("subjectId", targetDepth)) {
                    context.nextToken();
                    jobStatus.setSubjectId(context.getUnmarshaller(String.class).unmarshall(context));
                }
            } else if (token == END_ARRAY || token == END_OBJECT) {
                if (context.getLastParsedParentElement() == null || context.getLastParsedParentElement().equals(currentParentElement)) {
                    if (context.getCurrentDepth() <= originalDepth)
                        break;
                }
            }
            token = context.nextToken();
        }

        return jobStatus;
    }

    private static JobStatusJsonUnmarshaller instance;

    public static JobStatusJsonUnmarshaller getInstance() {
        if (instance == null)
            instance = new JobStatusJsonUnmarshaller();
        return instance;
    }
}
