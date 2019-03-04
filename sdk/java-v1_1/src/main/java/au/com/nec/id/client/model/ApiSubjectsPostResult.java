/**
 * null
 */
package au.com.nec.id.client.model;

import java.io.Serializable;
import javax.annotation.Generated;

/**
 * 
 * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/api-1.1/ApiSubjectsPost" target="_top">AWS API Documentation</a>
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
public class ApiSubjectsPostResult extends com.amazonaws.opensdk.BaseResult implements Serializable, Cloneable {

    private Subject subject;

    /**
     * @param subject
     */

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    /**
     * @return
     */

    public Subject getSubject() {
        return this.subject;
    }

    /**
     * @param subject
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public ApiSubjectsPostResult subject(Subject subject) {
        setSubject(subject);
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
        if (getSubject() != null)
            sb.append("Subject: ").append(getSubject());
        sb.append("}");
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;

        if (obj instanceof ApiSubjectsPostResult == false)
            return false;
        ApiSubjectsPostResult other = (ApiSubjectsPostResult) obj;
        if (other.getSubject() == null ^ this.getSubject() == null)
            return false;
        if (other.getSubject() != null && other.getSubject().equals(this.getSubject()) == false)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hashCode = 1;

        hashCode = prime * hashCode + ((getSubject() == null) ? 0 : getSubject().hashCode());
        return hashCode;
    }

    @Override
    public ApiSubjectsPostResult clone() {
        try {
            return (ApiSubjectsPostResult) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() " + "even though we're Cloneable!", e);
        }
    }

}
