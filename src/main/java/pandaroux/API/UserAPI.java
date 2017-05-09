package pandaroux.API;

import pandaroux.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/user")
public class UserAPI {

    @Autowired
    private UserService userService;

    /*
    RequestMapping(method = RequestMethod.GET)
    public List<Object> getGroupes() {
        return userService.getGroupes();
    }*/
}
