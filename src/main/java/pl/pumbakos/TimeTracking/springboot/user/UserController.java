package pl.pumbakos.TimeTracking.springboot.user;

import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    List<User> users = new ArrayList<>();

    public String userIndex() {
        return "user";
    }

    @GetMapping("/{username}")
    public String user(@PathVariable("username") String username) {
        return users.stream().filter(u -> u.getName().equals(username)).findFirst().toString();
    }

    @ResponseBody
    @PostMapping("")
    public User saveUser(@RequestParam(name = "name") String name,
                         @RequestParam(name = "surname") String surname,
                         @RequestParam(name = "image") String imageUrl){
        User user = new User(name, surname, imageUrl);
        users.add(user);

        return user;
    }

    @GetMapping(value = "/print-all", produces = MediaType.TEXT_HTML_VALUE)
    public String printUsers(Model model){
        model.addAllAttributes(users);
        return "user-list";
    }
}