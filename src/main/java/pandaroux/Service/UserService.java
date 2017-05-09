package pandaroux.Service;

import pandaroux.Entity.User;
import pandaroux.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(int id) {
        return userRepository.findById(id);
    }

    public void save(User user) {
        userRepository.save(user);
    }

    public void deleteById(int id) {
        userRepository.deleteById(id);
    }

    public boolean exists(int id) {
        return userRepository.exists(id);
    }

    public List<User> findAllStudents() {
        return userRepository.findAllStudents();
    };
}
