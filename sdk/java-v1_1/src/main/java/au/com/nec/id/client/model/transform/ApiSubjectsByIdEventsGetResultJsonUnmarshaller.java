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
 * ApiSubjectsByIdEventsGetResult JSON Unmarshaller
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
public class ApiSubjectsByIdEventsGetResultJsonUnmarshaller implements Unmarshaller<ApiSubjectsByIdEventsGetResult, JsonUnmarshallerContext> {

    public ApiSubjectsByIdEventsGetResult unmarshall(JsonUnmarshallerContext context) throws Exception {
        ApiSubjectsByIdEventsGetResult apiSubjectsByIdEventsGetResult = new ApiSubjectsByIdEventsGetResult();

        int originalDepth = context.getCurrentDepth();
        String currentParentElement = context.getCurrentParentElement();
        int targetDepth = originalDepth + 1;

        JsonToken token = context.getCurrentToken();
        if (token == null)
            token = context.nextToken();
        if (token == VALUE_NULL) {
            return apiSubjectsByIdEventsGetResult;
        }

        while (true) {
            if (token == null)
                break;

            apiSubjectsByIdEventsGetResult.setEvents(EventsJsonUnmarshaller.getInstance().unmarshall(context));
            token = context.nextToken();
        }

        return apiSubjectsByIdEventsGetResult;
    }

    private static ApiSubjectsByIdEventsGetResultJsonUnmarshaller instance;

    public static ApiSubjectsByIdEventsGetResultJsonUnmarshaller getInstance() {
        if (instance == null)
            instance = new ApiSubjectsByIdEventsGetResultJsonUnmarshaller();
        return instance;
    }
}
