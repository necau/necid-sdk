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
 * CreateTagResult JSON Unmarshaller
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
public class CreateTagResultJsonUnmarshaller implements Unmarshaller<CreateTagResult, JsonUnmarshallerContext> {

    public CreateTagResult unmarshall(JsonUnmarshallerContext context) throws Exception {
        CreateTagResult createTagResult = new CreateTagResult();

        return createTagResult;
    }

    private static CreateTagResultJsonUnmarshaller instance;

    public static CreateTagResultJsonUnmarshaller getInstance() {
        if (instance == null)
            instance = new CreateTagResultJsonUnmarshaller();
        return instance;
    }
}
