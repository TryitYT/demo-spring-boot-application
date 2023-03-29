package net.ictcampus.GreatGrade.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_subject;

    @NotNull(message = "Subject name is required")
    @NotBlank(message = "Subject name can't be blank")
    private String name;

    @NotNull(message = "Subject weight is required")
    @NotBlank(message = "Subject weight can't be blank")
    private Integer weight;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "subject")
    @JsonBackReference
    private Set<Test> tests = new HashSet<>();

    public Integer getId_subject() {
        return id_subject;
    }

    public void setId_subject(Integer id_subject) {
        this.id_subject = id_subject;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
