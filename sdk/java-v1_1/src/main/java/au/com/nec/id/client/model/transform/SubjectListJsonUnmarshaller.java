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
 * SubjectList JSON Unmarshaller
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
public class SubjectListJsonUnmarshaller implements Unmarshaller<SubjectList, JsonUnmarshallerContext> {

    public SubjectList unmarshall(JsonUnmarshallerContext context) throws Exception {
        SubjectList subjectList = new SubjectList();

        int originalDepth = context.getCurrentDepth();
        String currentParentElement = context.getCurrentParentElement();
        int targetDepth = originalDepth + 1;

        JsonToken token = context.getCurrentToken();
        if (token == null)
            token = context.nextToken();
        if (token == VALUE_NULL) {
            return null;
        }

        while (true) {
            if (token == null)
                break;

            if (token == FIELD_NAME || token == START_OBJECT) {
                if (context.testExpression("subjects", targetDepth)) {
                    context.nextToken();
                    subjectList.setSubjects(new ListUnmarshaller<Subject>(SubjectJsonUnmarshaller.getInstance()).unmarshall(context));
                }
                if (context.testExpression("total", targetDepth)) {
                    context.nextToken();
                    subjectList.setTotal(context.getUnmarshaller(Integer.class).unmarshall(context));
                }
            } else if (token == END_ARRAY || token == END_OBJECT) {
                if (context.getLastParsedParentElement() == null || context.getLastParsedParentElement().equals(currentParentElement)) {
                    if (context.getCurrentDepth() <= originalDepth)
                        break;
                }
            }
            token = context.nextToken();
        }

        return subjectList;
    }

    private static SubjectListJsonUnmarshaller instance;

    public static SubjectListJsonUnmarshaller getInstance() {
        if (instance == null)
            instance = new SubjectListJsonUnmarshaller();
        return instance;
    }
}
