package ro.visionapp.entities;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.joda.time.DateTime;

@Entity
public class UserDto {
    @Id
    private String id;
    private String email;
    private String nickname;
    private DateTime lastLoginDate;

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof UserDto))
            return false;
        if (obj == this)
            return true;

        UserDto user = (UserDto) obj;
        return new EqualsBuilder().
                append(this.email, user.email).
                append(this.id, user.id).
                isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 31).
                append(email).
                append(id).
                toHashCode();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public DateTime getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(DateTime lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }
}
