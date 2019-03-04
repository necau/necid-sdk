/**
 * null
 */
package au.com.nec.id.client.model;

import java.io.Serializable;
import javax.annotation.Generated;

/**
 * 
 * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/api-1.1/ApiSubjectsByIdEventsGet" target="_top">AWS API
 *      Documentation</a>
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
public class ApiSubjectsByIdEventsGetResult extends com.amazonaws.opensdk.BaseResult implements Serializable, Cloneable {

    private Events events;

    /**
     * @param events
     */

    public void setEvents(Events events) {
        this.events = events;
    }

    /**
     * @return
     */

    public Events getEvents() {
        return this.events;
    }

    /**
     * @param events
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public ApiSubjectsByIdEventsGetResult events(Events events) {
        setEvents(events);
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
        if (getEvents() != null)
            sb.append("Events: ").append(getEvents());
        sb.append("}");
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;

        if (obj instanceof ApiSubjectsByIdEventsGetResult == false)
            return false;
        ApiSubjectsByIdEventsGetResult other = (ApiSubjectsByIdEventsGetResult) obj;
        if (other.getEvents() == null ^ this.getEvents() == null)
            return false;
        if (other.getEvents() != null && other.getEvents().equals(this.getEvents()) == false)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hashCode = 1;

        hashCode = prime * hashCode + ((getEvents() == null) ? 0 : getEvents().hashCode());
        return hashCode;
    }

    @Override
    public ApiSubjectsByIdEventsGetResult clone() {
        try {
            return (ApiSubjectsByIdEventsGetResult) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() " + "even though we're Cloneable!", e);
        }
    }

}
