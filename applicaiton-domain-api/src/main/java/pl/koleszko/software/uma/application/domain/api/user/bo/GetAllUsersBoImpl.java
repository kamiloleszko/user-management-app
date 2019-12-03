package pl.koleszko.software.uma.application.domain.api.user.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.koleszko.software.uma.application.domain.api.user.assembler.UserDetailsAssembler;
import pl.koleszko.software.uma.application.domain.api.user.dto.UserDetailsDto;
import pl.koleszko.software.uma.application.domain.model.repository.UserRepository;

import java.util.List;

@Service
public class GetAllUsersBoImpl implements GetAllUsersBo {

    private UserRepository repository;

    @Autowired
    public GetAllUsersBoImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<UserDetailsDto> getAllUsers() {
        return UserDetailsAssembler.assembleUsersList(repository.findAll());
    }
}
