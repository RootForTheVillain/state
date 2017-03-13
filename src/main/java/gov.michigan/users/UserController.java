package gov.michigan.users;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by bknop on 3/12/2017.
 */
@Controller
@RequestMapping(path="/rest")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping(path="/users/{id}")
    public @ResponseBody User getUserById(@RequestParam int id) {
        return userRepository.findOne(new Long(id));
    }

    //@GetMapping(path = "/users")
    /*public @ResponseBody Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }*/
}