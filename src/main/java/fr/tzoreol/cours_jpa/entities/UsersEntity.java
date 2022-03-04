package fr.tzoreol.cours_jpa.entities;

import javax.persistence.*;

@Entity
@Table(name = "users")
@IdClass(UserPK.class)
public class UsersEntity {
    @Id
    private String firstname;

    @Id
    private String lastname;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
