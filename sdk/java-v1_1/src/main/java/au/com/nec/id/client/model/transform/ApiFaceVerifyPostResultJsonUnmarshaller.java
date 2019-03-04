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
 * ApiFaceVerifyPostResult JSON Unmarshaller
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
public class ApiFaceVerifyPostResultJsonUnmarshaller implements Unmarshaller<ApiFaceVerifyPostResult, JsonUnmarshallerContext> {

    public ApiFaceVerifyPostResult unmarshall(JsonUnmarshallerContext context) throws Exception {
        ApiFaceVerifyPostResult apiFaceVerifyPostResult = new ApiFaceVerifyPostResult();

        int originalDepth = context.getCurrentDepth();
        String currentParentElement = context.getCurrentParentElement();
        int targetDepth = originalDepth + 1;

        JsonToken token = context.getCurrentToken();
        if (token == null)
            token = context.nextToken();
        if (token == VALUE_NULL) {
            return apiFaceVerifyPostResult;
        }

        while (true) {
            if (token == null)
                break;

            apiFaceVerifyPostResult.setCandidate(CandidateJsonUnmarshaller.getInstance().unmarshall(context));
            token = context.nextToken();
        }

        return apiFaceVerifyPostResult;
    }

    private static ApiFaceVerifyPostResultJsonUnmarshaller instance;

    public static ApiFaceVerifyPostResultJsonUnmarshaller getInstance() {
        if (instance == null)
            instance = new ApiFaceVerifyPostResultJsonUnmarshaller();
        return instance;
    }
}
