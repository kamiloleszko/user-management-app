package pl.koleszko.software.uma.application.domain.api.user.dto;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotEmpty;

public class UserInsertDto {

    @NotEmpty
    @ApiModelProperty("user name")
    private String name;
    @NotEmpty
    @ApiModelProperty("user surname")
    private String surname;
    @NotEmpty
    @ApiModelProperty("user grade")
    private int grade;
    @NotEmpty
    @ApiModelProperty("user salary")
    private int salary;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
