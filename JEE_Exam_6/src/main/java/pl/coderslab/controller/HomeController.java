package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.entity.Tweet;
import pl.coderslab.repository.TweetRepository;
import pl.coderslab.repository.UserRepository;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    TweetRepository tweetRepository;

    @GetMapping("/home")
    public String home(){
        return "index";
    }

    @GetMapping("/user/{id}/tweets")
    public String userTweets(@PathVariable Long id, Model model){
        List<Tweet> tweets = tweetRepository.findAllByUserId(id);
        model.addAttribute("tweets", tweets);
        return "tweets";
    }

    @GetMapping("/user/search-tweets")
    public String searchTweets(@RequestParam String title,  Model model){
        List<Tweet> tweets = tweetRepository.findAllByTitleStartingWithOrderByCreated(title);
        model.addAttribute("tweets", tweets);
        return "tweets";
    }


}
