package springboot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RatingController 
{
    @Autowired
    private RatingService ratingService;

    @GetMapping("/ratings")
    public String showRatings(Model model)
    {
        List<Rating> ratings = ratingService.getAllRatings();
        model.addAttribute("ratings", ratings);
        return "ratings";
    }
}
