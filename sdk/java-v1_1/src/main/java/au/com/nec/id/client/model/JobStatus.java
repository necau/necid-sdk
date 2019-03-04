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
 * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/api-1.1/JobStatus" target="_top">AWS API Documentation</a>
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
public class JobStatus implements Serializable, Cloneable, StructuredPojo {

    private Integer attempts;

    private String attributesJson;

    private String eventId;

    private String filename;

    private String id;

    private String reason;

    private String registerStatus;

    private String status;

    private String subjectId;

    /**
     * @param attempts
     */

    public void setAttempts(Integer attempts) {
        this.attempts = attempts;
    }

    /**
     * @return
     */

    public Integer getAttempts() {
        return this.attempts;
    }

    /**
     * @param attempts
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public JobStatus attempts(Integer attempts) {
        setAttempts(attempts);
        return this;
    }

    /**
     * @param attributesJson
     */

    public void setAttributesJson(String attributesJson) {
        this.attributesJson = attributesJson;
    }

    /**
     * @return
     */

    public String getAttributesJson() {
        return this.attributesJson;
    }

    /**
     * @param attributesJson
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public JobStatus attributesJson(String attributesJson) {
        setAttributesJson(attributesJson);
        return this;
    }

    /**
     * @param eventId
     */

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    /**
     * @return
     */

    public String getEventId() {
        return this.eventId;
    }

    /**
     * @param eventId
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public JobStatus eventId(String eventId) {
        setEventId(eventId);
        return this;
    }

    /**
     * @param filename
     */

    public void setFilename(String filename) {
        this.filename = filename;
    }

    /**
     * @return
     */

    public String getFilename() {
        return this.filename;
    }

    /**
     * @param filename
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public JobStatus filename(String filename) {
        setFilename(filename);
        return this;
    }

    /**
     * @param id
     */

    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return
     */

    public String getId() {
        return this.id;
    }

    /**
     * @param id
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public JobStatus id(String id) {
        setId(id);
        return this;
    }

    /**
     * @param reason
     */

    public void setReason(String reason) {
        this.reason = reason;
    }

    /**
     * @return
     */

    public String getReason() {
        return this.reason;
    }

    /**
     * @param reason
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public JobStatus reason(String reason) {
        setReason(reason);
        return this;
    }

    /**
     * @param registerStatus
     */

    public void setRegisterStatus(String registerStatus) {
        this.registerStatus = registerStatus;
    }

    /**
     * @return
     */

    public String getRegisterStatus() {
        return this.registerStatus;
    }

    /**
     * @param registerStatus
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public JobStatus registerStatus(String registerStatus) {
        setRegisterStatus(registerStatus);
        return this;
    }

    /**
     * @param status
     */

    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return
     */

    public String getStatus() {
        return this.status;
    }

    /**
     * @param status
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public JobStatus status(String status) {
        setStatus(status);
        return this;
    }

    /**
     * @param subjectId
     */

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    /**
     * @return
     */

    public String getSubjectId() {
        return this.subjectId;
    }

    /**
     * @param subjectId
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public JobStatus subjectId(String subjectId) {
        setSubjectId(subjectId);
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
        if (getAttempts() != null)
            sb.append("Attempts: ").append(getAttempts()).append(",");
        if (getAttributesJson() != null)
            sb.append("AttributesJson: ").append(getAttributesJson()).append(",");
        if (getEventId() != null)
            sb.append("EventId: ").append(getEventId()).append(",");
        if (getFilename() != null)
            sb.append("Filename: ").append(getFilename()).append(",");
        if (getId() != null)
            sb.append("Id: ").append(getId()).append(",");
        if (getReason() != null)
            sb.append("Reason: ").append(getReason()).append(",");
        if (getRegisterStatus() != null)
            sb.append("RegisterStatus: ").append(getRegisterStatus()).append(",");
        if (getStatus() != null)
            sb.append("Status: ").append(getStatus()).append(",");
        if (getSubjectId() != null)
            sb.append("SubjectId: ").append(getSubjectId());
        sb.append("}");
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;

        if (obj instanceof JobStatus == false)
            return false;
        JobStatus other = (JobStatus) obj;
        if (other.getAttempts() == null ^ this.getAttempts() == null)
            return false;
        if (other.getAttempts() != null && other.getAttempts().equals(this.getAttempts()) == false)
            return false;
        if (other.getAttributesJson() == null ^ this.getAttributesJson() == null)
            return false;
        if (other.getAttributesJson() != null && other.getAttributesJson().equals(this.getAttributesJson()) == false)
            return false;
        if (other.getEventId() == null ^ this.getEventId() == null)
            return false;
        if (other.getEventId() != null && other.getEventId().equals(this.getEventId()) == false)
            return false;
        if (other.getFilename() == null ^ this.getFilename() == null)
            return false;
        if (other.getFilename() != null && other.getFilename().equals(this.getFilename()) == false)
            return false;
        if (other.getId() == null ^ this.getId() == null)
            return false;
        if (other.getId() != null && other.getId().equals(this.getId()) == false)
            return false;
        if (other.getReason() == null ^ this.getReason() == null)
            return false;
        if (other.getReason() != null && other.getReason().equals(this.getReason()) == false)
            return false;
        if (other.getRegisterStatus() == null ^ this.getRegisterStatus() == null)
            return false;
        if (other.getRegisterStatus() != null && other.getRegisterStatus().equals(this.getRegisterStatus()) == false)
            return false;
        if (other.getStatus() == null ^ this.getStatus() == null)
            return false;
        if (other.getStatus() != null && other.getStatus().equals(this.getStatus()) == false)
            return false;
        if (other.getSubjectId() == null ^ this.getSubjectId() == null)
            return false;
        if (other.getSubjectId() != null && other.getSubjectId().equals(this.getSubjectId()) == false)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hashCode = 1;

        hashCode = prime * hashCode + ((getAttempts() == null) ? 0 : getAttempts().hashCode());
        hashCode = prime * hashCode + ((getAttributesJson() == null) ? 0 : getAttributesJson().hashCode());
        hashCode = prime * hashCode + ((getEventId() == null) ? 0 : getEventId().hashCode());
        hashCode = prime * hashCode + ((getFilename() == null) ? 0 : getFilename().hashCode());
        hashCode = prime * hashCode + ((getId() == null) ? 0 : getId().hashCode());
        hashCode = prime * hashCode + ((getReason() == null) ? 0 : getReason().hashCode());
        hashCode = prime * hashCode + ((getRegisterStatus() == null) ? 0 : getRegisterStatus().hashCode());
        hashCode = prime * hashCode + ((getStatus() == null) ? 0 : getStatus().hashCode());
        hashCode = prime * hashCode + ((getSubjectId() == null) ? 0 : getSubjectId().hashCode());
        return hashCode;
    }

    @Override
    public JobStatus clone() {
        try {
            return (JobStatus) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() " + "even though we're Cloneable!", e);
        }
    }

    @com.amazonaws.annotation.SdkInternalApi
    @Override
    public void marshall(ProtocolMarshaller protocolMarshaller) {
        au.com.nec.id.client.model.transform.JobStatusMarshaller.getInstance().marshall(this, protocolMarshaller);
    }
}
