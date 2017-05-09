package pandaroux.Controller;

import pandaroux.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/classes")
    public String classes(Model model) {
        // model.addAttribute("users", studentService.findAll());
        return "student/classes";
    }

    @RequestMapping(value = "/lectures")
    public String lectures(Model model) {
        // model.addAttribute("users", studentService.findAll());
        return "student/lectures";
    }
}
