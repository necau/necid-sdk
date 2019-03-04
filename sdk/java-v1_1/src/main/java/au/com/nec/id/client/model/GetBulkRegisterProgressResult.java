/**
 * null
 */
package au.com.nec.id.client.model;

import java.io.Serializable;
import javax.annotation.Generated;

/**
 * 
 * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/api-1.1/GetBulkRegisterProgress" target="_top">AWS API
 *      Documentation</a>
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
public class GetBulkRegisterProgressResult extends com.amazonaws.opensdk.BaseResult implements Serializable, Cloneable {

    private JobSummary jobSummary;

    /**
     * @param jobSummary
     */

    public void setJobSummary(JobSummary jobSummary) {
        this.jobSummary = jobSummary;
    }

    /**
     * @return
     */

    public JobSummary getJobSummary() {
        return this.jobSummary;
    }

    /**
     * @param jobSummary
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public GetBulkRegisterProgressResult jobSummary(JobSummary jobSummary) {
        setJobSummary(jobSummary);
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
        if (getJobSummary() != null)
            sb.append("JobSummary: ").append(getJobSummary());
        sb.append("}");
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;

        if (obj instanceof GetBulkRegisterProgressResult == false)
            return false;
        GetBulkRegisterProgressResult other = (GetBulkRegisterProgressResult) obj;
        if (other.getJobSummary() == null ^ this.getJobSummary() == null)
            return false;
        if (other.getJobSummary() != null && other.getJobSummary().equals(this.getJobSummary()) == false)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hashCode = 1;

        hashCode = prime * hashCode + ((getJobSummary() == null) ? 0 : getJobSummary().hashCode());
        return hashCode;
    }

    @Override
    public GetBulkRegisterProgressResult clone() {
        try {
            return (GetBulkRegisterProgressResult) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() " + "even though we're Cloneable!", e);
        }
    }

}
