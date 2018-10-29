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
 * ApiSubjectsByIdDeleteResult JSON Unmarshaller
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
public class ApiSubjectsByIdDeleteResultJsonUnmarshaller implements Unmarshaller<ApiSubjectsByIdDeleteResult, JsonUnmarshallerContext> {

    public ApiSubjectsByIdDeleteResult unmarshall(JsonUnmarshallerContext context) throws Exception {
        ApiSubjectsByIdDeleteResult apiSubjectsByIdDeleteResult = new ApiSubjectsByIdDeleteResult();

        return apiSubjectsByIdDeleteResult;
    }

    private static ApiSubjectsByIdDeleteResultJsonUnmarshaller instance;

    public static ApiSubjectsByIdDeleteResultJsonUnmarshaller getInstance() {
        if (instance == null)
            instance = new ApiSubjectsByIdDeleteResultJsonUnmarshaller();
        return instance;
    }
}
