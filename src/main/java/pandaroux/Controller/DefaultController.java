package pandaroux.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class DefaultController {

    @RequestMapping(value = "/")
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/login")
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/teacher")
    public String teacher() {
        return "redirect:/teacher/index";
    }

    @RequestMapping(value = "/teacher/index")
    public String teacherIndex() {
        return "redirect:/teacher/group";
    }

    @RequestMapping(value = "/teacher/group")
    public String teacherGroup() {
        return "teacher/group";
    }

    @RequestMapping(value = "/teacher/question")
    public String teacherQuestion() {
        return "teacher/question";
    }

    @RequestMapping(value = "/teacher/questionnaire")
    public String teacherQuestionnaire() {
        return "teacher/questionnaire";
    }

    @RequestMapping(value = "/student")
    public String student() {
        return "redirect:/student/index";
    }

    @RequestMapping(value = "/student/index")
    public String studentIndex() {
        return "redirect:/student/course";
    }

    @RequestMapping(value = "/student/course")
    public String studentCourse() {
        return "student/course";
    }

}