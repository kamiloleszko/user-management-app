package pl.koleszko.software.uma.application.domain.model.user;

import pl.koleszko.software.uma.application.domain.model.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "USER")
public class User extends BaseEntity {

    private String name;
    private String surname;
    private Integer grade;
    private Integer salary;

    public User() {
    }

    public static User of (String name, String surname, Integer grade, Integer salary){
        return new User(name, surname, grade, salary);
    }

    private User(String name, String surname, Integer grade, Integer salary) {
        this.name = name;
        this.surname = surname;
        this.grade = grade;
        this.salary = salary;
    }

    @NotNull
    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NotNull
    @Column(name = "SURNAME")
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @NotNull
    @Column(name = "GRADE")
    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    @NotNull
    @Column(name = "SALARY")
    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }
}
