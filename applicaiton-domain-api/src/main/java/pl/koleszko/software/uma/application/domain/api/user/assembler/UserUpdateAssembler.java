package pl.koleszko.software.uma.application.domain.api.user.assembler;

import pl.koleszko.software.uma.application.domain.api.user.dto.UserUpdateDto;
import pl.koleszko.software.uma.application.domain.model.user.User;

public final class UserUpdateAssembler {

    public static User fromDto(UserUpdateDto dto){
        return User.of(dto.getName(), dto.getSurname(), dto.getGrade(), dto.getSalary());
    }
}
