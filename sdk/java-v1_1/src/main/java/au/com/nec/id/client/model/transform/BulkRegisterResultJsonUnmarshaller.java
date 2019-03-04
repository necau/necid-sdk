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
 * BulkRegisterResult JSON Unmarshaller
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
public class BulkRegisterResultJsonUnmarshaller implements Unmarshaller<BulkRegisterResult, JsonUnmarshallerContext> {

    public BulkRegisterResult unmarshall(JsonUnmarshallerContext context) throws Exception {
        BulkRegisterResult bulkRegisterResult = new BulkRegisterResult();

        int originalDepth = context.getCurrentDepth();
        String currentParentElement = context.getCurrentParentElement();
        int targetDepth = originalDepth + 1;

        JsonToken token = context.getCurrentToken();
        if (token == null)
            token = context.nextToken();
        if (token == VALUE_NULL) {
            return bulkRegisterResult;
        }

        while (true) {
            if (token == null)
                break;

            bulkRegisterResult.setJob(JobJsonUnmarshaller.getInstance().unmarshall(context));
            token = context.nextToken();
        }

        return bulkRegisterResult;
    }

    private static BulkRegisterResultJsonUnmarshaller instance;

    public static BulkRegisterResultJsonUnmarshaller getInstance() {
        if (instance == null)
            instance = new BulkRegisterResultJsonUnmarshaller();
        return instance;
    }
}
