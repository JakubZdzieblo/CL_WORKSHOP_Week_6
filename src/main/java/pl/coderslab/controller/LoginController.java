package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.entity.User;
import pl.coderslab.service.UserService;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;


@RequestMapping("/login")
@Controller
public class LoginController {

    @Autowired
    UserService userService;

    @GetMapping("")
    public String login(Model model) {
        model.addAttribute("user", new User());
        return "/login/login";
    }

    @PostMapping("/check")
    public String checkLogin(@Valid User user, HttpSession session){
        if (userService.loginUser(user.getUsername(), user.getPassword(), session)){
            return "index";
        }
        return "login/login";
    }

}
