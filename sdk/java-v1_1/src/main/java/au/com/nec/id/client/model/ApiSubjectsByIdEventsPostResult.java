/**
 * null
 */
package au.com.nec.id.client.model;

import java.io.Serializable;
import javax.annotation.Generated;

/**
 * 
 * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/api-1.1/ApiSubjectsByIdEventsPost" target="_top">AWS API
 *      Documentation</a>
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
public class ApiSubjectsByIdEventsPostResult extends com.amazonaws.opensdk.BaseResult implements Serializable, Cloneable {

    private Event event;

    /**
     * @param event
     */

    public void setEvent(Event event) {
        this.event = event;
    }

    /**
     * @return
     */

    public Event getEvent() {
        return this.event;
    }

    /**
     * @param event
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public ApiSubjectsByIdEventsPostResult event(Event event) {
        setEvent(event);
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
        if (getEvent() != null)
            sb.append("Event: ").append(getEvent());
        sb.append("}");
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;

        if (obj instanceof ApiSubjectsByIdEventsPostResult == false)
            return false;
        ApiSubjectsByIdEventsPostResult other = (ApiSubjectsByIdEventsPostResult) obj;
        if (other.getEvent() == null ^ this.getEvent() == null)
            return false;
        if (other.getEvent() != null && other.getEvent().equals(this.getEvent()) == false)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hashCode = 1;

        hashCode = prime * hashCode + ((getEvent() == null) ? 0 : getEvent().hashCode());
        return hashCode;
    }

    @Override
    public ApiSubjectsByIdEventsPostResult clone() {
        try {
            return (ApiSubjectsByIdEventsPostResult) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() " + "even though we're Cloneable!", e);
        }
    }

}
