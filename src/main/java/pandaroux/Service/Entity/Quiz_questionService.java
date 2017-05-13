package pandaroux.Service.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pandaroux.Repository.Quiz_questionRepository;

@Service
public class Quiz_questionService {

    @Autowired
    private Quiz_questionRepository quiz_questionRepository;
}
