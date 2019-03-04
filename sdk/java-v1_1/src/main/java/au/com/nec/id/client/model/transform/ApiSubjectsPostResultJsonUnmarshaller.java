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
 * ApiSubjectsPostResult JSON Unmarshaller
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
public class ApiSubjectsPostResultJsonUnmarshaller implements Unmarshaller<ApiSubjectsPostResult, JsonUnmarshallerContext> {

    public ApiSubjectsPostResult unmarshall(JsonUnmarshallerContext context) throws Exception {
        ApiSubjectsPostResult apiSubjectsPostResult = new ApiSubjectsPostResult();

        int originalDepth = context.getCurrentDepth();
        String currentParentElement = context.getCurrentParentElement();
        int targetDepth = originalDepth + 1;

        JsonToken token = context.getCurrentToken();
        if (token == null)
            token = context.nextToken();
        if (token == VALUE_NULL) {
            return apiSubjectsPostResult;
        }

        while (true) {
            if (token == null)
                break;

            apiSubjectsPostResult.setSubject(SubjectJsonUnmarshaller.getInstance().unmarshall(context));
            token = context.nextToken();
        }

        return apiSubjectsPostResult;
    }

    private static ApiSubjectsPostResultJsonUnmarshaller instance;

    public static ApiSubjectsPostResultJsonUnmarshaller getInstance() {
        if (instance == null)
            instance = new ApiSubjectsPostResultJsonUnmarshaller();
        return instance;
    }
}
