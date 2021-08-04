package pl.pumbakos.TimeTracking.springboot.user;

import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    List<User> users = new ArrayList<>();

    @GetMapping
    public ModelAndView userIndex() {
        ModelAndView view = new ModelAndView();
        view.setViewName("user");
        return view;
    }

    @GetMapping("/{username}")
    public String user(@PathVariable("username") String username) {
        return users.stream().filter(u -> u.getName().equals(username)).findFirst().toString();
    }

    @PostMapping
    public User saveUser(@RequestBody User user) {
        User newUser = new User(user.getName(), user.getSurname(), user.getImageUrl());
        users.add(newUser);
        return newUser;
    }

    @GetMapping(value = "/print-all", produces = MediaType.TEXT_HTML_VALUE)
    public ModelAndView printUsers(Model model) {
        ModelAndView view = new ModelAndView();
        view.setViewName("user-list");
        model.addAllAttributes(users);
        return view;
    }
}