package pandaroux.API;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pandaroux.Entity.Lecture;
import pandaroux.Service.LectureService;

import java.util.Map;

@RestController
@RequestMapping("api/groupe")
public class LectureAPI {

    @Autowired
    private LectureService lectureService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void add(@RequestBody Lecture lecture) {
        lectureService.save(lecture);
    }
}
