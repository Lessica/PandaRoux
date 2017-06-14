package pandaroux.Service.Entity;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pandaroux.Entity.*;
import pandaroux.Repository.*;
import pandaroux.Service.ParametersService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class QuizService {

    @Autowired
    private QuizRepository quizRepository;

    @Autowired
    private GroupeRepository groupeRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private Quiz_questionRepository quiz_questionRepository;

    @Autowired
    private QuestionRepository questionRepository;


    public List<Map> findAll() {
        return quizRepository.findAllQuizzes();
    }

    public Map getQuiz(int id) {

        Map data = quizRepository.getQuiz(id);

        List<Map> questions = questionRepository.getQuizQuestions(id);

        questions = ParametersService.parametersObject(questions);

        data.put("questons", questions);

        return data;
    }


    public Map add(Map quiz, int teacherId) throws Exception {

        Quiz quizDB;

        if (quiz.containsKey("id")) {
            int id_quiz = (int) quiz.get("id");

            if (quizRepository.exists(id_quiz)) {
                quizDB = quizRepository.findOne(id_quiz);
            } else {
                quizDB = new Quiz();
                quizDB.setId(id_quiz);
            }
        } else {
            quizDB = new Quiz();
        }

        User teacher = userRepository.findOne(teacherId);
        quizDB.setTeacher(teacher);

        if (quiz.containsKey("name")) {
            quizDB.setName((String) quiz.get("name"));
        }

        if (quiz.containsKey("active")) {
            quizDB.setActive((Boolean) quiz.get("active"));
        }

        if (quiz.containsKey("date_start")) {
            Date date_start = new SimpleDateFormat("yyyy-MM-dd").parse((String) quiz.get("date_start"));
            quizDB.setDate_start(date_start);
        }

        if (quiz.containsKey("date_end")) {
            Date date_end = new SimpleDateFormat("yyyy-MM-dd").parse((String) quiz.get("date_end"));
            quizDB.setDate_end(date_end);
        }

        if (quiz.containsKey("id_group")) {
            Groupe groupe = groupeRepository.findOne((int) quiz.get("id_group"));
            quizDB.setGroupe(groupe);
        }

        if (quiz.containsKey("id_questions")) {

            List<Integer> id_questions = (List) quiz.get("id_questions");

            for (int id_question : id_questions) {

                Question question = questionRepository.findOne(id_question);

                if (question == null) throw new Exception("Quiz or question does not exist");

                Quiz_question quiz_question = new Quiz_question();

                quiz_question.setQuiz(quizDB);
                quiz_question.setQuestion(question);

                quiz_questionRepository.save(quiz_question);
            }
        }

        quizRepository.save(quizDB);

        Map data = new HashMap();
        data.put("result", "succeed");
        data.put("id_quiz", quizDB.getId());

        return data;
    }

    public Map getQuizzes(int teacherId) {
        Map data = new HashMap();
        data.put("quiz_list", quizRepository.findAllTeacherQuizzes(teacherId));
        return data;
    }

    public Map quizRelatedData(int teacherId) {
        Map data = new HashMap();
        data.put("quiz_list", quizRepository.findAllTeacherQuizzes(teacherId));
        data.put("group_list", groupeRepository.getGroupes(teacherId));
        data.put("question_list", questionRepository.getTeacherQuestionsBrief(teacherId));
        return data;
    }
}
