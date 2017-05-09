package pandaroux.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pandaroux.Service.LDAPService;


@Controller
public class DefaultController {

    @Autowired
    private LDAPService ldapService;

    @RequestMapping(value = "/loginCheck", method = RequestMethod.POST)
    public boolean loginCheck(@RequestParam("login") String login,
                              @RequestParam("password") String password) {
        return ldapService.loginCheck(login, password);
    }

    @RequestMapping(value = "/")
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/login")
    public String login() {
        return "login";
    }
}