package pl.koleszko.software.uma.application.domain.api.user.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.koleszko.software.uma.application.domain.api.exception.UserException;
import pl.koleszko.software.uma.application.domain.model.repository.UserRepository;
import pl.koleszko.software.uma.application.domain.model.user.User;

import java.util.Optional;

@Component
public class UserIdValidator {

    private UserRepository repository;

    @Autowired
    public UserIdValidator(UserRepository repository) {
        this.repository = repository;
    }

    public User validateAngGetUserIfExists(Long userId) throws UserException {
        Optional<User> userOptional = Optional.ofNullable(repository.findOne(userId));
        if (!userOptional.isPresent()){
            throw new UserException(userId);
        }
        return userOptional.get();
    }
}