package pl.koleszko.software.uma.application.domain.api.user.bo;

import pl.koleszko.software.uma.application.domain.api.user.dto.UserUpdateDto;

public interface AddUserBo {
    void addNewUser(UserUpdateDto dto);
}
