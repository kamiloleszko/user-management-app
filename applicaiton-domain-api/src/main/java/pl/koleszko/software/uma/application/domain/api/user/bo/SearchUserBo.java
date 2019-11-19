package pl.koleszko.software.uma.application.domain.api.user.bo;

import pl.koleszko.software.uma.application.domain.api.user.dto.UserDetailsDto;
import pl.koleszko.software.uma.application.domain.api.user.dto.UserSearchParams;

import java.util.List;

public interface SearchUserBo {

    List<UserDetailsDto> searchUsers(UserSearchParams searchParams);
}