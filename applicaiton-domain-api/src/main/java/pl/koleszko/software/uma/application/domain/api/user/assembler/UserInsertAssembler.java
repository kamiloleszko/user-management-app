package pl.koleszko.software.uma.application.domain.api.user.assembler;

import pl.koleszko.software.uma.application.domain.api.user.dto.UserInsertDto;
import pl.koleszko.software.uma.application.domain.model.user.User;

public final class UserInsertAssembler {

    private UserInsertAssembler() {
    }

    public static User createNewFromDto(UserInsertDto dto){
        return User.of(dto.getName(), dto.getSurname(), dto.getGrade(), dto.getSalary());
    }

    public static void updateFromDto(UserInsertDto dto, User user){
        if (dto.getName() != null) {
            user.setName(dto.getName());
        }
        if (dto.getSurname() != null){
            user.setSurname(dto.getSurname());
        }
        if (dto.getGrade() != null) {
            user.setGrade(dto.getGrade());
        }
        if (dto.getSalary() != null) {
            user.setSalary(dto.getSalary());
        }
    }
}