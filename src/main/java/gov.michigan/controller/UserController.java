package gov.michigan.controller;

import java.net.URI;
import java.util.*;

import io.swagger.annotations.ResponseHeader;
import org.joda.time.LocalDate;
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
import javax.websocket.server.PathParam;

/**
 * Created by bknop on 3/12/2017.
 */
@CrossOrigin
@RestController
@RequestMapping(path="rest/*", consumes = "application/vnd.michigan.v1+json")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private VehicleService vehicleService;

    private enum ApiVersion {
        v1,
        v2
    };

    @ResponseBody
    @PostMapping(path = "login")
    public ResponseEntity<User> authenticate(@RequestBody Map<String, String> creds) {

        User u = userService.findByEmailAndPassword(creds.get("email"), creds.get("password"));
        if (u != null) {
            return new ResponseEntity(u, HttpStatus.CREATED);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @ResponseBody
    @PostMapping(path = "{v1}/login")
    public ResponseEntity<User> authenticate(@RequestBody Map<String, String> creds,
                                             @PathVariable final ApiVersion version) {

        User u = userService.findByEmailAndPassword(creds.get("email"), creds.get("password"));
        if (u != null) {
            return new ResponseEntity(u, HttpStatus.CREATED);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @GetMapping(path="users/{id}/vehicles/{year}/{month}")
    public @ResponseBody Set<Vehicle> getVehicleRenewalsByMonth(
            @PathVariable("id") int id,
            @PathVariable("year") int year,
            @PathVariable("month") int month,
            @RequestParam(required = false, value = "monthToEnd") String monthToEnd) {

        LocalDate dt2;
        LocalDate dt1 = new LocalDate(year, month + 1, 1).withDayOfMonth(1);

        if (monthToEnd != null) {
            int monthOfYear = Integer.parseInt(monthToEnd);
            dt2 = new LocalDate(year, monthOfYear + 1, 1);
        } else {
            dt2 = dt1.plusMonths(1).withDayOfMonth(1).minusDays(1);
        }

        Date start = dt1.toDateTimeAtStartOfDay().toDate();
        Date end = dt2.toDateTimeAtStartOfDay().toDate();

        return vehicleService.findByPlateExpirationBetween(id, start, end);
    }

    @GetMapping(path="users/{id}")
    public @ResponseBody User getUserById(@PathVariable("id") int id) {
        return userService.findById(id);
    }

    @GetMapping(path="users")
    public @ResponseBody List<User> getAllUsers() {
        return userService.findAll();
    }

    @GetMapping(path="{version}/users")
    @ResponseBody
    public List<User> getAllUsers(@PathVariable final ApiVersion version) {
        return userService.findAll();
    }

}