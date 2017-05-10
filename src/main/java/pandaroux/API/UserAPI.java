package pandaroux.API;

import pandaroux.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/user")
public class UserAPI {

    @Autowired
    private UserService userService;
}
