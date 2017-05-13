package pandaroux.API;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pandaroux.Service.Entity.QuizService;

import javax.xml.ws.soap.Addressing;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/quiz")
public class QuizAPI {

    @Autowired
    private QuizService quizService;


    @RequestMapping(value="/teacher", method = RequestMethod.GET)
    public List<Map> findAll() {
        return quizService.findAll();
    }
}
