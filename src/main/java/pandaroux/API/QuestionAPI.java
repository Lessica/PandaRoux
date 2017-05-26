package pandaroux.API;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pandaroux.Service.Entity.QuestionService;

import java.util.Map;

@RestController
@RequestMapping("api/question")
public class QuestionAPI {

    @Autowired
    private QuestionService questionService;


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Map add(@RequestBody Map question) {
        return questionService.add(question);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Map getQuestions() {
        return questionService.getQuestions();
    }

    @RequestMapping(value = "/teacher", method = RequestMethod.POST)
    public Map getTeacherQuestions() {
        return questionService.getTeacherQuestions();
    }
}
