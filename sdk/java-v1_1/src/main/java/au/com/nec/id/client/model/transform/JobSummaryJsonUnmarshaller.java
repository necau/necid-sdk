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
 * JobSummary JSON Unmarshaller
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
public class JobSummaryJsonUnmarshaller implements Unmarshaller<JobSummary, JsonUnmarshallerContext> {

    public JobSummary unmarshall(JsonUnmarshallerContext context) throws Exception {
        JobSummary jobSummary = new JobSummary();

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
                if (context.testExpression("batchId", targetDepth)) {
                    context.nextToken();
                    jobSummary.setBatchId(context.getUnmarshaller(String.class).unmarshall(context));
                }
                if (context.testExpression("lastEvaluatedKey", targetDepth)) {
                    context.nextToken();
                    jobSummary.setLastEvaluatedKey(context.getUnmarshaller(String.class).unmarshall(context));
                }
                if (context.testExpression("processed", targetDepth)) {
                    context.nextToken();
                    jobSummary.setProcessed(new ListUnmarshaller<JobStatus>(JobStatusJsonUnmarshaller.getInstance()).unmarshall(context));
                }
            } else if (token == END_ARRAY || token == END_OBJECT) {
                if (context.getLastParsedParentElement() == null || context.getLastParsedParentElement().equals(currentParentElement)) {
                    if (context.getCurrentDepth() <= originalDepth)
                        break;
                }
            }
            token = context.nextToken();
        }

        return jobSummary;
    }

    private static JobSummaryJsonUnmarshaller instance;

    public static JobSummaryJsonUnmarshaller getInstance() {
        if (instance == null)
            instance = new JobSummaryJsonUnmarshaller();
        return instance;
    }
}
