package fjw04.webclient.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class BadController {
    @GetMapping("/404")
    public String getMethodName() {
        return "404";
    }
    
}
