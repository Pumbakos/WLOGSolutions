package pl.pumbakos.TimeTracking.springboot.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.pumbakos.TimeTracking.springboot.about.AboutController;
import pl.pumbakos.TimeTracking.springboot.user.UserController;

@RestController
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
        return "Hello, there!";
    }

    @GetMapping("/hello")
    public String hello(@RequestParam(name = "name", required = false, defaultValue = " there!")
                        String name, Model model){
        model.addAttribute(name);

        return "<h1>Hello, "+ name + "</h1>";
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



