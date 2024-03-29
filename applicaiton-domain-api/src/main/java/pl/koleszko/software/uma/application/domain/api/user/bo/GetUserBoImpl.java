package pl.koleszko.software.uma.application.domain.api.user.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.koleszko.software.uma.application.domain.api.exception.UserException;
import pl.koleszko.software.uma.application.domain.api.user.assembler.UserDetailsAssembler;
import pl.koleszko.software.uma.application.domain.api.user.dto.UserDetailsDto;
import pl.koleszko.software.uma.application.domain.api.user.validator.UserIdValidator;

@Service
public class GetUserBoImpl implements GetUserBo {

    private UserIdValidator validator;

    @Autowired
    public GetUserBoImpl(UserIdValidator validator) {
        this.validator = validator;
    }

    @Override
    public UserDetailsDto getUserById(Long userId) throws UserException {
        return UserDetailsAssembler.toDto(validator.validateAngGetUserIfExists(userId));
    }
}
