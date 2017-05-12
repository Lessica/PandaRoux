package pandaroux.API;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pandaroux.Service.Entity.UserService;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("api/user")
public class UserAPI {

    @Autowired
    private UserService userService;


    @RequestMapping(method = RequestMethod.GET)
    public List<Map> findAll() {
        return userService.findAll();
    }
}
