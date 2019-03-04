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
 * ApiSubjectsGetResult JSON Unmarshaller
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
public class ApiSubjectsGetResultJsonUnmarshaller implements Unmarshaller<ApiSubjectsGetResult, JsonUnmarshallerContext> {

    public ApiSubjectsGetResult unmarshall(JsonUnmarshallerContext context) throws Exception {
        ApiSubjectsGetResult apiSubjectsGetResult = new ApiSubjectsGetResult();

        int originalDepth = context.getCurrentDepth();
        String currentParentElement = context.getCurrentParentElement();
        int targetDepth = originalDepth + 1;

        JsonToken token = context.getCurrentToken();
        if (token == null)
            token = context.nextToken();
        if (token == VALUE_NULL) {
            return apiSubjectsGetResult;
        }

        while (true) {
            if (token == null)
                break;

            apiSubjectsGetResult.setSubjectList(SubjectListJsonUnmarshaller.getInstance().unmarshall(context));
            token = context.nextToken();
        }

        return apiSubjectsGetResult;
    }

    private static ApiSubjectsGetResultJsonUnmarshaller instance;

    public static ApiSubjectsGetResultJsonUnmarshaller getInstance() {
        if (instance == null)
            instance = new ApiSubjectsGetResultJsonUnmarshaller();
        return instance;
    }
}
