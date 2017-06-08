package pandaroux.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pandaroux.Service.SecurityService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class DefaultController {

    @RequestMapping(value = "/login")
    public String login(HttpServletRequest request) throws Exception {
        return SecurityService.loginFireWall("login", request);
    }

    @RequestMapping(value = "/")
    public String index(HttpServletRequest request) {
        return SecurityService.fireWall("index", request);
    }

    @RequestMapping(value = "/teacher")
    public String teacher(HttpServletRequest request) throws Exception {
        return SecurityService.fireWall("redirect:/teacher/index", request, new String[] {"prof"});
    }

    @RequestMapping(value = "/teacher/index")
    public String teacherIndex(HttpServletRequest request) throws Exception {
        return SecurityService.fireWall("redirect:/teacher/group", request, new String[] {"prof"});
    }

    @RequestMapping(value = "/teacher/group")
    public String teacherGroup(HttpServletRequest request) throws Exception {
        return SecurityService.fireWall("teacher/group", request, new String[] {"prof"});
    }

    @RequestMapping(value = "/teacher/question")
    public String teacherQuestion(HttpServletRequest request) throws Exception {
        return SecurityService.fireWall("teacher/question", request, new String[] {"prof"});
    }

    @RequestMapping(value = "/teacher/questionnaire")
    public String teacherQuestionnaire(HttpServletRequest request) throws Exception {
        return SecurityService.fireWall("teacher/questionnaire", request, new String[] {"prof"});
    }

    @RequestMapping(value = "/teacher/statistics")
    public String teacherStatistics(HttpServletRequest request) throws Exception {
        return SecurityService.fireWall("teacher/statistics", request, new String[] {"prof"});
    }

    @RequestMapping(value = "/student")
    public String student(HttpServletRequest request) throws Exception {
        return SecurityService.fireWall("redirect:/student/index", request, new String[] {"eleve"});
    }

    @RequestMapping(value = "/student/index")
    public String studentIndex(HttpServletRequest request) throws Exception {
        return SecurityService.fireWall("redirect:/student/course", request, new String[] {"eleve"});
    }

    @RequestMapping(value = "/student/course")
    public String studentCourse(HttpServletRequest request) throws Exception {
        return SecurityService.fireWall("student/course", request, new String[] {"eleve"});
    }

    @RequestMapping(value = "/student/question")
    public String studentQuestion(HttpServletRequest request) throws Exception {
        return SecurityService.fireWall("student/question", request, new String[] {"eleve"});
    }
}