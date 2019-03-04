/**
 * null
 */
package au.com.nec.id.client.model;

import java.io.Serializable;
import javax.annotation.Generated;

/**
 * 
 * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/api-1.1/ApiSubjectsGet" target="_top">AWS API Documentation</a>
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
public class ApiSubjectsGetResult extends com.amazonaws.opensdk.BaseResult implements Serializable, Cloneable {

    private SubjectList subjectList;

    /**
     * @param subjectList
     */

    public void setSubjectList(SubjectList subjectList) {
        this.subjectList = subjectList;
    }

    /**
     * @return
     */

    public SubjectList getSubjectList() {
        return this.subjectList;
    }

    /**
     * @param subjectList
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public ApiSubjectsGetResult subjectList(SubjectList subjectList) {
        setSubjectList(subjectList);
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
        if (getSubjectList() != null)
            sb.append("SubjectList: ").append(getSubjectList());
        sb.append("}");
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;

        if (obj instanceof ApiSubjectsGetResult == false)
            return false;
        ApiSubjectsGetResult other = (ApiSubjectsGetResult) obj;
        if (other.getSubjectList() == null ^ this.getSubjectList() == null)
            return false;
        if (other.getSubjectList() != null && other.getSubjectList().equals(this.getSubjectList()) == false)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hashCode = 1;

        hashCode = prime * hashCode + ((getSubjectList() == null) ? 0 : getSubjectList().hashCode());
        return hashCode;
    }

    @Override
    public ApiSubjectsGetResult clone() {
        try {
            return (ApiSubjectsGetResult) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() " + "even though we're Cloneable!", e);
        }
    }

}
