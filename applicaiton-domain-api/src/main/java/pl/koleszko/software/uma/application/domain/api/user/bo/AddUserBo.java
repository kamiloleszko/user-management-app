package pl.koleszko.software.uma.application.domain.api.user.bo;

import pl.koleszko.software.uma.application.domain.api.user.dto.UserDetailsDto;
import pl.koleszko.software.uma.application.domain.api.user.dto.UserInsertDto;

public interface AddUserBo {

    UserDetailsDto addNewUser(UserInsertDto dto);
}