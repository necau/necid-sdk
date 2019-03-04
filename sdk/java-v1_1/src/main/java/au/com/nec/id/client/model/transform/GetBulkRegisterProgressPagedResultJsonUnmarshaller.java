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
 * GetBulkRegisterProgressPagedResult JSON Unmarshaller
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
public class GetBulkRegisterProgressPagedResultJsonUnmarshaller implements Unmarshaller<GetBulkRegisterProgressPagedResult, JsonUnmarshallerContext> {

    public GetBulkRegisterProgressPagedResult unmarshall(JsonUnmarshallerContext context) throws Exception {
        GetBulkRegisterProgressPagedResult getBulkRegisterProgressPagedResult = new GetBulkRegisterProgressPagedResult();

        int originalDepth = context.getCurrentDepth();
        String currentParentElement = context.getCurrentParentElement();
        int targetDepth = originalDepth + 1;

        JsonToken token = context.getCurrentToken();
        if (token == null)
            token = context.nextToken();
        if (token == VALUE_NULL) {
            return getBulkRegisterProgressPagedResult;
        }

        while (true) {
            if (token == null)
                break;

            getBulkRegisterProgressPagedResult.setJobSummary(JobSummaryJsonUnmarshaller.getInstance().unmarshall(context));
            token = context.nextToken();
        }

        return getBulkRegisterProgressPagedResult;
    }

    private static GetBulkRegisterProgressPagedResultJsonUnmarshaller instance;

    public static GetBulkRegisterProgressPagedResultJsonUnmarshaller getInstance() {
        if (instance == null)
            instance = new GetBulkRegisterProgressPagedResultJsonUnmarshaller();
        return instance;
    }
}
