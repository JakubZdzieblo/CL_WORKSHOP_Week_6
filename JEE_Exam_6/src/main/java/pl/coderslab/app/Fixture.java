package pl.coderslab.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.coderslab.entity.Tweet;
import pl.coderslab.entity.User;
import pl.coderslab.repository.TweetRepository;
import pl.coderslab.repository.UserRepository;

@Component
public class Fixture {

    @Autowired
    UserRepository userRepository;

    @Autowired
    TweetRepository tweetRepository;

    public Fixture() {
    }

    public void fillDB() {

        User user1 = new User();
        user1.setFirstName("John");
        user1.setLastName("Doe");
        user1.setEmail("jd@mail.com");
        userRepository.save(user1);

        User user2 = new User();
        user2.setFirstName("Suzie");
        user2.setLastName("Lane");
        user2.setEmail("suzie@mail.com");
        userRepository.save(user2);

        User user3 = new User();
        user3.setFirstName("Hank");
        user3.setLastName("Black");
        user3.setEmail("hank@mail.com");
        userRepository.save(user3);

        Tweet tweet1 = new Tweet();
        tweet1.setTitle("All is cool");
        tweet1.setTweetText("Everything cool here");
        tweet1.setUser(user1);
        tweetRepository.save(tweet1);

        Tweet tweet2 = new Tweet();
        tweet2.setTitle("Flowers");
        tweet2.setTweetText("I like them");
        tweet2.setUser(user2);
        tweetRepository.save(tweet2);

        Tweet tweet3 = new Tweet();
        tweet3.setTitle("All is bad");
        tweet3.setTweetText("Everything sucks");
        tweet3.setUser(user3);
        tweetRepository.save(tweet3);


    }
}
