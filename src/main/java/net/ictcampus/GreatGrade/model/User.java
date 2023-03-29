package net.ictcampus.GreatGrade.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_user;

    @NotNull(message = "Username is required")
    @NotBlank(message = "Username can't be blank")
    private String username;

    @NotNull(message = "Name is required")
    @NotBlank(message = "Name can't be blank")
    private String name;

    @NotNull(message = "Prename is required")
    @NotBlank(message = "Prename can't be blank")
    @Length(max = 50)
    private String prename;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotBlank(message = "Password can't be blank")
    @NotNull(message = "Password is required")
    @Length(min = 6, max = 255)
    private String password;

    @OneToMany(mappedBy = "user")
    @JsonBackReference
    private Set<Subject> subjects = new HashSet<>();

    public Integer getId_user() {
        return id_user;
    }

    public void setId_user(Integer id_user) {
        this.id_user = id_user;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrename() {
        return prename;
    }

    public void setPrename(String prename) {
        this.prename = prename;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
