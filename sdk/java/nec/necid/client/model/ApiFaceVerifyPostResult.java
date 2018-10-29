/**
 * null
 */
package nec.necid.client.model;

import java.io.Serializable;
import javax.annotation.Generated;

/**
 * 
 * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/api-2018-10-29T02:37:36Z/ApiFaceVerifyPost" target="_top">AWS
 *      API Documentation</a>
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
public class ApiFaceVerifyPostResult extends com.amazonaws.opensdk.BaseResult implements Serializable, Cloneable {

    private Candidate candidate;

    /**
     * @param candidate
     */

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }

    /**
     * @return
     */

    public Candidate getCandidate() {
        return this.candidate;
    }

    /**
     * @param candidate
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public ApiFaceVerifyPostResult candidate(Candidate candidate) {
        setCandidate(candidate);
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
        if (getCandidate() != null)
            sb.append("Candidate: ").append(getCandidate());
        sb.append("}");
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;

        if (obj instanceof ApiFaceVerifyPostResult == false)
            return false;
        ApiFaceVerifyPostResult other = (ApiFaceVerifyPostResult) obj;
        if (other.getCandidate() == null ^ this.getCandidate() == null)
            return false;
        if (other.getCandidate() != null && other.getCandidate().equals(this.getCandidate()) == false)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hashCode = 1;

        hashCode = prime * hashCode + ((getCandidate() == null) ? 0 : getCandidate().hashCode());
        return hashCode;
    }

    @Override
    public ApiFaceVerifyPostResult clone() {
        try {
            return (ApiFaceVerifyPostResult) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() " + "even though we're Cloneable!", e);
        }
    }

}
