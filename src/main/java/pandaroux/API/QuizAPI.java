package pandaroux.API;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pandaroux.Entity.*;
import pandaroux.Service.Entity.QuestionService;
import pandaroux.Service.Entity.QuizService;

import javax.xml.ws.soap.Addressing;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/quiz")
public class QuizAPI {

    @Autowired
    private QuizService quizService;


    @RequestMapping(method = RequestMethod.GET)
    public List<Map> findAll() {
        return quizService.findAll();
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void add(@RequestBody Quiz quiz) {
        quizService.save(quiz);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Map getQuizData(@PathVariable("id") int id) {
        return quizService.getQuiz(id);
    }

    @RequestMapping(value="/create", method = RequestMethod.POST)
    public void create(@RequestBody String name,
                       @RequestBody QuestionType type,
                       @RequestBody Date date_start,
                       @RequestBody Date date_end,
                       @RequestBody boolean activate,
                       @RequestBody User teacher,
                       @RequestBody Groupe groupe,
                       @RequestBody List<Question> questions,
                       @RequestBody List<Option> options) {
    Quiz q = new Quiz();
    q.setDate_start(date_start);
    q.setDate_end(date_end);
    q.setActive(activate);
    q.setTeacher(teacher);
    q.setGroupe(groupe);

    quizService.save(q);

    QuestionService questionService = new QuestionService();
    for(Question que:questions){
        questionService.save(que, options);
    }

    }
}
