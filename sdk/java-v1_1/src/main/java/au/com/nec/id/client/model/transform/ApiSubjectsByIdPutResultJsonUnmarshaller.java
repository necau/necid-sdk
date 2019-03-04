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
 * ApiSubjectsByIdPutResult JSON Unmarshaller
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
public class ApiSubjectsByIdPutResultJsonUnmarshaller implements Unmarshaller<ApiSubjectsByIdPutResult, JsonUnmarshallerContext> {

    public ApiSubjectsByIdPutResult unmarshall(JsonUnmarshallerContext context) throws Exception {
        ApiSubjectsByIdPutResult apiSubjectsByIdPutResult = new ApiSubjectsByIdPutResult();

        int originalDepth = context.getCurrentDepth();
        String currentParentElement = context.getCurrentParentElement();
        int targetDepth = originalDepth + 1;

        JsonToken token = context.getCurrentToken();
        if (token == null)
            token = context.nextToken();
        if (token == VALUE_NULL) {
            return apiSubjectsByIdPutResult;
        }

        while (true) {
            if (token == null)
                break;

            apiSubjectsByIdPutResult.setSubject(SubjectJsonUnmarshaller.getInstance().unmarshall(context));
            token = context.nextToken();
        }

        return apiSubjectsByIdPutResult;
    }

    private static ApiSubjectsByIdPutResultJsonUnmarshaller instance;

    public static ApiSubjectsByIdPutResultJsonUnmarshaller getInstance() {
        if (instance == null)
            instance = new ApiSubjectsByIdPutResultJsonUnmarshaller();
        return instance;
    }
}
