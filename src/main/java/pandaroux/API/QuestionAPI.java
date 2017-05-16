package pandaroux.API;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pandaroux.Entity.*;
import pandaroux.Service.Entity.OptionService;
import pandaroux.Service.Entity.QuestionService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/question")
public class QuestionAPI {

    @Autowired
    private QuestionService questionService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void add(@RequestBody int id,
                    @RequestBody QuestionType type,
                    @RequestBody String name,
                    @RequestBody User teacher,
                    @RequestBody boolean has_commentary,
                    @RequestBody String option_text,
                    @RequestBody int rate,
                    @RequestBody boolean mandatory) {
        if(id==0)
            questionService.create(type, name, teacher, has_commentary, option_text, rate, mandatory);
        else
            questionService.alter(id, type, name, teacher, has_commentary, option_text, rate, mandatory);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Map> getQuestions() {
        return questionService.getQuestions();
    }

    @RequestMapping(value = "/teacher/{id}", method = RequestMethod.GET)
    public List<Map> getTeacherQuestions(@PathVariable("id") int id) {
        return questionService.getTeacherQuestions(id);
    }
}
