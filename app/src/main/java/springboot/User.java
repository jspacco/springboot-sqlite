package springboot;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "User")
public class User {
    @Id
    private Integer uID;
    private String name;

    // Maps to the `user` field in Rating
    @OneToMany(mappedBy = "user")
    private List<Rating> ratings;

    public void setUID(Integer uID) {
        this.uID = uID;
    }
    public Integer getUID() {
        return uID;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
}
