package pandaroux.API;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by yerimju on 2017-05-23.
 */
@RestController()
@RequestMapping("api/course")
public class CourseAPI {

    @RequestMapping(method = RequestMethod.POST)
    public Map getCourses() {
        //return CourseAPI.getCourses();
        return null;
    }

}
