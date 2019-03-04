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
 * GetResult JSON Unmarshaller
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
public class GetResultJsonUnmarshaller implements Unmarshaller<GetResult, JsonUnmarshallerContext> {

    public GetResult unmarshall(JsonUnmarshallerContext context) throws Exception {
        GetResult getResult = new GetResult();

        int originalDepth = context.getCurrentDepth();
        String currentParentElement = context.getCurrentParentElement();
        int targetDepth = originalDepth + 1;

        JsonToken token = context.getCurrentToken();
        if (token == null)
            token = context.nextToken();
        if (token == VALUE_NULL) {
            return getResult;
        }

        while (true) {
            if (token == null)
                break;

            getResult.setTag(TagJsonUnmarshaller.getInstance().unmarshall(context));
            token = context.nextToken();
        }

        return getResult;
    }

    private static GetResultJsonUnmarshaller instance;

    public static GetResultJsonUnmarshaller getInstance() {
        if (instance == null)
            instance = new GetResultJsonUnmarshaller();
        return instance;
    }
}
