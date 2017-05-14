package pandaroux.API;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pandaroux.Entity.Lecture;
import pandaroux.Entity.Question;
import pandaroux.Service.Entity.QuestionService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/question")
public class QuestionAPI {

    @Autowired
    private QuestionService questionService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void add(@RequestBody Question question) {
        questionService.save(question);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Map> getQuestions() {
        return questionService.getQuestions();
    }
}
