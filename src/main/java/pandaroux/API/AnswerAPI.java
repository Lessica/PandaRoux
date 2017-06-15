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

    public Map getAnswer(@PathVariable("id") int id) {
        return answerService.getAnswer(id);
    }

    public Map getAnswers() {
        return answerService.getAnswers();
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Map add(@RequestBody Map answer) throws ParseException {
        return answerService.add(answer);
    }

    @RequestMapping(value = "/add/quiz", method = RequestMethod.POST)
    public Map addByQuiz(@RequestBody Map answers,
                    HttpServletRequest request) throws Exception {
        return answerService.quiz(answers, SecurityService.getUserId(request));
    }

    @RequestMapping(value = "/quiz/{id}", method = RequestMethod.POST)
    public Map answersForQuiz(@PathVariable("id") int id_quiz,
                            HttpServletRequest request) throws Exception {
        return answerService.answersForQuiz(id_quiz, SecurityService.getUserId(request));
    }

}
