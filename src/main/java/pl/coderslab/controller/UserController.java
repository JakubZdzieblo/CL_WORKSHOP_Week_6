package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.Tweet;
import pl.coderslab.entity.User;
import pl.coderslab.repository.TweetRepository;
import pl.coderslab.repository.UserRepository;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TweetRepository tweetRepository;

    @GetMapping("/add")
    private String add(Model model){
        User user = new User();
        model.addAttribute("user", user);
        return "user/form";
    }

    @GetMapping("/edit/{id}")
    private String edit(@PathVariable Long id, Model model) {
        User user = userRepository.findOne(id);
        model.addAttribute("user", user);
        return "user/form";
    }

    @PostMapping("/save")
    private String save(@Valid User user, BindingResult errors, HttpServletRequest request) {
        if(errors.hasErrors()){
            return "user/form";
        }
        userRepository.save(user);
        return "redirect:"+request.getContextPath()+"/user/all";
    }

    @GetMapping("/all")
    private String list(Model model) {
        List<User> users = userRepository.findAll();
        model.addAttribute("users", users);
        return "user/list";
    }

    @GetMapping("/delete/{id}")
    private String delete(@PathVariable Long id, HttpServletRequest request){
        List<Tweet> tweetList = tweetRepository.findAllByUserId(id);
        if (tweetList.size() > 0) {
            return "user/cantdelete";
        }
        userRepository.delete(id);
        return "redirect:"+request.getContextPath()+"/user/all";
    }



}
