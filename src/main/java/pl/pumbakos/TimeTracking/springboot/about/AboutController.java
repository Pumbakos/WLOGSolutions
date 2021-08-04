package pl.pumbakos.TimeTracking.springboot.about;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/about")
public class AboutController {

    @GetMapping
    public ModelAndView about() {
        ModelAndView view = new ModelAndView();
        view.setViewName("about");

        return view;
    }
}

