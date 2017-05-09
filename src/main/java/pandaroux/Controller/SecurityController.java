package pandaroux.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pandaroux.Service.LDAPService;


@RestController
public class SecurityController {

    @Autowired
    private LDAPService ldapService;

    @RequestMapping(value = "/loginCheck", method = RequestMethod.POST)
    public Object loginCheck(@RequestParam("login") String login,
                              @RequestParam("password") String password) {
        return ldapService.loginCheck(login, password);
    }
}
