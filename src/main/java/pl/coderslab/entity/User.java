package pl.coderslab.entity;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.mindrot.jbcrypt.BCrypt;
import pl.coderslab.validator.groups.FullUserValidationGroup;

import javax.persistence.*;
import javax.validation.groups.Default;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(groups = {Default.class, FullUserValidationGroup.class})
    @Column(length = 100, unique = true)
    private String username;

    @NotEmpty(groups = {Default.class, FullUserValidationGroup.class})
    @Column(length = 100)
    private String password;

    private boolean enabled;

    @NotEmpty(groups = FullUserValidationGroup.class)
    @Email(groups = FullUserValidationGroup.class)
    private String email;

    @OneToMany(mappedBy = "user")
    private List<Tweet> tweets = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Comment> comments = new ArrayList<>();

    @OneToMany(mappedBy = "sender")
    private List<Message> messagesSent = new ArrayList<>();

    @OneToMany(mappedBy = "receiver")
    private List<Message> messagesReceived = new ArrayList<>();

    public User() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Tweet> getTweets() {
        return tweets;
    }

    public void setTweets(List<Tweet> tweets) {
        this.tweets = tweets;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Message> getMessagesSent() {
        return messagesSent;
    }

    public void setMessagesSent(List<Message> messagesSent) {
        this.messagesSent = messagesSent;
    }

    public List<Message> getMessagesReceived() {
        return messagesReceived;
    }

    public void setMessagesReceived(List<Message> messagesReceived) {
        this.messagesReceived = messagesReceived;
    }

    @Override
    public String toString() {
        return username;}
}
