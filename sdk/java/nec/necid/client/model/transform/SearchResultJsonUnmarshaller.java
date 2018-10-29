/**
 * null
 */
package nec.necid.client.model.transform;

import java.math.*;

import javax.annotation.Generated;

import nec.necid.client.model.*;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers.*;
import com.amazonaws.transform.*;

import com.fasterxml.jackson.core.JsonToken;
import static com.fasterxml.jackson.core.JsonToken.*;

/**
 * SearchResult JSON Unmarshaller
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
public class SearchResultJsonUnmarshaller implements Unmarshaller<SearchResult, JsonUnmarshallerContext> {

    public SearchResult unmarshall(JsonUnmarshallerContext context) throws Exception {
        SearchResult searchResult = new SearchResult();

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
                if (context.testExpression("attributes", targetDepth)) {
                    context.nextToken();
                    searchResult.setAttributes(AttributesJsonUnmarshaller.getInstance().unmarshall(context));
                }
                if (context.testExpression("candidates", targetDepth)) {
                    context.nextToken();
                    searchResult.setCandidates(new ListUnmarshaller<Candidate>(CandidateJsonUnmarshaller.getInstance()).unmarshall(context));
                }
            } else if (token == END_ARRAY || token == END_OBJECT) {
                if (context.getLastParsedParentElement() == null || context.getLastParsedParentElement().equals(currentParentElement)) {
                    if (context.getCurrentDepth() <= originalDepth)
                        break;
                }
            }
            token = context.nextToken();
        }

        return searchResult;
    }

    private static SearchResultJsonUnmarshaller instance;

    public static SearchResultJsonUnmarshaller getInstance() {
        if (instance == null)
            instance = new SearchResultJsonUnmarshaller();
        return instance;
    }
}
