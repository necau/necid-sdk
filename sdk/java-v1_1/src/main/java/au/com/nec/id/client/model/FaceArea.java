/**
 * null
 */
package au.com.nec.id.client.model;

import java.io.Serializable;
import javax.annotation.Generated;
import com.amazonaws.protocol.StructuredPojo;
import com.amazonaws.protocol.ProtocolMarshaller;

/**
 * 
 * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/api-1.1/FaceArea" target="_top">AWS API Documentation</a>
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
public class FaceArea implements Serializable, Cloneable, StructuredPojo {

    private String bottom;

    private String left;

    private String right;

    private String top;

    /**
     * @param bottom
     */

    public void setBottom(String bottom) {
        this.bottom = bottom;
    }

    /**
     * @return
     */

    public String getBottom() {
        return this.bottom;
    }

    /**
     * @param bottom
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public FaceArea bottom(String bottom) {
        setBottom(bottom);
        return this;
    }

    /**
     * @param left
     */

    public void setLeft(String left) {
        this.left = left;
    }

    /**
     * @return
     */

    public String getLeft() {
        return this.left;
    }

    /**
     * @param left
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public FaceArea left(String left) {
        setLeft(left);
        return this;
    }

    /**
     * @param right
     */

    public void setRight(String right) {
        this.right = right;
    }

    /**
     * @return
     */

    public String getRight() {
        return this.right;
    }

    /**
     * @param right
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public FaceArea right(String right) {
        setRight(right);
        return this;
    }

    /**
     * @param top
     */

    public void setTop(String top) {
        this.top = top;
    }

    /**
     * @return
     */

    public String getTop() {
        return this.top;
    }

    /**
     * @param top
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public FaceArea top(String top) {
        setTop(top);
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
        if (getBottom() != null)
            sb.append("Bottom: ").append(getBottom()).append(",");
        if (getLeft() != null)
            sb.append("Left: ").append(getLeft()).append(",");
        if (getRight() != null)
            sb.append("Right: ").append(getRight()).append(",");
        if (getTop() != null)
            sb.append("Top: ").append(getTop());
        sb.append("}");
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;

        if (obj instanceof FaceArea == false)
            return false;
        FaceArea other = (FaceArea) obj;
        if (other.getBottom() == null ^ this.getBottom() == null)
            return false;
        if (other.getBottom() != null && other.getBottom().equals(this.getBottom()) == false)
            return false;
        if (other.getLeft() == null ^ this.getLeft() == null)
            return false;
        if (other.getLeft() != null && other.getLeft().equals(this.getLeft()) == false)
            return false;
        if (other.getRight() == null ^ this.getRight() == null)
            return false;
        if (other.getRight() != null && other.getRight().equals(this.getRight()) == false)
            return false;
        if (other.getTop() == null ^ this.getTop() == null)
            return false;
        if (other.getTop() != null && other.getTop().equals(this.getTop()) == false)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hashCode = 1;

        hashCode = prime * hashCode + ((getBottom() == null) ? 0 : getBottom().hashCode());
        hashCode = prime * hashCode + ((getLeft() == null) ? 0 : getLeft().hashCode());
        hashCode = prime * hashCode + ((getRight() == null) ? 0 : getRight().hashCode());
        hashCode = prime * hashCode + ((getTop() == null) ? 0 : getTop().hashCode());
        return hashCode;
    }

    @Override
    public FaceArea clone() {
        try {
            return (FaceArea) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() " + "even though we're Cloneable!", e);
        }
    }

    @com.amazonaws.annotation.SdkInternalApi
    @Override
    public void marshall(ProtocolMarshaller protocolMarshaller) {
        au.com.nec.id.client.model.transform.FaceAreaMarshaller.getInstance().marshall(this, protocolMarshaller);
    }
}
