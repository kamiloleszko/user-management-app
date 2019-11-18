package pl.koleszko.software.uma.application.domain.api.user.bo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.koleszko.software.uma.application.domain.api.exception.UserException;
import pl.koleszko.software.uma.application.domain.api.user.validator.UserIdValidator;
import pl.koleszko.software.uma.application.domain.model.repository.UserRepository;

@Component
public class DeleteUserBoImpl implements DeleteUserBo{

    private UserRepository repository;
    private UserIdValidator validator;

    @Autowired
    public DeleteUserBoImpl(UserRepository repository, UserIdValidator validator) {
        this.repository = repository;
        this.validator = validator;
    }

    @Override
    public void deleteUser(Long userId) throws UserException {
        validator.validateAngGetUserIfExists(userId);
        repository.delete(userId);
    }
}
