package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.entity.Tweet;
import pl.coderslab.repository.TweetRepository;
import pl.coderslab.repository.UserRepository;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TweetRepository tweetRepository;

    @GetMapping("")
    public String redirect(Model model){

        model.addAttribute("tweet", new Tweet());
        return "index";
    }

    @GetMapping("/user/{id}/tweets")
    public String userTweets(@PathVariable Long id, Model model){
        List<Tweet> tweets = tweetRepository.findAllByUserIdOrderByCreatedDesc(id);
        model.addAttribute("tweets", tweets);
        return "tweets";
    }

    @GetMapping("/user/search-tweets")
    public String searchTweets(@RequestParam String title,  Model model){
        List<Tweet> tweets = tweetRepository.findAllByTitleStartingWithOrderByCreatedDesc(title);
        model.addAttribute("tweets", tweets);
        return "tweets";
    }

    @ModelAttribute("allTweets")
    public List<Tweet> tweets(){
        return tweetRepository.findAllByOrderByCreatedDesc();
    }

}
