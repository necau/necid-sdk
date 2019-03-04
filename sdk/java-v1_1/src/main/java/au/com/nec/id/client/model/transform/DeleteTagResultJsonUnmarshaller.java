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
 * DeleteTagResult JSON Unmarshaller
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
public class DeleteTagResultJsonUnmarshaller implements Unmarshaller<DeleteTagResult, JsonUnmarshallerContext> {

    public DeleteTagResult unmarshall(JsonUnmarshallerContext context) throws Exception {
        DeleteTagResult deleteTagResult = new DeleteTagResult();

        return deleteTagResult;
    }

    private static DeleteTagResultJsonUnmarshaller instance;

    public static DeleteTagResultJsonUnmarshaller getInstance() {
        if (instance == null)
            instance = new DeleteTagResultJsonUnmarshaller();
        return instance;
    }
}
