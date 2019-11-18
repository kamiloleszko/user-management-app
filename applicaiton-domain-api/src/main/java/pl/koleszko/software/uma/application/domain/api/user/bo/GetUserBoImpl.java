package pl.koleszko.software.uma.application.domain.api.user.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.koleszko.software.uma.application.domain.api.user.assembler.UserDetailsAssembler;
import pl.koleszko.software.uma.application.domain.api.user.dto.UserDetailsDto;
import pl.koleszko.software.uma.application.domain.api.exception.UserException;
import pl.koleszko.software.uma.application.domain.api.user.validator.UserIdValidator;
import pl.koleszko.software.uma.application.domain.model.repository.UserRepository;

@Component
public class GetUserBoImpl implements GetUserBo {

    private UserRepository repository;
    private UserIdValidator validator;

    @Autowired
    public GetUserBoImpl(UserRepository repository, UserIdValidator validator) {
        this.repository = repository;
        this.validator = validator;
    }

    @Override
    public UserDetailsDto getUserById(Long userId) throws UserException {
        return UserDetailsAssembler.toDto(validator.validateAngGetUserIfExists(userId));
    }
}
