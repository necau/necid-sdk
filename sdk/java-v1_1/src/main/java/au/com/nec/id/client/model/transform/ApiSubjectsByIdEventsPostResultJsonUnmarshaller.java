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
 * ApiSubjectsByIdEventsPostResult JSON Unmarshaller
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
public class ApiSubjectsByIdEventsPostResultJsonUnmarshaller implements Unmarshaller<ApiSubjectsByIdEventsPostResult, JsonUnmarshallerContext> {

    public ApiSubjectsByIdEventsPostResult unmarshall(JsonUnmarshallerContext context) throws Exception {
        ApiSubjectsByIdEventsPostResult apiSubjectsByIdEventsPostResult = new ApiSubjectsByIdEventsPostResult();

        int originalDepth = context.getCurrentDepth();
        String currentParentElement = context.getCurrentParentElement();
        int targetDepth = originalDepth + 1;

        JsonToken token = context.getCurrentToken();
        if (token == null)
            token = context.nextToken();
        if (token == VALUE_NULL) {
            return apiSubjectsByIdEventsPostResult;
        }

        while (true) {
            if (token == null)
                break;

            apiSubjectsByIdEventsPostResult.setEvent(EventJsonUnmarshaller.getInstance().unmarshall(context));
            token = context.nextToken();
        }

        return apiSubjectsByIdEventsPostResult;
    }

    private static ApiSubjectsByIdEventsPostResultJsonUnmarshaller instance;

    public static ApiSubjectsByIdEventsPostResultJsonUnmarshaller getInstance() {
        if (instance == null)
            instance = new ApiSubjectsByIdEventsPostResultJsonUnmarshaller();
        return instance;
    }
}
