package pl.koleszko.software.uma.application.domain.api.user.assembler;

import org.assertj.core.util.Lists;
import pl.koleszko.software.uma.application.domain.api.user.dto.UserDetailsDto;
import pl.koleszko.software.uma.application.domain.model.user.User;

import java.util.List;

public final class UserDetailsAssembler {

    private UserDetailsAssembler() {
    }

    public static List<UserDetailsDto> assembleUsersList(List<User> users){
        List<UserDetailsDto> results = Lists.newArrayList();
        users.forEach(user -> results.add(toDto(user)));
        return results;
    }

    public static UserDetailsDto toDto(User user){
        return UserDetailsDto.of(user.getId(), user.getName(), user.getSurname(), user.getGrade(),
                user.getSalary());
    }
}