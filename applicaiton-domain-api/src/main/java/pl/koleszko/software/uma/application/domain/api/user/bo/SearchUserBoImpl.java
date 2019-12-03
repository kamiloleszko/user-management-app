package pl.koleszko.software.uma.application.domain.api.user.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.koleszko.software.uma.application.domain.api.user.assembler.UserDetailsAssembler;
import pl.koleszko.software.uma.application.domain.api.user.dto.UserDetailsDto;
import pl.koleszko.software.uma.application.domain.api.user.dto.UserSearchParams;
import pl.koleszko.software.uma.application.domain.api.user.helper.UserQueryHelper;
import pl.koleszko.software.uma.application.domain.model.repository.UserRepositoryCustom;

import java.util.List;

@Service
public class SearchUserBoImpl implements SearchUserBo {

    private UserRepositoryCustom userRepositoryCustom;

    @Autowired
    public SearchUserBoImpl(UserRepositoryCustom userRepositoryCustom) {
        this.userRepositoryCustom = userRepositoryCustom;
    }

    @Override
    public List<UserDetailsDto> searchUsers(UserSearchParams searchParams) {
        return UserDetailsAssembler.assembleUsersList(
                        userRepositoryCustom.findUsers(UserQueryHelper.createQuery(searchParams)));
    }
}
