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
 * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/api-1.1/GetBulkRegisterProgressPaged" target="_top">AWS API
 *      Documentation</a>
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
public class GetBulkRegisterProgressPagedRequest extends com.amazonaws.opensdk.BaseRequest implements Serializable, Cloneable, RequestSignerAware {

    private String batchId;

    private String pagingId;

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

    public GetBulkRegisterProgressPagedRequest batchId(String batchId) {
        setBatchId(batchId);
        return this;
    }

    /**
     * @param pagingId
     */

    public void setPagingId(String pagingId) {
        this.pagingId = pagingId;
    }

    /**
     * @return
     */

    public String getPagingId() {
        return this.pagingId;
    }

    /**
     * @param pagingId
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public GetBulkRegisterProgressPagedRequest pagingId(String pagingId) {
        setPagingId(pagingId);
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
        if (getPagingId() != null)
            sb.append("PagingId: ").append(getPagingId());
        sb.append("}");
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;

        if (obj instanceof GetBulkRegisterProgressPagedRequest == false)
            return false;
        GetBulkRegisterProgressPagedRequest other = (GetBulkRegisterProgressPagedRequest) obj;
        if (other.getBatchId() == null ^ this.getBatchId() == null)
            return false;
        if (other.getBatchId() != null && other.getBatchId().equals(this.getBatchId()) == false)
            return false;
        if (other.getPagingId() == null ^ this.getPagingId() == null)
            return false;
        if (other.getPagingId() != null && other.getPagingId().equals(this.getPagingId()) == false)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hashCode = 1;

        hashCode = prime * hashCode + ((getBatchId() == null) ? 0 : getBatchId().hashCode());
        hashCode = prime * hashCode + ((getPagingId() == null) ? 0 : getPagingId().hashCode());
        return hashCode;
    }

    @Override
    public GetBulkRegisterProgressPagedRequest clone() {
        return (GetBulkRegisterProgressPagedRequest) super.clone();
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
    public GetBulkRegisterProgressPagedRequest sdkRequestConfig(com.amazonaws.opensdk.SdkRequestConfig sdkRequestConfig) {
        super.sdkRequestConfig(sdkRequestConfig);
        return this;
    }

}
