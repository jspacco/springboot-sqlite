package springboot;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "Rating")
public class Rating 
{
    @Id
    private Integer rID;
    
    @ManyToOne(fetch = FetchType.LAZY)  // Lazy fetch to load only when needed
    @JoinColumn(name = "vID")           // Foreign key to Video
    private Video video;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "uID")           // Foreign key to User
    private User user;
    
    private int stars;

    @Convert(converter = LocalDateAttributeConverter.class)
    // Column annotation still doesn't work
    // spring.jpa.hibernate.naming.physical-strategy setting in application.properties works
    @Column(name = "ratingDate") 
    private LocalDate ratingDate;

    // Getters and setters
    public Integer getRID() {
        return rID;
    }
    public void setRID(Integer rID) {
        this.rID = rID;
    }
    public Video getVideo() {
        return video;
    }
    public void setVideo(Video video) {
        this.video = video;
    }
    public User getUser() {
        return user;
    }
    public void setUID(User user) {
        this.user = user;
    }
    public int getStars() {
        return stars;
    }
    public void setStars(int stars) {
        this.stars = stars;
    }

    public LocalDate getRatingDate() {
        return ratingDate;
    }
    public void setRatingDate(LocalDate ratingDate) {
        this.ratingDate = ratingDate;
    }
}

