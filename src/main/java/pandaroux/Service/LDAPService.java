package pandaroux.Service;

import pandaroux.Entity.Role;
import pandaroux.Entity.User;
import pandaroux.Repository.RoleRepository;
import pandaroux.Repository.UserRepository;
import pandaroux.LDAP.LDAPAccess;
import pandaroux.LDAP.LDAPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


@Service
public class LDAPService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;


    public Map loginCheck(Map loginData) throws Exception {

        Map result = new HashMap();

        result.put("loginSucces", false);

        try {
            LDAPAccess access = new LDAPAccess();

            String login = (String) loginData.get("login");
            String password = (String) loginData.get("password");

            LDAPObject test = access.LDAPget(login, password);

            if (test == null) {
                return result;
            }

            System.out.println(test.toString());

            System.out.println(test.getType());

            int user_id = Integer.parseInt(test.getNumber());

            User user = new User();
            System.out.println(" _____ test _____");
            System.out.println(userRepository.existsById_isep(user_id));

            if (userRepository.existsById_isep(user_id) < 1) {

                String roleName = test.getType();

                Role role = roleRepository.findByName(roleName);

                if (role == null) {

                    role = new Role();

                    role.setName(roleName);

                    roleRepository.save(role);
                }

                user.setId_isep(user_id);
                user.setName(test.getNomFamille());
                user.setFirst_name(test.getPrenom());
                user.setRole(role);

                System.out.println(user);

                userRepository.save(user);
            } else {
                user = userRepository.findUserById_isep(user_id);
            }

            result.put("redirectionLink", SecurityService.getRedirectionLink(user));
            result.put("user", user);
            result.replace("loginSucces", true);

        } catch (Exception e) {
            result.put("message", e.getMessage());
        }

        return result;
    }
}
