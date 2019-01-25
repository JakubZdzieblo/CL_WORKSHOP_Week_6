package pl.coderslab.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Table(name = "tweeter_tweet")
public class Tweet {

    // id - klucz główny
    //title - minimalna długość 5 znaków, maksymalna długość 50, pole wymagane
    //tweetText - pole wymagane, maksymalna długość 160 znaków
    //created (data dodania)

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 5, max = 50)
    @Column(length = 50)
    private String title;

    @Size(max = 160)
    @NotEmpty
    @Column(length = 160)
    private String tweetText;

    @CreationTimestamp
    private LocalDate created;

    @ManyToOne
    private User user;

    public Tweet() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTweetText() {
        return tweetText;
    }

    public void setTweetText(String tweetText) {
        this.tweetText = tweetText;
    }

    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return title;
    }
}
