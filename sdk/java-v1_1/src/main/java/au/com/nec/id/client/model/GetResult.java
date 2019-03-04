/**
 * null
 */
package au.com.nec.id.client.model;

import java.io.Serializable;
import javax.annotation.Generated;

/**
 * 
 * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/api-1.1/Get" target="_top">AWS API Documentation</a>
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
public class GetResult extends com.amazonaws.opensdk.BaseResult implements Serializable, Cloneable {

    private Tag tag;

    /**
     * @param tag
     */

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    /**
     * @return
     */

    public Tag getTag() {
        return this.tag;
    }

    /**
     * @param tag
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public GetResult tag(Tag tag) {
        setTag(tag);
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
        if (getTag() != null)
            sb.append("Tag: ").append(getTag());
        sb.append("}");
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;

        if (obj instanceof GetResult == false)
            return false;
        GetResult other = (GetResult) obj;
        if (other.getTag() == null ^ this.getTag() == null)
            return false;
        if (other.getTag() != null && other.getTag().equals(this.getTag()) == false)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hashCode = 1;

        hashCode = prime * hashCode + ((getTag() == null) ? 0 : getTag().hashCode());
        return hashCode;
    }

    @Override
    public GetResult clone() {
        try {
            return (GetResult) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() " + "even though we're Cloneable!", e);
        }
    }

}
