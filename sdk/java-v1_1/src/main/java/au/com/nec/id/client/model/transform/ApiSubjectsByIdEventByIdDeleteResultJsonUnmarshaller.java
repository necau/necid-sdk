/**
 * null
 */
package au.com.nec.id.client.model.transform;

import java.math.*;

import javax.annotation.Generated;

import au.com.nec.id.client.model.*;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers.*;
import com.amazonaws.transform.*;

import static com.fasterxml.jackson.core.JsonToken.*;

/**
 * ApiSubjectsByIdEventByIdDeleteResult JSON Unmarshaller
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
public class ApiSubjectsByIdEventByIdDeleteResultJsonUnmarshaller implements Unmarshaller<ApiSubjectsByIdEventByIdDeleteResult, JsonUnmarshallerContext> {

    public ApiSubjectsByIdEventByIdDeleteResult unmarshall(JsonUnmarshallerContext context) throws Exception {
        ApiSubjectsByIdEventByIdDeleteResult apiSubjectsByIdEventByIdDeleteResult = new ApiSubjectsByIdEventByIdDeleteResult();

        return apiSubjectsByIdEventByIdDeleteResult;
    }

    private static ApiSubjectsByIdEventByIdDeleteResultJsonUnmarshaller instance;

    public static ApiSubjectsByIdEventByIdDeleteResultJsonUnmarshaller getInstance() {
        if (instance == null)
            instance = new ApiSubjectsByIdEventByIdDeleteResultJsonUnmarshaller();
        return instance;
    }
}
