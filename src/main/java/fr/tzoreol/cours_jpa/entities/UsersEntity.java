package fr.tzoreol.cours_jpa.entities;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class UsersEntity {
    @Id
    @Column(name = "login", nullable = false, length = 15)
    private String username;

    @Transient
    private String doNotInsert;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDoNotInsert() {
        return doNotInsert;
    }

    public void setDoNotInsert(String doNotInsert) {
        this.doNotInsert = doNotInsert;
    }
}
