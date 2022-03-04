package fr.tzoreol.cours_jpa.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "messages")
public class MesssageEntity {
    @Id
    private long messageId;

    @ManyToOne
    @JoinColumn(name = "user")
    private UsersEntity user;

    @Column(name = "message")
    private String message;

    @Temporal(TemporalType.TIME)
    private Date time;

    public long getMessageId() {
        return messageId;
    }

    public void setMessageId(long messageId) {
        this.messageId = messageId;
    }

    public UsersEntity getUser() {
        return user;
    }

    public void setUser(UsersEntity user) {
        this.user = user;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
