package pandaroux.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pandaroux.Service.LDAPService;

import javax.servlet.http.HttpSession;

@RestController
public class SecurityController {

    @Autowired
    private LDAPService ldapService;

    @RequestMapping(value = "/loginCheck", method = RequestMethod.POST)
    public boolean loginCheck(@RequestParam("login") String login,
                                @RequestParam("password") String password) {
        // return ldapService.loginCheck(login, password);

        return true;
    }
}
