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
 * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/api-1.1/SearchResult" target="_top">AWS API Documentation</a>
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
public class SearchResult implements Serializable, Cloneable, StructuredPojo {

    private Attributes attributes;

    private java.util.List<Candidate> candidates;

    /**
     * @param attributes
     */

    public void setAttributes(Attributes attributes) {
        this.attributes = attributes;
    }

    /**
     * @return
     */

    public Attributes getAttributes() {
        return this.attributes;
    }

    /**
     * @param attributes
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public SearchResult attributes(Attributes attributes) {
        setAttributes(attributes);
        return this;
    }

    /**
     * @return
     */

    public java.util.List<Candidate> getCandidates() {
        return candidates;
    }

    /**
     * @param candidates
     */

    public void setCandidates(java.util.Collection<Candidate> candidates) {
        if (candidates == null) {
            this.candidates = null;
            return;
        }

        this.candidates = new java.util.ArrayList<Candidate>(candidates);
    }

    /**
     * <p>
     * <b>NOTE:</b> This method appends the values to the existing list (if any). Use
     * {@link #setCandidates(java.util.Collection)} or {@link #withCandidates(java.util.Collection)} if you want to
     * override the existing values.
     * </p>
     * 
     * @param candidates
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public SearchResult candidates(Candidate... candidates) {
        if (this.candidates == null) {
            setCandidates(new java.util.ArrayList<Candidate>(candidates.length));
        }
        for (Candidate ele : candidates) {
            this.candidates.add(ele);
        }
        return this;
    }

    /**
     * @param candidates
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public SearchResult candidates(java.util.Collection<Candidate> candidates) {
        setCandidates(candidates);
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
        if (getAttributes() != null)
            sb.append("Attributes: ").append(getAttributes()).append(",");
        if (getCandidates() != null)
            sb.append("Candidates: ").append(getCandidates());
        sb.append("}");
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;

        if (obj instanceof SearchResult == false)
            return false;
        SearchResult other = (SearchResult) obj;
        if (other.getAttributes() == null ^ this.getAttributes() == null)
            return false;
        if (other.getAttributes() != null && other.getAttributes().equals(this.getAttributes()) == false)
            return false;
        if (other.getCandidates() == null ^ this.getCandidates() == null)
            return false;
        if (other.getCandidates() != null && other.getCandidates().equals(this.getCandidates()) == false)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hashCode = 1;

        hashCode = prime * hashCode + ((getAttributes() == null) ? 0 : getAttributes().hashCode());
        hashCode = prime * hashCode + ((getCandidates() == null) ? 0 : getCandidates().hashCode());
        return hashCode;
    }

    @Override
    public SearchResult clone() {
        try {
            return (SearchResult) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() " + "even though we're Cloneable!", e);
        }
    }

    @com.amazonaws.annotation.SdkInternalApi
    @Override
    public void marshall(ProtocolMarshaller protocolMarshaller) {
        au.com.nec.id.client.model.transform.SearchResultMarshaller.getInstance().marshall(this, protocolMarshaller);
    }
}
