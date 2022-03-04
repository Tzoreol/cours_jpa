package fr.tzoreol.cours_jpa.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class UsersEntity {
    @Id
    String login;

    @OneToOne
    private PasswordEntity password;

    @ManyToOne
    @JoinColumn(name = "role")
    RoleEntity role;

    @OneToMany
    @JoinColumn(name = "user")
    List<MesssageEntity> messages;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public PasswordEntity getPassword() {
        return password;
    }

    public void setPassword(PasswordEntity password) {
        this.password = password;
    }

    public RoleEntity getRole() {
        return role;
    }

    public void setRole(RoleEntity role) {
        this.role = role;
    }

    public List<MesssageEntity> getMessages() {
        return messages;
    }

    public void setMessages(List<MesssageEntity> messages) {
        this.messages = messages;
    }
}
