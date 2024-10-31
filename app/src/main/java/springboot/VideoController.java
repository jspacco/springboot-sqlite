package springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@Controller
public class VideoController
{

    @Autowired
    private VideoService videoService;

    @GetMapping("/videos")
    public String showVideos(Model model)
    {
        List<Video> videos = videoService.getAllVideos();
        model.addAttribute("videos", videos);
        return "videos";
    }
}

