package pandaroux.Service.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pandaroux.Entity.Quiz_question;
import pandaroux.Repository.Quiz_questionRepository;

@Service
public class Quiz_questionService {

    @Autowired
    private Quiz_questionRepository quiz_questionRepository;

    public void save(Quiz_question quiz_question) {
        quiz_questionRepository.save(quiz_question);
    }
}
