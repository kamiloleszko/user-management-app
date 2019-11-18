package pl.koleszko.software.uma.application.domain.api.user.assembler;

import pl.koleszko.software.uma.application.domain.api.user.dto.UserInsertDto;
import pl.koleszko.software.uma.application.domain.model.user.User;

public final class UserInsertAssembler {

    public static User createNewFromDto(UserInsertDto dto){
        return User.of(dto.getName(), dto.getSurname(), dto.getGrade(), dto.getSalary());
    }

    public static void updateFromDto(UserInsertDto dto, User user){
        user.setName(dto.getName());
        user.setSurname(dto.getSurname());
        user.setGrade(dto.getGrade());
        user.setSalary(dto.getSalary());
    }
}
