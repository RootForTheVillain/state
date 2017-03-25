package gov.michigan.controller;

import java.util.List;
import java.util.Set;

import gov.michigan.model.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import gov.michigan.model.User;
import gov.michigan.service.UserService;

/**
 * Created by bknop on 3/12/2017.
 */
@Controller
@CrossOrigin
@RequestMapping(path="/rest/*")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(path="users/{id}", method= RequestMethod.GET)
    public @ResponseBody User getUserById(@PathVariable("id") int id) {
        return userService.findById(id);
    }

    @RequestMapping(path="users", method= RequestMethod.GET)
    public @ResponseBody List<User> getAllUsers() {
        return userService.findAll();
    }

    @RequestMapping(path="users/{id}/vehicles", method=RequestMethod.GET)
    public @ResponseBody Set<Vehicle> getVehiclesForUser(@PathVariable("id") int id) {
        return userService.findVehiclesById(id);
    }
}