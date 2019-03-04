/**
 * null
 */
package au.com.nec.id.client.model;

import java.io.Serializable;
import javax.annotation.Generated;

import com.amazonaws.auth.RequestSigner;
import com.amazonaws.opensdk.protect.auth.RequestSignerAware;

/**
 * 
 * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/api-1.1/ApiSubjectsByIdEventByIdDelete" target="_top">AWS API
 *      Documentation</a>
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
public class ApiSubjectsByIdEventByIdDeleteRequest extends com.amazonaws.opensdk.BaseRequest implements Serializable, Cloneable, RequestSignerAware {

    private String eventId;

    private String subjectId;

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

    public ApiSubjectsByIdEventByIdDeleteRequest eventId(String eventId) {
        setEventId(eventId);
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

    public ApiSubjectsByIdEventByIdDeleteRequest subjectId(String subjectId) {
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
        if (getEventId() != null)
            sb.append("EventId: ").append(getEventId()).append(",");
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

        if (obj instanceof ApiSubjectsByIdEventByIdDeleteRequest == false)
            return false;
        ApiSubjectsByIdEventByIdDeleteRequest other = (ApiSubjectsByIdEventByIdDeleteRequest) obj;
        if (other.getEventId() == null ^ this.getEventId() == null)
            return false;
        if (other.getEventId() != null && other.getEventId().equals(this.getEventId()) == false)
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

        hashCode = prime * hashCode + ((getEventId() == null) ? 0 : getEventId().hashCode());
        hashCode = prime * hashCode + ((getSubjectId() == null) ? 0 : getSubjectId().hashCode());
        return hashCode;
    }

    @Override
    public ApiSubjectsByIdEventByIdDeleteRequest clone() {
        return (ApiSubjectsByIdEventByIdDeleteRequest) super.clone();
    }

    @Override
    public Class<? extends RequestSigner> signerType() {
        return com.amazonaws.opensdk.protect.auth.IamRequestSigner.class;
    }

    /**
     * Set the configuration for this request.
     *
     * @param sdkRequestConfig
     *        Request configuration.
     * @return This object for method chaining.
     */
    public ApiSubjectsByIdEventByIdDeleteRequest sdkRequestConfig(com.amazonaws.opensdk.SdkRequestConfig sdkRequestConfig) {
        super.sdkRequestConfig(sdkRequestConfig);
        return this;
    }

}
