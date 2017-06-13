package pandaroux.API;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pandaroux.Entity.Quiz_question;
import pandaroux.Service.Entity.Quiz_questionService;

import java.util.Map;

@RestController
@RequestMapping("api/quiz_question")
public class Quiz_questionAPI {

    @Autowired
    private Quiz_questionService quiz_questionService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Map add(@RequestBody Map quiz_question) throws Exception {
        return quiz_questionService.add(quiz_question);
    }
}
