package pl.koleszko.software.uma.application.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/")
public class MainController {

    @GetMapping
    public String index(){
        return "redirect:/swagger-ui.html";
    }
}
