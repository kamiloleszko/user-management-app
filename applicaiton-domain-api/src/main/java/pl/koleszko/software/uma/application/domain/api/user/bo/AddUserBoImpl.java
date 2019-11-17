package pl.koleszko.software.uma.application.domain.api.user.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.koleszko.software.uma.application.domain.api.user.assembler.UserUpdateAssembler;
import pl.koleszko.software.uma.application.domain.api.user.dto.UserUpdateDto;
import pl.koleszko.software.uma.application.domain.model.repository.UserRepository;

@Component
public class AddUserBoImpl implements AddUserBo {

    private UserRepository repository;

    @Autowired
    public AddUserBoImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public void addNewUser(UserUpdateDto dto) {
        repository.save(UserUpdateAssembler.fromDto(dto));
    }
}
