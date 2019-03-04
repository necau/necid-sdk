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
 * UpdateTagResult JSON Unmarshaller
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
public class UpdateTagResultJsonUnmarshaller implements Unmarshaller<UpdateTagResult, JsonUnmarshallerContext> {

    public UpdateTagResult unmarshall(JsonUnmarshallerContext context) throws Exception {
        UpdateTagResult updateTagResult = new UpdateTagResult();

        return updateTagResult;
    }

    private static UpdateTagResultJsonUnmarshaller instance;

    public static UpdateTagResultJsonUnmarshaller getInstance() {
        if (instance == null)
            instance = new UpdateTagResultJsonUnmarshaller();
        return instance;
    }
}
