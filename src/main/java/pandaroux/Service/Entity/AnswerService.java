package pandaroux.Service.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pandaroux.Entity.Answer;
import pandaroux.Entity.Quiz_question;
import pandaroux.Entity.User;
import pandaroux.Repository.AnswerRepository;
import pandaroux.Repository.QuestionRepository;
import pandaroux.Repository.Quiz_questionRepository;
import pandaroux.Repository.UserRepository;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AnswerService {

    @Autowired
    private AnswerRepository answerRepository;

    @Autowired
    private Quiz_questionRepository quiz_questionRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private UserRepository userRepository;


    public Map getAnswer(int id) {
        Map answerData = new HashMap();
        answerData.put("result", "succeed");
        answerData.put("getAnswerDetails", answerRepository.getAnswer(id));

        return answerData;
    }

    public void save(Answer answer) {
        answerRepository.save(answer);
    }
}
