/**
 * null
 */
package au.com.nec.id.client.model;

import java.io.Serializable;
import javax.annotation.Generated;

/**
 * 
 * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/api-1.1/ApiFaceExtractPost" target="_top">AWS API
 *      Documentation</a>
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
public class ApiFaceExtractPostResult extends com.amazonaws.opensdk.BaseResult implements Serializable, Cloneable {

    private ExtractResult extractResult;

    /**
     * @param extractResult
     */

    public void setExtractResult(ExtractResult extractResult) {
        this.extractResult = extractResult;
    }

    /**
     * @return
     */

    public ExtractResult getExtractResult() {
        return this.extractResult;
    }

    /**
     * @param extractResult
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public ApiFaceExtractPostResult extractResult(ExtractResult extractResult) {
        setExtractResult(extractResult);
        return this;
    }

    /**
     * Returns a string representation of this object; useful for testing and debugging.
     *
     * @return A string representation of this object.
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getExtractResult() != null)
            sb.append("ExtractResult: ").append(getExtractResult());
        sb.append("}");
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;

        if (obj instanceof ApiFaceExtractPostResult == false)
            return false;
        ApiFaceExtractPostResult other = (ApiFaceExtractPostResult) obj;
        if (other.getExtractResult() == null ^ this.getExtractResult() == null)
            return false;
        if (other.getExtractResult() != null && other.getExtractResult().equals(this.getExtractResult()) == false)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hashCode = 1;

        hashCode = prime * hashCode + ((getExtractResult() == null) ? 0 : getExtractResult().hashCode());
        return hashCode;
    }

    @Override
    public ApiFaceExtractPostResult clone() {
        try {
            return (ApiFaceExtractPostResult) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() " + "even though we're Cloneable!", e);
        }
    }

}
