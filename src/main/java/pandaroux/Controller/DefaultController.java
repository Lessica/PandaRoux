package pandaroux.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import pandaroux.Service.SecurityService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;


@Controller
public class DefaultController {

    @RequestMapping(value = "/login")
    public String login(HttpServletRequest request) throws Exception {
        return SecurityService.loginFireWall("login", request);
    }

    @RequestMapping(value = "/logOut")
    public String logOut(HttpServletRequest request) {

        HttpSession session = request.getSession();
        session.removeAttribute("user");

        return "redirect:/login";
    }

    @RequestMapping(value = "/")
    public String index(HttpServletRequest request) {
        return SecurityService.fireWall("index", request);
    }

    @RequestMapping(value = "/teacher")
    public String teacher(HttpServletRequest request) {
        return SecurityService.fireWall("redirect:/teacher/index", request);
    }

    @RequestMapping(value = "/teacher/index")
    public String teacherIndex(HttpServletRequest request) {
        return SecurityService.fireWall("redirect:/teacher/group", request);
    }

    @RequestMapping(value = "/teacher/group")
    public String teacherGroup(HttpServletRequest request) {
        return SecurityService.fireWall("teacher/group", request);
    }

    @RequestMapping(value = "/teacher/question")
    public String teacherQuestion(HttpServletRequest request) {
        return SecurityService.fireWall("teacher/question", request);
    }

    @RequestMapping(value = "/teacher/questionnaire")
    public String teacherQuestionnaire(HttpServletRequest request) {
        return SecurityService.fireWall("teacher/questionnaire", request);
    }

    @RequestMapping(value = "/student")
    public String student(HttpServletRequest request) {
        return SecurityService.fireWall("redirect:/student/index", request);
    }

    @RequestMapping(value = "/student/index")
    public String studentIndex(HttpServletRequest request) {
        return SecurityService.fireWall("redirect:/student/course", request);
    }

    @RequestMapping(value = "/student/course")
    public String studentCourse(HttpServletRequest request) {
        return SecurityService.fireWall("student/course", request);
    }

    @RequestMapping(value = "/student/question")
    public String studentQuestion(HttpServletRequest request) {
        return SecurityService.fireWall("student/question", request);
    }
}