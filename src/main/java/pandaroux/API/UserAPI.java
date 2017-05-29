package pandaroux.API;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pandaroux.Entity.User;
import pandaroux.Service.Entity.UserService;
import pandaroux.Service.SecurityService;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("api/user")
public class UserAPI {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.POST)
    public Map findAll() {
        return userService.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public Map findOneById(@PathVariable("id") int id) {
        return userService.findOneById(id);
    }

    @RequestMapping(value = "/students", method = RequestMethod.POST)
    public Map getStudents() {
        return userService.getStudents();
    }
}
