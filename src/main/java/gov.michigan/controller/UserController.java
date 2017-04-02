package gov.michigan.controller;

import java.net.URI;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import gov.michigan.model.User;
import gov.michigan.model.Vehicle;
import gov.michigan.service.UserService;
import gov.michigan.service.VehicleService;

import javax.print.attribute.standard.Media;

/**
 * Created by bknop on 3/12/2017.
 */
@CrossOrigin
@RestController
@RequestMapping(path="rest/users*")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private VehicleService vehicleService;

    @PostMapping(path = "login", consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<User> authenticate(@RequestBody Map<String, String> creds) {

        User u = userService.findByEmailAndPassword(creds.get("email"), creds.get("password"));
        if (u != null) {
            return new ResponseEntity(u, HttpStatus.CREATED);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @GetMapping(path="{id}/vehicles/{year}/{month}")
    public @ResponseBody Set<Vehicle> getVehicleRenewals(
            @PathVariable("id") int id,
            @PathVariable("year") int year,
            @PathVariable("month") int month) {

        Date start = new Date();
        Date end = new Date();
        Calendar c = Calendar.getInstance();
        c.set(year, month, start.getDate());
        start = c.getTime();
        c.add(Calendar.DATE, 32);  // number of days to add;
        end = c.getTime();

        return vehicleService.findByPlateExpirationBetween(id, start, end);
    }

    @GetMapping(path="{id}")
    public @ResponseBody User getUserById(@PathVariable("id") int id) {
        return userService.findById(id);
    }

    @GetMapping
    public @ResponseBody List<User> getAllUsers() {
        return userService.findAll();
    }

}