package pandaroux.Service.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pandaroux.Entity.*;
import pandaroux.Repository.GroupeRepository;
import pandaroux.Repository.QuizRepository;
import pandaroux.Repository.UserRepository;

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


    public List<Map> findAll() {
        return quizRepository.findAllQuizzes();
    }

    public Map getQuiz(int id) {
        return quizRepository.getQuiz(id);
    }


    public Map add(Map quiz, int teacherId) throws ParseException {

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


        quizRepository.save(quizDB);

        Map data = new HashMap();
        data.put("result", "succeed");
        data.put("id_quiz", quizDB.getId());

        return data;
    }
}
