package pl.koleszko.software.uma.application.web.controller.users;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.koleszko.software.uma.application.domain.api.user.bo.SearchUserBo;
import pl.koleszko.software.uma.application.domain.api.user.dto.UserDetailsDto;
import pl.koleszko.software.uma.application.domain.api.user.dto.UserSearchParams;
import pl.koleszko.software.uma.application.web.swagger.SwaggerTagType;

import java.util.List;

@RestController
public class SearchUserController extends AbstractUserController{

    private SearchUserBo searchUserBo;

    @Autowired
    public SearchUserController(SearchUserBo searchUserBo) {
        this.searchUserBo = searchUserBo;
    }

    @PostMapping("/search")
    @ApiOperation(value = "search for users", tags = SwaggerTagType.USERS)
    public ResponseEntity<List<UserDetailsDto>> searchUsers(
            @ApiParam(value = "search params ", required = true)
            @RequestBody UserSearchParams searchParams){
        return new ResponseEntity<>(searchUserBo.searchUsers(searchParams), HttpStatus.OK);
    }
}