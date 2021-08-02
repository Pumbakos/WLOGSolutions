package pl.pumbakos.TimeTracking.springboot;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String index(){
        return "<h1>Hello World</h1>";
    }

    @GetMapping("/hello")
    public String hello(@RequestParam(name = "name", required = false, defaultValue = " there!")
                        String name, Model model){
        model.addAttribute(name);

        return "<h1>Hello, "+ name + "</h1>";
    }
}



