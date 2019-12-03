package pl.koleszko.software.uma.application.domain.api.user.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.koleszko.software.uma.application.domain.api.exception.UserException;
import pl.koleszko.software.uma.application.domain.api.user.assembler.UserDetailsAssembler;
import pl.koleszko.software.uma.application.domain.api.user.assembler.UserInsertAssembler;
import pl.koleszko.software.uma.application.domain.api.user.dto.UserDetailsDto;
import pl.koleszko.software.uma.application.domain.api.user.dto.UserInsertDto;
import pl.koleszko.software.uma.application.domain.api.user.validator.UserIdValidator;
import pl.koleszko.software.uma.application.domain.model.repository.UserRepository;
import pl.koleszko.software.uma.application.domain.model.user.User;

@Service
public class UpdateUserBoImpl implements UpdateUserBo {

    private UserRepository repository;
    private UserIdValidator validator;

    @Autowired
    public UpdateUserBoImpl(UserRepository repository, UserIdValidator validator) {
        this.repository = repository;
        this.validator = validator;
    }

    @Override
    public UserDetailsDto updateUser(UserInsertDto dto, Long userId) throws UserException {
        User user = validator.validateAngGetUserIfExists(userId);
        UserInsertAssembler.updateFromDto(dto, user);
        user = repository.save(user);
        return UserDetailsAssembler.toDto(user);
    }
}
