package pl.koleszko.software.uma.application.web.controller.users;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.koleszko.software.uma.application.domain.api.user.bo.AddUserBo;
import pl.koleszko.software.uma.application.domain.api.user.dto.UserDetailsDto;
import pl.koleszko.software.uma.application.domain.api.user.dto.UserInsertDto;
import pl.koleszko.software.uma.application.web.swagger.SwaggerTagType;

@RestController
public class AddUserController extends AbstractUserController {

    private AddUserBo addUserBo;

    @Autowired
    public AddUserController(AddUserBo addUserBo) {
        this.addUserBo = addUserBo;
    }

    @PostMapping("/add")
    @ApiOperation(value = "add new user", tags = SwaggerTagType.USERS)
    public ResponseEntity<UserDetailsDto> addNewUser(
            @ApiParam(value = "user details", required = true)
            @RequestBody UserInsertDto dto){
        return new ResponseEntity<>(addUserBo.addNewUser(dto), HttpStatus.CREATED);
    }
}