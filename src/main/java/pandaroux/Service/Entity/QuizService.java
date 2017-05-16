package pandaroux.Service.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pandaroux.Entity.*;
import pandaroux.Repository.QuizRepository;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class QuizService {

    @Autowired
    private QuizRepository quizRepository;


    public List<Map> findAll() {
        return quizRepository.findAllQuizzes();
    }

    public void save(Quiz quiz) {
        quizRepository.save(quiz);
    }

    public Map getQuiz(int id) {
        return quizRepository.getQuiz(id);
    }

    public void create(String name, Date date_start, Date date_end, boolean activate, User teacher, Groupe groupe, List<Question> questions){
        Quiz q = new Quiz();
        q.setDate_start(date_start);
        q.setDate_end(date_end);
        q.setActive(activate);
        q.setTeacher(teacher);
        q.setGroupe(groupe);
        q.setName(name);

        save(q);

        Quiz_questionService  quiz_questionService = new Quiz_questionService();
        for(Question que:questions){
            Quiz_question temp = new Quiz_question();
            temp.setQuestion(que);
            temp.setQuiz(q);
            quiz_questionService.save(temp);
        }
    }

    public void alter(int id, String name, Date date_start, Date date_end, boolean activate, User teacher, Groupe groupe, List<Question> questions){
        quizRepository.delete(id);
        create(name, date_start, date_end, activate, teacher, groupe, questions);
    }
}
