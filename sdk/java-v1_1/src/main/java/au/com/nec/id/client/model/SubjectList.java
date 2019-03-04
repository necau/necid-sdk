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
 * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/api-1.1/SubjectList" target="_top">AWS API Documentation</a>
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
public class SubjectList implements Serializable, Cloneable, StructuredPojo {

    private java.util.List<Subject> subjects;

    private Integer total;

    /**
     * @return
     */

    public java.util.List<Subject> getSubjects() {
        return subjects;
    }

    /**
     * @param subjects
     */

    public void setSubjects(java.util.Collection<Subject> subjects) {
        if (subjects == null) {
            this.subjects = null;
            return;
        }

        this.subjects = new java.util.ArrayList<Subject>(subjects);
    }

    /**
     * <p>
     * <b>NOTE:</b> This method appends the values to the existing list (if any). Use
     * {@link #setSubjects(java.util.Collection)} or {@link #withSubjects(java.util.Collection)} if you want to override
     * the existing values.
     * </p>
     * 
     * @param subjects
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public SubjectList subjects(Subject... subjects) {
        if (this.subjects == null) {
            setSubjects(new java.util.ArrayList<Subject>(subjects.length));
        }
        for (Subject ele : subjects) {
            this.subjects.add(ele);
        }
        return this;
    }

    /**
     * @param subjects
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public SubjectList subjects(java.util.Collection<Subject> subjects) {
        setSubjects(subjects);
        return this;
    }

    /**
     * @param total
     */

    public void setTotal(Integer total) {
        this.total = total;
    }

    /**
     * @return
     */

    public Integer getTotal() {
        return this.total;
    }

    /**
     * @param total
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public SubjectList total(Integer total) {
        setTotal(total);
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
        if (getSubjects() != null)
            sb.append("Subjects: ").append(getSubjects()).append(",");
        if (getTotal() != null)
            sb.append("Total: ").append(getTotal());
        sb.append("}");
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;

        if (obj instanceof SubjectList == false)
            return false;
        SubjectList other = (SubjectList) obj;
        if (other.getSubjects() == null ^ this.getSubjects() == null)
            return false;
        if (other.getSubjects() != null && other.getSubjects().equals(this.getSubjects()) == false)
            return false;
        if (other.getTotal() == null ^ this.getTotal() == null)
            return false;
        if (other.getTotal() != null && other.getTotal().equals(this.getTotal()) == false)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hashCode = 1;

        hashCode = prime * hashCode + ((getSubjects() == null) ? 0 : getSubjects().hashCode());
        hashCode = prime * hashCode + ((getTotal() == null) ? 0 : getTotal().hashCode());
        return hashCode;
    }

    @Override
    public SubjectList clone() {
        try {
            return (SubjectList) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() " + "even though we're Cloneable!", e);
        }
    }

    @com.amazonaws.annotation.SdkInternalApi
    @Override
    public void marshall(ProtocolMarshaller protocolMarshaller) {
        au.com.nec.id.client.model.transform.SubjectListMarshaller.getInstance().marshall(this, protocolMarshaller);
    }
}
