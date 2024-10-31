package springboot;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class RatingService
{
    private final RatingRepository ratingRepository;

    public RatingService(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    public List<Rating> getAllRatings() {
        return ratingRepository.findAll();
    }

    // Add more methods for filtering and other logic if needed
}