package pl.coderslab.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.entity.Tweet;
import pl.coderslab.entity.User;
import pl.coderslab.repository.TweetRepository;
import pl.coderslab.repository.UserRepository;

public class TweetConverter implements Converter<String, Tweet> {

    @Autowired
    private TweetRepository tweetRepository;

    @Override
    public Tweet convert(String s) {
        return tweetRepository.findOne( Long.parseLong(s) );
    }
}