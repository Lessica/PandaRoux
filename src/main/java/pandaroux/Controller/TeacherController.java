package pandaroux.Controller;

import pandaroux.Service.GroupeService;
import pandaroux.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;

@Controller
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private UserService userService;

    @Autowired
    private GroupeService groupeService;

    @RequestMapping(value = "/classes")
    public String classes(Model model) {
        System.out.println(groupeService.findAllTeatcherGroupes(9604).size());
        model.addAttribute("groupes", groupeService.findAllTeatcherGroupes(9604));
        return "teacher/classes";
    }

    @RequestMapping(value = "/questions")
    public String questions(Model model) {
        // model.addAttribute("users", userService.findAll());
        return "teacher/questions";
    }

    @RequestMapping(value = "/quiz")
    public String quiz(Model model) {
        // model.addAttribute("users", userService.findAll());
        return "teacher/quiz";
    }

    @RequestMapping(value = "/statistics")
    public String statistics(Model model) {
        // model.addAttribute("users", userService.findAll());
        return "teacher/statistics";
    }

    @RequestMapping(value = "/groupe")
    public String groupe(Model model) {
        // model.addAttribute("users", userService.findAll());
        return "teacher/groupe";
    }
}
