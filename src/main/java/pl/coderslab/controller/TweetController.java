package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.Comment;
import pl.coderslab.entity.Tweet;
import pl.coderslab.entity.User;
import pl.coderslab.repository.CommentRepository;
import pl.coderslab.repository.TweetRepository;
import pl.coderslab.repository.UserRepository;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/tweet")
public class TweetController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TweetRepository tweetRepository;

    @Autowired
    private CommentRepository commentRepository;

    @GetMapping("/add")
    private String add(Model model){
        Tweet tweet = new Tweet();
        model.addAttribute("tweet", tweet);
        return "tweet/form";
    }

    @GetMapping("/details/{id}")
    private String details(@PathVariable Long id, Model model) {
        Tweet tweet = tweetRepository.findOne(id);
        List<Comment> comments = commentRepository.findAllByTweetOrderByCreatedDesc(tweet);
        User user = userRepository.findOne(tweet.getUser().getId());
        model.addAttribute("tweet", tweet);
        model.addAttribute("comments", comments);
        model.addAttribute("user", user);
        return "tweet/details";
    }

    @GetMapping("/edit/{id}")
    private String edit(@PathVariable Long id, Model model) {
        Tweet tweet = tweetRepository.findOne(id);
        model.addAttribute("tweet", tweet);
        return "tweet/form";
    }

    @PostMapping("/save")
    private String save(@Valid Tweet tweet, BindingResult errors, HttpServletRequest request) {
        if(errors.hasErrors()){
            return "index";
        }
        tweetRepository.save(tweet);
        return "redirect:"+request.getContextPath()+"/";
    }

    @GetMapping("/all")
    private String list(Model model) {
        List<Tweet> tweets = tweetRepository.findAll();
        model.addAttribute("tweets", tweets);
        return "tweet/list";
    }

    @GetMapping("/delete/{id}")
    private String delete(@PathVariable Long id, HttpServletRequest request){
        tweetRepository.delete(id);
        return "redirect:"+request.getContextPath()+"/tweet/all";
    }

    @ModelAttribute("users")
    public List<User> user() {
        return userRepository.findAll();
    }

    @ModelAttribute("allTweets")
    public List<Tweet> tweets(){
        return tweetRepository.findAllByOrderByCreatedDesc();
    }

}
