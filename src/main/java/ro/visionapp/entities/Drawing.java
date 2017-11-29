package ro.visionapp.entities;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.joda.time.DateTime;

@Entity
public class Drawing {

    @Id
    private String id;
    @Index
    private String userId;
    @Index
    private String name;
    @Index
    private DateTime dateAdded;


    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Drawing))
            return false;
        if (obj == this)
            return true;

        Drawing drawing = (Drawing) obj;
        return new EqualsBuilder().
                append(this.userId, drawing.userId).
                append(this.id, drawing.id).
                append(this.name, drawing.name).
                isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 31).
                append(name).
                append(userId).
                append(id).
                toHashCode();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DateTime getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(DateTime dateAdded) {
        this.dateAdded = dateAdded;
    }
}
