package pandaroux.Service.Entity;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pandaroux.Entity.Answer;
import pandaroux.Entity.Quiz_question;
import pandaroux.Entity.User;
import pandaroux.Repository.*;
import pandaroux.Service.ParametersService;

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

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private QuizRepository quizRepository;
    

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

        answers = ParametersService.parametersObject(answers);

        data.put("answer_list", answers);

        return data;
    }

    public Map getAnswer(int id) {

        return null;
    }

    public Map quiz(Map answers, int id_student) {

        System.out.println(answers);

        int id_quiz = (int) answers.get("id_quiz");
        List<Map> questions = (List<Map>) answers.get("questions");

        for (Map question : questions) {

            int id_question = (int) question.get("id_question");

            Answer answer = new Answer();

            answer.setDate(new Date());
            answer.setQuiz_question(quiz_questionRepository.findOneQuiz_question(id_quiz, id_question));
            answer.setStudent(userRepository.findOne(id_student));


            if (question.containsKey("text")) {
                answer.setText((String) question.get("text"));
            }

            if (question.containsKey("parameters")) {
                answer.setJsonParameters(new Gson().toJson(question.get("parameters"), Object.class));
            }

            answerRepository.save(answer);
        }

        Map data = new HashMap();
        data.put("result", "succeed");

        return data;
    }
}
