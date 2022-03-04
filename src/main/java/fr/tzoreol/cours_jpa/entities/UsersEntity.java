package fr.tzoreol.cours_jpa.entities;

import javax.persistence.*;

@Entity
@Table(name = "users", schema = "cours", catalog = "")
public class UsersEntity {
    @Id
    @Column(name = "username", nullable = true, length = 32)
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
