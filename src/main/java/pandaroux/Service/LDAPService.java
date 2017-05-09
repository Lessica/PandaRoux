package pandaroux.Service;

import pandaroux.Entity.Role;
import pandaroux.Entity.User;
import pandaroux.Repository.RoleRepository;
import pandaroux.Repository.UserRepository;
import pandaroux.Service.LDAP.LDAPAccess;
import pandaroux.Service.LDAP.LDAPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LDAPService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;


    public boolean loginCheck(String login, String password) {

        LDAPAccess access = new LDAPAccess();
        try {
            LDAPObject test = access.LDAPget(login, password);

            if (test == null) {
                return false;
            }

            System.out.println(test.toString());

            System.out.println(test.getType());

            int user_id = Integer.parseInt(test.getNumber());

            if (!userRepository.exists(user_id)) {

                User user = new User();

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
            }

            return true;

        } catch(Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
