package pl.koleszko.software.uma.application.domain.api.user.bo;

import pl.koleszko.software.uma.application.domain.api.user.dto.UserDetailsDto;

import java.util.List;

public interface GetAllUsersBo {

    List<UserDetailsDto> getAllUsers();
}
