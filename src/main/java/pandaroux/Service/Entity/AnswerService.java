package pandaroux.Service.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pandaroux.Entity.Answer;
import pandaroux.Repository.AnswerRepository;

import java.util.List;
import java.util.Map;

@Service
public class AnswerService {

    @Autowired
    private AnswerRepository answerRepository;

    public Map getAnswer(int id) {
        return answerRepository.getAnswer(id);
    }

    public void save(Answer answer) {
        answerRepository.save(answer);
    }
}
