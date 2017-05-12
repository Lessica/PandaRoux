package pandaroux.Service.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pandaroux.Repository.QuizRepository;

import java.util.List;
import java.util.Map;

@Service
public class QuizService {

    @Autowired
    private QuizRepository quizRepository;


    public List<Map> findAll() {
        /*
        int userId = sessionService.getUserId();

        if (sessionService.hasRole("eleve")) {
            return quizRepository.findAllStudentQuizzes(userId);
        }
        else if (sessionService.hasRole("prof")) {
            return quizRepository.findAllTeacherQuizzes(userId);
        }*/

        return null;
    }
}
