package pandaroux.Service.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pandaroux.Entity.*;
import pandaroux.Repository.*;
import pandaroux.Service.ParametersService;

import java.text.SimpleDateFormat;
import java.util.*;

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

        data.put("questions", ParametersService.parametersObject(questions));

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

        if (quiz.containsKey("id_groupe")) {
            Groupe groupe = groupeRepository.findOne((int) quiz.get("id_groupe"));
            quizDB.setGroupe(groupe);
        }

        quizRepository.save(quizDB);

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

    public Map getTeacherQuizzes(int id_teacher) {

        List<Map> teacherQuizzes = quizRepository.getTeacherQuizzes(id_teacher);

        System.out.println(teacherQuizzes);

        Map data = new HashMap();

        data.put("result", "succeed");
        data.put("quizzes_active", new ArrayList<Map>());
        data.put("quizzes_inactive", new ArrayList<Map>());
        data.put("quizzes_finished", new ArrayList<Map>());
        data.put("quizzes_coming", new ArrayList<Map>());


        Date now = new Date();

        System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(now));

        for (Map teacherQuiz : teacherQuizzes) {

            Date date_start = (Date) teacherQuiz.get("date_start");
            Date date_end = (Date) teacherQuiz.get("date_end");
            boolean active = (boolean) teacherQuiz.get("active");

            if (!active) {
                ((List) data.get("quizzes_inactive")).add(teacherQuiz);
            }
            else if (now.after(date_start) && now.before(date_end)){
                ((List) data.get("quizzes_active")).add(teacherQuiz);
            }
            else if (now.after(date_end)) {
                ((List) data.get("quizzes_finished")).add(teacherQuiz);
            }
            else {
                ((List) data.get("quizzes_coming")).add(teacherQuiz);
            }
        }

        return data;
    }
}
