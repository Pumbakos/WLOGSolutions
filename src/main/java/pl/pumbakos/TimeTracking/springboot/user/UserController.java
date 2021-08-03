package pl.pumbakos.TimeTracking.springboot.user;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private List<User> users = new ArrayList<>();

    public String userIndex() {
        return "<h1>USER INDEX</h1>";
    }

    @GetMapping("/{username}")
    public String
    user(@PathVariable("username") String username) {
        User user = new User(username);
        users.add(user);
        return "<h1>" + user + "</h1>";
    }
}
