package pandaroux.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pandaroux.Entity.User;
import pandaroux.Repository.UserRepository;

@Service
public class SessionService {
    /*
    private User user;

    @Autowired
    private UserRepository userRepository;


    public SessionService() {
        user = userRepository.findOne(1);
    }

    public User getUser() {
        return user;
    }

    public int getUserId() {
        return user.getId();
    }

    public String getRoleName() {
        return user.getRole().getName();
    }

    public int getRoleId() {
        return user.getRole().getId();
    }

    public boolean hasRole(String role) {
        return user.getRole().getName().equals(role);
    }

    public boolean hasRole(int roleId) {
        return user.getRole().getId() == roleId;
    }*/

}