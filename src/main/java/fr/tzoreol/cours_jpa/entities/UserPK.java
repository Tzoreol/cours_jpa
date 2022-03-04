package fr.tzoreol.cours_jpa.entities;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class UserPK implements Serializable {
    private String firstname;
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
