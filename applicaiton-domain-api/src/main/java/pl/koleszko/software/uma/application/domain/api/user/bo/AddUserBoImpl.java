package pl.koleszko.software.uma.application.domain.api.user.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.koleszko.software.uma.application.domain.api.user.assembler.UserDetailsAssembler;
import pl.koleszko.software.uma.application.domain.api.user.assembler.UserInsertAssembler;
import pl.koleszko.software.uma.application.domain.api.user.dto.UserDetailsDto;
import pl.koleszko.software.uma.application.domain.api.user.dto.UserInsertDto;
import pl.koleszko.software.uma.application.domain.model.repository.UserRepository;
import pl.koleszko.software.uma.application.domain.model.user.User;

@Component
public class AddUserBoImpl implements AddUserBo {

    private UserRepository repository;

    @Autowired
    public AddUserBoImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetailsDto addNewUser(UserInsertDto dto) {
        User user = repository.save(UserInsertAssembler.createNewFromDto(dto));
        return UserDetailsAssembler.toDto(user);
    }
}