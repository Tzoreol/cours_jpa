package fr.tzoreol.cours_jpa.entities;

import fr.tzoreol.cours_jpa.enums.Role;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class UsersEntity {
    @Id
    String login;

    @OneToOne
    private PasswordEntity password;

    @Enumerated
    private Role role;

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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<MesssageEntity> getMessages() {
        return messages;
    }

    public void setMessages(List<MesssageEntity> messages) {
        this.messages = messages;
    }
}
