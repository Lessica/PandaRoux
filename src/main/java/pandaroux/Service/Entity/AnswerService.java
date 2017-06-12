package pandaroux.Service.Entity;

import com.google.gson.Gson;
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
    private UserRepository userRepository;
    

    public Map add(Map answer) throws ParseException {

        Answer answerDB;

        if (answer.containsKey("id")) {
            int id_quiz = (int) answer.get("id");

            if (answerRepository.exists(id_quiz)) {
                answerDB = answerRepository.findOne(id_quiz);
            } else {
                answerDB = new Answer();
                answerDB.setId(id_quiz);
            }
        } else {
            answerDB = new Answer();
        }

        if (answer.containsKey("date")) {
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse((String) answer.get("date"));
            answerDB.setDate(date);
        }

        if (answer.containsKey("parameters")) {
            String json = new Gson().toJson(answer.get("parameters"), Object.class);
            answerDB.setJsonParameters(json);
        }

        if (answer.containsKey("text")) {
            answerDB.setText((String) answer.get("text"));
        }

        if (answer.containsKey("id_quiz_question")) {
            Quiz_question quiz_question = quiz_questionRepository.findOne((int) answer.get("id_quiz_question"));
            answerDB.setQuiz_question(quiz_question);
        }

        if (answer.containsKey("id_student")) {
            User student = userRepository.findOne((int) answer.get("id_student"));
            answerDB.setStudent(student);
        }

        answerRepository.save(answerDB);

        Map data = new HashMap();
        data.put("result", "succeed");

        return data;
    }

    public Map getAnswers() {

        Map data = new HashMap();

        List<Map> answers = answerRepository.getAnswers();

        for(int i=0; i<answers.size(); i++) {

            String parameters = (String) answers.get(i).get("parameters");

            Object object = new Gson().fromJson(parameters, Object.class);

            answers.get(i).put("parameters", object);
        }

        data.put("answer_list", answers);

        return data;
    }

    public Map getAnswer(int id) {

        return null;
    }
}
