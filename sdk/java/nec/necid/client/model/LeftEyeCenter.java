/**
 * null
 */
package nec.necid.client.model;

import java.io.Serializable;
import javax.annotation.Generated;
import com.amazonaws.protocol.StructuredPojo;
import com.amazonaws.protocol.ProtocolMarshaller;

/**
 * 
 * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/api-2018-10-29T02:37:36Z/LeftEyeCenter" target="_top">AWS API
 *      Documentation</a>
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
public class LeftEyeCenter implements Serializable, Cloneable, StructuredPojo {

    private String x;

    private String y;

    /**
     * @param x
     */

    public void setX(String x) {
        this.x = x;
    }

    /**
     * @return
     */

    public String getX() {
        return this.x;
    }

    /**
     * @param x
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public LeftEyeCenter x(String x) {
        setX(x);
        return this;
    }

    /**
     * @param y
     */

    public void setY(String y) {
        this.y = y;
    }

    /**
     * @return
     */

    public String getY() {
        return this.y;
    }

    /**
     * @param y
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public LeftEyeCenter y(String y) {
        setY(y);
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
        if (getX() != null)
            sb.append("X: ").append(getX()).append(",");
        if (getY() != null)
            sb.append("Y: ").append(getY());
        sb.append("}");
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;

        if (obj instanceof LeftEyeCenter == false)
            return false;
        LeftEyeCenter other = (LeftEyeCenter) obj;
        if (other.getX() == null ^ this.getX() == null)
            return false;
        if (other.getX() != null && other.getX().equals(this.getX()) == false)
            return false;
        if (other.getY() == null ^ this.getY() == null)
            return false;
        if (other.getY() != null && other.getY().equals(this.getY()) == false)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hashCode = 1;

        hashCode = prime * hashCode + ((getX() == null) ? 0 : getX().hashCode());
        hashCode = prime * hashCode + ((getY() == null) ? 0 : getY().hashCode());
        return hashCode;
    }

    @Override
    public LeftEyeCenter clone() {
        try {
            return (LeftEyeCenter) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() " + "even though we're Cloneable!", e);
        }
    }

    @com.amazonaws.annotation.SdkInternalApi
    @Override
    public void marshall(ProtocolMarshaller protocolMarshaller) {
        nec.necid.client.model.transform.LeftEyeCenterMarshaller.getInstance().marshall(this, protocolMarshaller);
    }
}
