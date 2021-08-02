package pl.pumbakos.TimeTracking.springboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String index(){
        return "<h1>Hello World</h1>";
    }
}
