package pl.koleszko.software.uma.application.web.controller.users;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.koleszko.software.uma.application.domain.api.exception.UserException;
import pl.koleszko.software.uma.application.domain.api.user.bo.UpdateUserBo;
import pl.koleszko.software.uma.application.domain.api.user.dto.UserDetailsDto;
import pl.koleszko.software.uma.application.domain.api.user.dto.UserInsertDto;
import pl.koleszko.software.uma.application.web.swagger.SwaggerTagType;

@RestController
public class UpdateUserController extends AbstractUserController {

    private UpdateUserBo updateUserBo;

    @Autowired
    public UpdateUserController(UpdateUserBo updateUserBo) {
        this.updateUserBo = updateUserBo;
    }

    @PutMapping("/update/{userId}")
    @ApiOperation(value = "edit existing user", tags = SwaggerTagType.USERS)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "???", required = true, dataType = "Long", paramType = "path")})
    public ResponseEntity<UserDetailsDto> addNewUser(
            @ApiParam(value = "user details", required = true)
            @RequestBody UserInsertDto dto,
            @PathVariable("userId") Long userId) throws UserException {
                return new ResponseEntity<>(updateUserBo.updateUser(dto, userId), HttpStatus.CREATED);
    }
}
