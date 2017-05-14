package pandaroux.Service.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pandaroux.Entity.Question;
import pandaroux.Repository.QuestionRepository;

import java.util.List;
import java.util.Map;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    public void save(Question question) {
        questionRepository.save(question);
    }

    public List<Map> getQuestions() {
        return questionRepository.getQuestions();
    }
}
