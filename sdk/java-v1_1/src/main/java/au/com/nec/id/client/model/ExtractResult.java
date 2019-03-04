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
 * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/api-1.1/ExtractResult" target="_top">AWS API Documentation</a>
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
public class ExtractResult implements Serializable, Cloneable, StructuredPojo {

    private java.util.List<Attributes> faces;

    /**
     * @return
     */

    public java.util.List<Attributes> getFaces() {
        return faces;
    }

    /**
     * @param faces
     */

    public void setFaces(java.util.Collection<Attributes> faces) {
        if (faces == null) {
            this.faces = null;
            return;
        }

        this.faces = new java.util.ArrayList<Attributes>(faces);
    }

    /**
     * <p>
     * <b>NOTE:</b> This method appends the values to the existing list (if any). Use
     * {@link #setFaces(java.util.Collection)} or {@link #withFaces(java.util.Collection)} if you want to override the
     * existing values.
     * </p>
     * 
     * @param faces
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public ExtractResult faces(Attributes... faces) {
        if (this.faces == null) {
            setFaces(new java.util.ArrayList<Attributes>(faces.length));
        }
        for (Attributes ele : faces) {
            this.faces.add(ele);
        }
        return this;
    }

    /**
     * @param faces
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public ExtractResult faces(java.util.Collection<Attributes> faces) {
        setFaces(faces);
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
        if (getFaces() != null)
            sb.append("Faces: ").append(getFaces());
        sb.append("}");
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;

        if (obj instanceof ExtractResult == false)
            return false;
        ExtractResult other = (ExtractResult) obj;
        if (other.getFaces() == null ^ this.getFaces() == null)
            return false;
        if (other.getFaces() != null && other.getFaces().equals(this.getFaces()) == false)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hashCode = 1;

        hashCode = prime * hashCode + ((getFaces() == null) ? 0 : getFaces().hashCode());
        return hashCode;
    }

    @Override
    public ExtractResult clone() {
        try {
            return (ExtractResult) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() " + "even though we're Cloneable!", e);
        }
    }

    @com.amazonaws.annotation.SdkInternalApi
    @Override
    public void marshall(ProtocolMarshaller protocolMarshaller) {
        au.com.nec.id.client.model.transform.ExtractResultMarshaller.getInstance().marshall(this, protocolMarshaller);
    }
}
