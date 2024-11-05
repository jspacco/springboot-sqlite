package springboot;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Video")
public class Video {
    @Id
    private Integer vID;
    private String title;
    private Integer year;
    private String uploader;

    // Maps to the `video` field in Rating
    @OneToMany(mappedBy = "video")
    private List<Rating> ratings;

    // Getters and setters
    public Integer getVID() {
        return vID;
    }
    public void setVID(Integer vID) {
        this.vID = vID;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getTitle() {
        return title;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public Integer getYear() {
        return year;
    }
    public void setUploader(String uploader) {
        this.uploader = uploader;
    }
    public String getUploader() {
        return uploader;
    }
}

