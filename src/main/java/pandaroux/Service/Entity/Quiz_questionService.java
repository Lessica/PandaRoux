package pandaroux.Service.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pandaroux.Entity.Question;
import pandaroux.Entity.Quiz;
import pandaroux.Entity.Quiz_question;
import pandaroux.Repository.QuestionRepository;
import pandaroux.Repository.QuizRepository;
import pandaroux.Repository.Quiz_questionRepository;

import java.util.HashMap;
import java.util.Map;

@Service
public class Quiz_questionService {

    @Autowired
    private Quiz_questionRepository quiz_questionRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private QuizRepository quizRepository;


    public void save(Quiz_question quiz_question) {
        quiz_questionRepository.save(quiz_question);
    }

    public Map add(Map quiz_question) throws Exception {

        int id_question = (int) quiz_question.get("id_question");
        int id_quiz = (int) quiz_question.get("id_quiz");

        Question question = questionRepository.findOne(id_question);
        Quiz quiz = quizRepository.findOne(id_quiz);

        if (quiz == null || question  == null) {
            throw new Exception("Quiz or question does not exist");
        }

        Quiz_question quiz_questionDB = new Quiz_question();

        quiz_questionDB.setQuestion(question);
        quiz_questionDB.setQuiz(quiz);


        quiz_questionRepository.save(quiz_questionDB);

        Map data = new HashMap();
        data.put("result", "succeed");

        return data;
    }
}
