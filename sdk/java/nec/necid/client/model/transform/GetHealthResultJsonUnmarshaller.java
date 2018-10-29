/**
 * null
 */
package nec.necid.client.model.transform;

import java.math.*;

import javax.annotation.Generated;

import nec.necid.client.model.*;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers.*;
import com.amazonaws.transform.*;

import static com.fasterxml.jackson.core.JsonToken.*;

/**
 * GetHealthResult JSON Unmarshaller
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
public class GetHealthResultJsonUnmarshaller implements Unmarshaller<GetHealthResult, JsonUnmarshallerContext> {

    public GetHealthResult unmarshall(JsonUnmarshallerContext context) throws Exception {
        GetHealthResult getHealthResult = new GetHealthResult();

        return getHealthResult;
    }

    private static GetHealthResultJsonUnmarshaller instance;

    public static GetHealthResultJsonUnmarshaller getInstance() {
        if (instance == null)
            instance = new GetHealthResultJsonUnmarshaller();
        return instance;
    }
}
