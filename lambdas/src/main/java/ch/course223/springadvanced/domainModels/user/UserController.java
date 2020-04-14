package ch.course223.springadvanced.domainModels.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/getBestEarning")
    public @ResponseBody ResponseEntity<User> getBestEarningUser() {
        return new ResponseEntity<User>(userService.getBestEarningUser(), HttpStatus.OK);
    }

    @GetMapping("/getWorstEarning")
    public @ResponseBody ResponseEntity<User> getWorstEarningUser() {
        return new ResponseEntity<User>(userService.getWorstEarningUser(), HttpStatus.OK);
    }

    @GetMapping("/evenEarnings")
    public @ResponseBody ResponseEntity<List<User>> allUsersWithEvenEarnings() {
        return new ResponseEntity<List<User>>(userService.allUsersWithEvenEarnings(), HttpStatus.OK);
    }

    @GetMapping("/oddEarnings")
    public @ResponseBody ResponseEntity<List<User>> allUsersWithOddEarnings() {
        return new ResponseEntity<List<User>>(userService.allUsersWithOddEarnings(), HttpStatus.OK);
    }

    @GetMapping("/earningMoreThan")
    public @ResponseBody ResponseEntity<List<User>> allUsersEarningMoreThan() {
        return new ResponseEntity<List<User>>(userService.allUsersEarningMoreThan(2000), HttpStatus.OK);
    }

    @GetMapping("/earningLessThan")
    public @ResponseBody ResponseEntity<List<User>> allUsersEarningLessThan() {
        return new ResponseEntity<List<User>>(userService.allUsersEarningLessThan(2000), HttpStatus.OK);
    }

    @GetMapping("/EarningBetween")
    public @ResponseBody ResponseEntity<List<User>> allUsersEarningBetween() {
        return new ResponseEntity<List<User>>(userService.allUsersEarningBetween(1000, 2000), HttpStatus.OK);
    }

    @GetMapping("/EarningAboveAverage")
    public @ResponseBody ResponseEntity<List<User>> allUsersEarningAboveAverage() {
        return new ResponseEntity<List<User>>(userService.allUsersEarningAboveAverage(), HttpStatus.OK);
    }

    @GetMapping("/EarningLessAverage")
    public @ResponseBody ResponseEntity<List<User>> allUsersEarningLessAverage() {
        return new ResponseEntity<List<User>>(userService.allUsersEarningLessAverage(), HttpStatus.OK);
    }
}
