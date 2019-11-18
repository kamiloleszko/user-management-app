package pl.koleszko.software.uma.application.web.controller.users;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.koleszko.software.uma.application.domain.api.exception.UserException;
import pl.koleszko.software.uma.application.domain.api.user.bo.DeleteUserBo;
import pl.koleszko.software.uma.application.web.swagger.SwaggerTagType;

@RestController
public class DeleteUserController extends AbstractUserController {

    private DeleteUserBo deleteUserBo;

    @Autowired
    public DeleteUserController(DeleteUserBo deleteUserBo) {
        this.deleteUserBo = deleteUserBo;
    }

    @DeleteMapping("/delete/{userId}")
    @ApiOperation(value = "delete user by Id", tags = SwaggerTagType.USERS)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "???", required = true, dataType = "Long", paramType = "path")})
    public ResponseEntity<Void> getUserById(@PathVariable("userId") Long userId) throws UserException {
        deleteUserBo.deleteUser(userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
