package pandaroux.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pandaroux.Service.SecurityService;

import javax.servlet.http.HttpServletRequest;

@Controller
public class DefaultController {

    @RequestMapping(value = "/login")
    public String login(HttpServletRequest request) throws Exception {
        return SecurityService.loginFireWall("login", request);
    }

    @RequestMapping(value = "/logout")
    public String logOut(HttpServletRequest request) {
        return SecurityService.logout("login", request);
    }

    @RequestMapping(value = "/")
    public String index(HttpServletRequest request) {
        return "index";
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
        return SecurityService.fireWall("redirect:/student/group", request, new String[] {"eleve"});
    }

    @RequestMapping(value = "/student/group")
    public String studentGroup(HttpServletRequest request) throws Exception {
        return SecurityService.fireWall("student/group", request, new String[] {"eleve"});
    }

    @RequestMapping(value = "/student/group/{id}", method = RequestMethod.POST)
    public String studentGroupDetail(@PathVariable("id") int id, HttpServletRequest request) throws Exception {
        return SecurityService.fireWall("student/group-detail", request, new String[] {"eleve"});
    }
}