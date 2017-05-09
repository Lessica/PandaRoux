package pandaroux.Controller.API;

import pandaroux.Entity.User;
import pandaroux.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/user")
public class UserAPI {

    @Autowired
    private UserService userService;


    @RequestMapping(method = RequestMethod.GET)
    public List<User> getAll() {
        return userService.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User getStudentById(@PathVariable("id") int id) {
        return userService.findById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void addUser(@RequestBody User user) {
        userService.save(user);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteStudentById(@PathVariable("id") int id) {
        userService.deleteById(id);
    }

}
