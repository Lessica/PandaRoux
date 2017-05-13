package pandaroux.Service.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pandaroux.Repository.AnswerRepository;

@Service
public class AnswerService {

    @Autowired
    private AnswerRepository answerRepository;
}
