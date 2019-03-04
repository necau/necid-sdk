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
 * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/api-1.1/Candidate" target="_top">AWS API Documentation</a>
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
public class Candidate implements Serializable, Cloneable, StructuredPojo {

    private java.util.List<Event> events;

    private String id;

    private Integer score;

    /**
     * @return
     */

    public java.util.List<Event> getEvents() {
        return events;
    }

    /**
     * @param events
     */

    public void setEvents(java.util.Collection<Event> events) {
        if (events == null) {
            this.events = null;
            return;
        }

        this.events = new java.util.ArrayList<Event>(events);
    }

    /**
     * <p>
     * <b>NOTE:</b> This method appends the values to the existing list (if any). Use
     * {@link #setEvents(java.util.Collection)} or {@link #withEvents(java.util.Collection)} if you want to override the
     * existing values.
     * </p>
     * 
     * @param events
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public Candidate events(Event... events) {
        if (this.events == null) {
            setEvents(new java.util.ArrayList<Event>(events.length));
        }
        for (Event ele : events) {
            this.events.add(ele);
        }
        return this;
    }

    /**
     * @param events
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public Candidate events(java.util.Collection<Event> events) {
        setEvents(events);
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

    public Candidate id(String id) {
        setId(id);
        return this;
    }

    /**
     * @param score
     */

    public void setScore(Integer score) {
        this.score = score;
    }

    /**
     * @return
     */

    public Integer getScore() {
        return this.score;
    }

    /**
     * @param score
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public Candidate score(Integer score) {
        setScore(score);
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
            sb.append("Events: ").append(getEvents()).append(",");
        if (getId() != null)
            sb.append("Id: ").append(getId()).append(",");
        if (getScore() != null)
            sb.append("Score: ").append(getScore());
        sb.append("}");
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;

        if (obj instanceof Candidate == false)
            return false;
        Candidate other = (Candidate) obj;
        if (other.getEvents() == null ^ this.getEvents() == null)
            return false;
        if (other.getEvents() != null && other.getEvents().equals(this.getEvents()) == false)
            return false;
        if (other.getId() == null ^ this.getId() == null)
            return false;
        if (other.getId() != null && other.getId().equals(this.getId()) == false)
            return false;
        if (other.getScore() == null ^ this.getScore() == null)
            return false;
        if (other.getScore() != null && other.getScore().equals(this.getScore()) == false)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hashCode = 1;

        hashCode = prime * hashCode + ((getEvents() == null) ? 0 : getEvents().hashCode());
        hashCode = prime * hashCode + ((getId() == null) ? 0 : getId().hashCode());
        hashCode = prime * hashCode + ((getScore() == null) ? 0 : getScore().hashCode());
        return hashCode;
    }

    @Override
    public Candidate clone() {
        try {
            return (Candidate) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() " + "even though we're Cloneable!", e);
        }
    }

    @com.amazonaws.annotation.SdkInternalApi
    @Override
    public void marshall(ProtocolMarshaller protocolMarshaller) {
        au.com.nec.id.client.model.transform.CandidateMarshaller.getInstance().marshall(this, protocolMarshaller);
    }
}
