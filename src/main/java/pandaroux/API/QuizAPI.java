package pandaroux.API;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pandaroux.Entity.*;
import pandaroux.Service.Entity.Quiz_questionService;
import pandaroux.Service.Entity.QuizService;
import pandaroux.Service.SecurityService;

import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.soap.Addressing;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/quiz")
public class QuizAPI {

    @Autowired
    private QuizService quizService;


    @RequestMapping(method = RequestMethod.POST)
    public List<Map> findAll() {
        return quizService.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public Map getQuiz(@PathVariable("id") int id) {
        return quizService.getQuiz(id);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Map add(@RequestBody Map quiz,
                   HttpServletRequest request) throws Exception {
        return quizService.add(quiz, SecurityService.getUserId(request));
    }
}
