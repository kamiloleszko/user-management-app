package pl.koleszko.software.uma.application.web.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.koleszko.software.uma.application.web.swagger.SwaggerTagType;

@RestController
public class TestController {

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    @ApiOperation(value = "temp value", tags = SwaggerTagType.USERS)
    public String getTemp(){
        return "sss";
    }
}
