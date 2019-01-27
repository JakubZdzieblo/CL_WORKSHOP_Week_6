package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.entity.Tweet;
import pl.coderslab.entity.User;

import java.util.List;

public interface TweetRepository extends JpaRepository<Tweet, Long> {

    List<Tweet> findAllByOrderByCreatedDesc();

    List<Tweet> findAllByUserId(Long id);

    List<Tweet> findAllByUserOrderByCreatedDesc(User user);

    List<Tweet> findAllByUserIdOrderByCreatedDesc(Long id);

    List<Tweet> findAllByTitleStartingWithOrderByCreatedDesc(String title);


}
