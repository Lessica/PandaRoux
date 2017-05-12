package pandaroux.API;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pandaroux.Entity.User;
import pandaroux.Repository.UserRepository;

import java.util.List;

@RestController
@RequestMapping("api/test")
public class TestAPI {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(method = RequestMethod.GET)
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
