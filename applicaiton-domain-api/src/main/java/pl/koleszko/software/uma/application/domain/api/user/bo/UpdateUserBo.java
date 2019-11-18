package pl.koleszko.software.uma.application.domain.api.user.bo;

import pl.koleszko.software.uma.application.domain.api.exception.UserException;
import pl.koleszko.software.uma.application.domain.api.user.dto.UserDetailsDto;
import pl.koleszko.software.uma.application.domain.api.user.dto.UserInsertDto;

public interface UpdateUserBo {

    UserDetailsDto updateUser(UserInsertDto dto, Long userId) throws UserException;
}
