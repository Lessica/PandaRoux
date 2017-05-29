package pandaroux.Service.Entity;

import pandaroux.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pandaroux.Repository.UserRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Map findAll() {
        Map resp = new HashMap();

        resp.put("result", "succeed");
        resp.put("users", userRepository.findAllUser());

        return resp;
    }

    public Map findOneById(int id) {
        Map resp = new HashMap();

        resp.put("result", "succeed");
        resp.put("user", userRepository.findOneById(id));

        return resp;
    }

    public Map getStudents() {
        Map studentData = new HashMap();

        studentData.put("result", "succeed");
        studentData.put("students", userRepository.getStudents());

        return studentData;
    }
}
