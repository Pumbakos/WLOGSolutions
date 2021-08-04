package pl.pumbakos.TimeTracking.springboot.hello;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class HelloController {

    @GetMapping("/")
    public ModelAndView index() {
        ModelAndView view = new ModelAndView();
        view.setViewName("index");
        return view;
    }

    @GetMapping("/hello")
    public ModelAndView hello(@RequestParam(name = "name", required = false, defaultValue = " there!")
                                      String name, Model model) {
        ModelAndView view = new ModelAndView();
        view.setViewName("index");
        model.addAttribute(name);

        return view;
    }
}



