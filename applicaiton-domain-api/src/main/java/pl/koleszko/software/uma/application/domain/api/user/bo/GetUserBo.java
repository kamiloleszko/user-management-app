package pl.koleszko.software.uma.application.domain.api.user.bo;

import pl.koleszko.software.uma.application.domain.api.exception.UserException;
import pl.koleszko.software.uma.application.domain.api.user.dto.UserDetailsDto;

public interface GetUserBo {

    UserDetailsDto getUserById(Long userId) throws UserException;
}