package pl.koleszko.software.uma.application.domain.api.user.dto;


import io.swagger.annotations.ApiModelProperty;

public class UserDetailsDto {

    @ApiModelProperty("user id")
    private Long id;
    @ApiModelProperty("user name")
    private String name;
    @ApiModelProperty("user surname")
    private String surname;
    @ApiModelProperty("user grade")
    private int grade;
    @ApiModelProperty("user salary")
    private int salary;

    public UserDetailsDto() {
    }

    public static UserDetailsDto of(Long id, String name, String surname, int grade,
                                    int salary){
        return new UserDetailsDto(id, name, surname, grade, salary);
    }

    private UserDetailsDto(Long id, String name, String surname, int grade, int salary) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.grade = grade;
        this.salary = salary;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getGrade() {
        return grade;
    }

    public int getSalary() {
        return salary;
    }
}
