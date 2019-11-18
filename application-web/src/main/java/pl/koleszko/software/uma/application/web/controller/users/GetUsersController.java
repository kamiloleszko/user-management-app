package pl.koleszko.software.uma.application.web.controller.users;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.koleszko.software.uma.application.domain.api.user.bo.GetAllUsersBo;
import pl.koleszko.software.uma.application.domain.api.user.bo.GetUserBo;
import pl.koleszko.software.uma.application.domain.api.user.dto.UserDetailsDto;
import pl.koleszko.software.uma.application.domain.api.exception.UserException;
import pl.koleszko.software.uma.application.web.swagger.SwaggerTagType;

import java.util.List;

@RestController
public class GetUsersController extends AbstractUserController {

    private GetAllUsersBo getAllUsersBo;
    private GetUserBo getUserBo;

    @Autowired
    public GetUsersController(GetAllUsersBo getAllUsersBo, GetUserBo getUserBo) {
        this.getAllUsersBo = getAllUsersBo;
        this.getUserBo = getUserBo;
    }

    @GetMapping("/all")
    @ApiOperation(value = "get all users", tags = SwaggerTagType.USERS)
    public ResponseEntity<List<UserDetailsDto>> getAllUsers(){
        return new ResponseEntity<>(getAllUsersBo.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    @ApiOperation(value = "get user by Id", tags = SwaggerTagType.USERS)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "???", required = true, dataType = "Long", paramType = "path")})
    public ResponseEntity<UserDetailsDto> getUserById(@PathVariable("userId") Long userId) throws UserException {
        return new ResponseEntity<>(getUserBo.getUserById(userId), HttpStatus.OK);
    }
}
