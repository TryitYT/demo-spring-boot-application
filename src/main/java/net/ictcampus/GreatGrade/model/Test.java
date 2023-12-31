package net.ictcampus.GreatGrade.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Test {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_test;

    @NotNull(message = "Test name is required")
    @NotBlank(message = "Test name can't be blank")
    private String name;

    @NotNull(message = "Test grade is required")
    private Float grade;

    @NotNull(message = "Test weight is required")
    private Float weight;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;

    public Integer getId_test() {
        return id_test;
    }

    public void setId_test(Integer id_test) {
        this.id_test = id_test;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getGrade() {
        return grade;
    }

    public void setGrade(Float grade) {
        this.grade = grade;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}
