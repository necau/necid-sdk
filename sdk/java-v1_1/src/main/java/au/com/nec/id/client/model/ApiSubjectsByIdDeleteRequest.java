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
 * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/api-1.1/ApiSubjectsByIdDelete" target="_top">AWS API
 *      Documentation</a>
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
public class ApiSubjectsByIdDeleteRequest extends com.amazonaws.opensdk.BaseRequest implements Serializable, Cloneable, RequestSignerAware {

    private String subjectId;

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

    public ApiSubjectsByIdDeleteRequest subjectId(String subjectId) {
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

        if (obj instanceof ApiSubjectsByIdDeleteRequest == false)
            return false;
        ApiSubjectsByIdDeleteRequest other = (ApiSubjectsByIdDeleteRequest) obj;
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

        hashCode = prime * hashCode + ((getSubjectId() == null) ? 0 : getSubjectId().hashCode());
        return hashCode;
    }

    @Override
    public ApiSubjectsByIdDeleteRequest clone() {
        return (ApiSubjectsByIdDeleteRequest) super.clone();
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
    public ApiSubjectsByIdDeleteRequest sdkRequestConfig(com.amazonaws.opensdk.SdkRequestConfig sdkRequestConfig) {
        super.sdkRequestConfig(sdkRequestConfig);
        return this;
    }

}
