package pl.koleszko.software.uma.application.domain.api.user.bo;

import pl.koleszko.software.uma.application.domain.api.exception.UserException;

public interface DeleteUserBo {

    void deleteUser(Long userId) throws UserException;
}
