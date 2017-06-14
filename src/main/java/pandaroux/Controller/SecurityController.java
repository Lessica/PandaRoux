package pandaroux.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pandaroux.Entity.Role;
import pandaroux.Entity.User;
import pandaroux.Service.LDAPService;
import pandaroux.Service.SecurityService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@RestController
public class SecurityController {

    @Autowired
    private LDAPService ldapService;


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Map login(@RequestBody Map loginData,
                          HttpServletRequest request) throws Exception {

        // with isep network
        // Map result = ldapService.loginCheck(loginData);

        // without isep network

        Map result = new HashMap() {{
            put("loginSucces", true);
            put("redirectionLink", "/student/index");
            put("user", new User() {{
                setId(6);
                setName("Not on isep network");
                setFirst_name("test");
                setRole(new Role() {{
                    setName("eleve");
                }});
            }});
        }};


        SecurityService.addUserToSession((User) result.get("user"), request);

        result.remove("user");

        return result;
    }

    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public Map logout(HttpServletRequest request) {

        HttpSession session = request.getSession();
        session.removeAttribute("user");

        Map result = new HashMap();
        result.put("succeed", true);

        return result;
    }

    @RequestMapping(value = "/session", method = RequestMethod.POST)
    public Map viewSession(HttpServletRequest request) throws Exception {

        Map user = (Map) request.getSession(true).getAttribute("user");

        if (user == null) {
            throw new Exception("No user connected");
        }

        return user;
    }
}
