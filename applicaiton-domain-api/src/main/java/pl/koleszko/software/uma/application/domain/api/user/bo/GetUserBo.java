package pl.koleszko.software.uma.application.domain.api.user.bo;


import pl.koleszko.software.uma.application.domain.api.user.dto.UserDetailsDto;
import pl.koleszko.software.uma.application.domain.api.exception.UserException;

public interface GetUserBo {

    UserDetailsDto getUserById(Long userId) throws UserException;
}
