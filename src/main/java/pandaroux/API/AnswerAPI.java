package pandaroux.API;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pandaroux.Entity.Answer;
import pandaroux.Service.Entity.AnswerService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/answer")
public class AnswerAPI {

    @Autowired
    private AnswerService answerService;

    private Answer getAll() {
        return null;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Map getAnswer(@PathVariable("id") int id) {
        return answerService.getAnswer(id);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void add(@RequestBody Answer answer) {
        answerService.save(answer);
    }

}
