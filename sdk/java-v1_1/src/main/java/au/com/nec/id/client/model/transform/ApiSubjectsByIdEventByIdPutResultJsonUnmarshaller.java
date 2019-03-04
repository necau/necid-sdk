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
 * ApiSubjectsByIdEventByIdPutResult JSON Unmarshaller
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
public class ApiSubjectsByIdEventByIdPutResultJsonUnmarshaller implements Unmarshaller<ApiSubjectsByIdEventByIdPutResult, JsonUnmarshallerContext> {

    public ApiSubjectsByIdEventByIdPutResult unmarshall(JsonUnmarshallerContext context) throws Exception {
        ApiSubjectsByIdEventByIdPutResult apiSubjectsByIdEventByIdPutResult = new ApiSubjectsByIdEventByIdPutResult();

        int originalDepth = context.getCurrentDepth();
        String currentParentElement = context.getCurrentParentElement();
        int targetDepth = originalDepth + 1;

        JsonToken token = context.getCurrentToken();
        if (token == null)
            token = context.nextToken();
        if (token == VALUE_NULL) {
            return apiSubjectsByIdEventByIdPutResult;
        }

        while (true) {
            if (token == null)
                break;

            apiSubjectsByIdEventByIdPutResult.setEvent(EventJsonUnmarshaller.getInstance().unmarshall(context));
            token = context.nextToken();
        }

        return apiSubjectsByIdEventByIdPutResult;
    }

    private static ApiSubjectsByIdEventByIdPutResultJsonUnmarshaller instance;

    public static ApiSubjectsByIdEventByIdPutResultJsonUnmarshaller getInstance() {
        if (instance == null)
            instance = new ApiSubjectsByIdEventByIdPutResultJsonUnmarshaller();
        return instance;
    }
}
