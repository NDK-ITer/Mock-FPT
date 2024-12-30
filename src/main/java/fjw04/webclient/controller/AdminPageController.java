package fjw04.webclient.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminPageController {

    @GetMapping
    public String index() {
        return "admin/index";
    }

    @GetMapping("/product")
    public String product() {
        return "admin/product";
    }

    @GetMapping("/login")
    public String login() {
        return "admin/login";
    }
    
}
