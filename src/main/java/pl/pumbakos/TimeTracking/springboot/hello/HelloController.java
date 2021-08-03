package pl.pumbakos.TimeTracking.springboot.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.pumbakos.TimeTracking.springboot.about.AboutController;
import pl.pumbakos.TimeTracking.springboot.user.UserController;

@Controller
public class HelloController {
    private final AboutController aboutController;
    private final UserController userController;

    @Autowired
    public HelloController(AboutController aboutController, UserController userController){
        this.aboutController = aboutController;
        this.userController = userController;
    }

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @ResponseBody()
    @GetMapping("/hello")
    public String hello(@RequestParam(name = "name", required = false, defaultValue = " there!")
                        String name, Model model){
        model.addAttribute(name);

        return "index";
    }

    @GetMapping("/about")
    public String about(){
        return aboutController.about();
    }

    @GetMapping("/user")
    public String userIndex(){
        return userController.userIndex();
    }
}



