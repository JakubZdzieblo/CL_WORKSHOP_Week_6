package pl.coderslab.app;

import org.mindrot.jbcrypt.BCrypt;
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
        user1.setUsername("johndoe");
        user1.setEmail("jd@mail.com");
        user1.setPassword(BCrypt.hashpw("pimpek33", BCrypt.gensalt()));
        user1.setEnabled(true);
        userRepository.save(user1);

        User user2 = new User();
        user2.setUsername("slane");
        user2.setEmail("suzie@mail.com");
        user2.setPassword(BCrypt.hashpw("passpass", BCrypt.gensalt()));
        user2.setEnabled(true);
        userRepository.save(user2);

        User user3 = new User();
        user3.setUsername("hankblack");
        user3.setEmail("hank@mail.com");
        user3.setPassword(BCrypt.hashpw("trolololo", BCrypt.gensalt()));
        user3.setEnabled(true);
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

        Tweet tweet4 = new Tweet();
        tweet4.setTitle("Still cool");
        tweet4.setTweetText("Everything continues to be cool here");
        tweet4.setUser(user1);
        tweetRepository.save(tweet4);

        Tweet tweet5 = new Tweet();
        tweet5.setTitle("Not so cool now maybe");
        tweet5.setTweetText("But can't complain, really");
        tweet5.setUser(user1);
        tweetRepository.save(tweet5);

    }
}
