package pandaroux.API;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pandaroux.Service.Entity.QuestionService;
import pandaroux.Service.SecurityService;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("api/question")
public class QuestionAPI {

    @Autowired
    private QuestionService questionService;


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Map add(@RequestBody Map question,
                   HttpServletRequest request) throws Exception {
        return questionService.add(question, SecurityService.getUserId(request));
    }

    @RequestMapping(method = RequestMethod.POST)
    public Map getQuestions() {
        return questionService.getQuestions();
    }

    @RequestMapping(value = "/teacher", method = RequestMethod.POST)
    public Map getTeacherQuestions(HttpServletRequest request) throws Exception {
        return questionService.getTeacherQuestions(SecurityService.getUserId(request));
    }
}
