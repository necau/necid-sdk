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
 * GetBulkRegisterProgressResult JSON Unmarshaller
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
public class GetBulkRegisterProgressResultJsonUnmarshaller implements Unmarshaller<GetBulkRegisterProgressResult, JsonUnmarshallerContext> {

    public GetBulkRegisterProgressResult unmarshall(JsonUnmarshallerContext context) throws Exception {
        GetBulkRegisterProgressResult getBulkRegisterProgressResult = new GetBulkRegisterProgressResult();

        int originalDepth = context.getCurrentDepth();
        String currentParentElement = context.getCurrentParentElement();
        int targetDepth = originalDepth + 1;

        JsonToken token = context.getCurrentToken();
        if (token == null)
            token = context.nextToken();
        if (token == VALUE_NULL) {
            return getBulkRegisterProgressResult;
        }

        while (true) {
            if (token == null)
                break;

            getBulkRegisterProgressResult.setJobSummary(JobSummaryJsonUnmarshaller.getInstance().unmarshall(context));
            token = context.nextToken();
        }

        return getBulkRegisterProgressResult;
    }

    private static GetBulkRegisterProgressResultJsonUnmarshaller instance;

    public static GetBulkRegisterProgressResultJsonUnmarshaller getInstance() {
        if (instance == null)
            instance = new GetBulkRegisterProgressResultJsonUnmarshaller();
        return instance;
    }
}
