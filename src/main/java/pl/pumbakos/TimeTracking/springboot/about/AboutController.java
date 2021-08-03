package pl.pumbakos.TimeTracking.springboot.about;

import org.springframework.stereotype.Controller;

@Controller
public class AboutController {

    public String about(){
        return "<h1>WLOGSolutions</h1>";
    }
}

