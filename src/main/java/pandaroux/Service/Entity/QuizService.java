package pandaroux.Service.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pandaroux.Entity.Quiz;
import pandaroux.Repository.QuizRepository;

import java.util.List;
import java.util.Map;

@Service
public class QuizService {

    @Autowired
    private QuizRepository quizRepository;


    public List<Map> findAll() {
        return quizRepository.findAllQuizzes();
    }

    public void save(Quiz quiz) {
        quizRepository.save(quiz);
    }

    public Map getQuiz(int id) {
        return quizRepository.getQuiz(id);
    }
}
