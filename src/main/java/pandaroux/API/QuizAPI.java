package pandaroux.API;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pandaroux.Entity.*;
import pandaroux.Service.Entity.Quiz_questionService;
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

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Map getQuizData(@PathVariable("id") int id) {
        return quizService.getQuiz(id);
    }

    @RequestMapping(value="/create", method = RequestMethod.POST)
    public void create(@RequestBody int id,
                       @RequestBody String name,
                       @RequestBody Date date_start,
                       @RequestBody Date date_end,
                       @RequestBody boolean activate,
                       @RequestBody User teacher,
                       @RequestBody Groupe groupe,
                       @RequestBody List<Question> questions
                       ) {
    if(id==0){
        quizService.create(name, date_start, date_end, activate, teacher, groupe, questions);
    }else{
        quizService.alter(id, name, date_start, date_end, activate, teacher, groupe, questions);
    }

    }
}
