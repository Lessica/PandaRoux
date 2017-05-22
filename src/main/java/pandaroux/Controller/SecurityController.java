package pandaroux.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pandaroux.Service.LDAPService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@RestController
public class SecurityController {

    @Autowired
    private LDAPService ldapService;

    @RequestMapping(value = "/loginCheck", method = RequestMethod.POST)
    public Map loginCheck(@RequestParam("login") String login,
                          @RequestParam("password") String password,
                          HttpServletRequest request) {

        // return ldapService.loginCheck(login, password, request.getSession());

        return null;
    }

    @RequestMapping(value = "/session", method = RequestMethod.GET)
    public String viewSession(HttpServletRequest request) {

        return request.getSession().getAttribute("user").toString();
    }
}
