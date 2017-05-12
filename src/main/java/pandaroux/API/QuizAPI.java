package pandaroux.API;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pandaroux.Service.Entity.QuizService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/quiz")
public class QuizAPI {

    private QuizService quizService;


    @RequestMapping(method = RequestMethod.GET)
    public List<Map> findAll() {
        return quizService.findAll();
    }
}
