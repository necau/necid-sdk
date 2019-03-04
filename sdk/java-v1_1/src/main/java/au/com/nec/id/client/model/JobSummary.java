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
 * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/api-1.1/JobSummary" target="_top">AWS API Documentation</a>
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
public class JobSummary implements Serializable, Cloneable, StructuredPojo {

    private String batchId;

    private String lastEvaluatedKey;

    private java.util.List<JobStatus> processed;

    /**
     * @param batchId
     */

    public void setBatchId(String batchId) {
        this.batchId = batchId;
    }

    /**
     * @return
     */

    public String getBatchId() {
        return this.batchId;
    }

    /**
     * @param batchId
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public JobSummary batchId(String batchId) {
        setBatchId(batchId);
        return this;
    }

    /**
     * @param lastEvaluatedKey
     */

    public void setLastEvaluatedKey(String lastEvaluatedKey) {
        this.lastEvaluatedKey = lastEvaluatedKey;
    }

    /**
     * @return
     */

    public String getLastEvaluatedKey() {
        return this.lastEvaluatedKey;
    }

    /**
     * @param lastEvaluatedKey
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public JobSummary lastEvaluatedKey(String lastEvaluatedKey) {
        setLastEvaluatedKey(lastEvaluatedKey);
        return this;
    }

    /**
     * @return
     */

    public java.util.List<JobStatus> getProcessed() {
        return processed;
    }

    /**
     * @param processed
     */

    public void setProcessed(java.util.Collection<JobStatus> processed) {
        if (processed == null) {
            this.processed = null;
            return;
        }

        this.processed = new java.util.ArrayList<JobStatus>(processed);
    }

    /**
     * <p>
     * <b>NOTE:</b> This method appends the values to the existing list (if any). Use
     * {@link #setProcessed(java.util.Collection)} or {@link #withProcessed(java.util.Collection)} if you want to
     * override the existing values.
     * </p>
     * 
     * @param processed
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public JobSummary processed(JobStatus... processed) {
        if (this.processed == null) {
            setProcessed(new java.util.ArrayList<JobStatus>(processed.length));
        }
        for (JobStatus ele : processed) {
            this.processed.add(ele);
        }
        return this;
    }

    /**
     * @param processed
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public JobSummary processed(java.util.Collection<JobStatus> processed) {
        setProcessed(processed);
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
        if (getBatchId() != null)
            sb.append("BatchId: ").append(getBatchId()).append(",");
        if (getLastEvaluatedKey() != null)
            sb.append("LastEvaluatedKey: ").append(getLastEvaluatedKey()).append(",");
        if (getProcessed() != null)
            sb.append("Processed: ").append(getProcessed());
        sb.append("}");
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;

        if (obj instanceof JobSummary == false)
            return false;
        JobSummary other = (JobSummary) obj;
        if (other.getBatchId() == null ^ this.getBatchId() == null)
            return false;
        if (other.getBatchId() != null && other.getBatchId().equals(this.getBatchId()) == false)
            return false;
        if (other.getLastEvaluatedKey() == null ^ this.getLastEvaluatedKey() == null)
            return false;
        if (other.getLastEvaluatedKey() != null && other.getLastEvaluatedKey().equals(this.getLastEvaluatedKey()) == false)
            return false;
        if (other.getProcessed() == null ^ this.getProcessed() == null)
            return false;
        if (other.getProcessed() != null && other.getProcessed().equals(this.getProcessed()) == false)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hashCode = 1;

        hashCode = prime * hashCode + ((getBatchId() == null) ? 0 : getBatchId().hashCode());
        hashCode = prime * hashCode + ((getLastEvaluatedKey() == null) ? 0 : getLastEvaluatedKey().hashCode());
        hashCode = prime * hashCode + ((getProcessed() == null) ? 0 : getProcessed().hashCode());
        return hashCode;
    }

    @Override
    public JobSummary clone() {
        try {
            return (JobSummary) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() " + "even though we're Cloneable!", e);
        }
    }

    @com.amazonaws.annotation.SdkInternalApi
    @Override
    public void marshall(ProtocolMarshaller protocolMarshaller) {
        au.com.nec.id.client.model.transform.JobSummaryMarshaller.getInstance().marshall(this, protocolMarshaller);
    }
}
