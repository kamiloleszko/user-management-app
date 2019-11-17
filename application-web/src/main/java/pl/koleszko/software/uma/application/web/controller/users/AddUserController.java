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
import pl.koleszko.software.uma.application.domain.api.user.dto.UserUpdateDto;
import pl.koleszko.software.uma.application.web.swagger.SwaggerTagType;

@RestController
public class AddUserController {

    private AddUserBo addUserBo;

    @Autowired
    public AddUserController(AddUserBo addUserBo) {
        this.addUserBo = addUserBo;
    }

    @PostMapping("/users")
    @ApiOperation(value = "add new user", tags = SwaggerTagType.USERS)
    public ResponseEntity addNewUser(
            @ApiParam(value = "user details", required = true)
            @RequestBody UserUpdateDto dto){
        addUserBo.addNewUser(dto);
        return new ResponseEntity(HttpStatus.CREATED);
    }
}
