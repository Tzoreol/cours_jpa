package fr.tzoreol.cours_jpa.entities;

import javax.persistence.*;

@Entity
@Table(name = "users")
@SecondaryTable(name="jobs")
public class UsersEntity {
    @Id
    @Column(name = "username", nullable = true, length = 32)
    private String username;

    @Column(table = "jobs")
    private String job;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }
}
