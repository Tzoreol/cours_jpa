package fr.tzoreol.cours_jpa.entities;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class UsersEntity {
    @EmbeddedId
    UserPK userPK;

    public UserPK getUserPK() {
        return userPK;
    }

    public void setUserPK(UserPK userPK) {
        this.userPK = userPK;
    }
}
