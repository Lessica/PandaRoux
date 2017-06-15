package pandaroux.API;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pandaroux.Service.Entity.AnswerService;
import pandaroux.Service.SecurityService;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.Map;

@RestController
@RequestMapping("api/answer")
public class AnswerAPI {

    @Autowired
    private AnswerService answerService;


    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public Map getAnswer(@PathVariable("id") int id) {
        return answerService.getAnswer(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Map getAnswers() {
        return answerService.getAnswers();
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Map add(@RequestBody Map answer) throws ParseException {
        return answerService.add(answer);
    }

    @RequestMapping(value = "/quiz", method = RequestMethod.POST)
    public Map quiz(@RequestBody Map answers,
                    HttpServletRequest request) throws Exception {
        return answerService.quiz(answers, SecurityService.getUserId(request));
    }


}
