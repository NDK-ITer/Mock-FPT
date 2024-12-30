package fjw04.webclient.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserPageController {
    @GetMapping("/")
    public String index() {
        return "user/index";
    }

    @GetMapping("/auth-cus")
    public String auth() {
        return "user/auth";
    }

    @GetMapping("/shop")
    public String shop() {
        return "user/shop";
    }

    @GetMapping("/about")
    public String about() {
        return "user/about";
    }

    @GetMapping("/contact")
    public String contact() {
        return "user/contact";
    }

    @GetMapping("/cart")
    public String cart() {
        return "user/cart";
    }

    @GetMapping("/checkout")
    public String checkout() {
        return "user/checkout";
    }
}
