/**
 * null
 */
package nec.necid.client.model;

import java.io.Serializable;
import javax.annotation.Generated;

/**
 * 
 * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/api-2018-10-29T02:37:36Z/ApiFaceSearchPost" target="_top">AWS
 *      API Documentation</a>
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
public class ApiFaceSearchPostResult extends com.amazonaws.opensdk.BaseResult implements Serializable, Cloneable {

    private SearchResult searchResult;

    /**
     * @param searchResult
     */

    public void setSearchResult(SearchResult searchResult) {
        this.searchResult = searchResult;
    }

    /**
     * @return
     */

    public SearchResult getSearchResult() {
        return this.searchResult;
    }

    /**
     * @param searchResult
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public ApiFaceSearchPostResult searchResult(SearchResult searchResult) {
        setSearchResult(searchResult);
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
        if (getSearchResult() != null)
            sb.append("SearchResult: ").append(getSearchResult());
        sb.append("}");
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;

        if (obj instanceof ApiFaceSearchPostResult == false)
            return false;
        ApiFaceSearchPostResult other = (ApiFaceSearchPostResult) obj;
        if (other.getSearchResult() == null ^ this.getSearchResult() == null)
            return false;
        if (other.getSearchResult() != null && other.getSearchResult().equals(this.getSearchResult()) == false)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hashCode = 1;

        hashCode = prime * hashCode + ((getSearchResult() == null) ? 0 : getSearchResult().hashCode());
        return hashCode;
    }

    @Override
    public ApiFaceSearchPostResult clone() {
        try {
            return (ApiFaceSearchPostResult) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() " + "even though we're Cloneable!", e);
        }
    }

}
