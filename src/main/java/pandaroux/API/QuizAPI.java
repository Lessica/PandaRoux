package pandaroux.API;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pandaroux.Entity.Quiz;
import pandaroux.Service.Entity.QuizService;

import javax.xml.ws.soap.Addressing;
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
}
