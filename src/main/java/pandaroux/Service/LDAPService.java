package pandaroux.Service;

import pandaroux.Entity.Role;
import pandaroux.Entity.User;
import pandaroux.Repository.RoleRepository;
import pandaroux.Repository.UserRepository;
import pandaroux.LDAP.LDAPAccess;
import pandaroux.LDAP.LDAPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;


@Service
public class LDAPService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;


    public Map loginCheck(String login, String password, HttpSession session) {

        Map result = new HashMap();

        result.put("loginSucces", false);
        result.put("message", null);


        LDAPAccess access = new LDAPAccess();
        try {
            LDAPObject test = access.LDAPget(login, password);

            if (test == null) {
                return result;
            }

            System.out.println(test.toString());

            System.out.println(test.getType());

            int user_id = Integer.parseInt(test.getNumber());

            User user = new User();

            if (!userRepository.exists(user_id)) {

                String roleName = test.getType();

                Role role = roleRepository.findByName(roleName);

                if (role == null) {

                    role = new Role();

                    role.setName(roleName);

                    roleRepository.save(role);
                }

                user.setId(user_id);
                user.setName(test.getNomFamille());
                user.setFirst_name(test.getPrenom());
                user.setRole(role);

                System.out.println(user);

                userRepository.save(user);
            } else {
                user = userRepository.findOne(user_id);
            }

            result.replace("loginSucces", true);
            session.setAttribute("user", user);

            return result;

        } catch(Exception e) {
            System.out.println(e.getMessage());
            return result;
        }
    }
}
