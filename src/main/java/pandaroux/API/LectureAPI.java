package pandaroux.API;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pandaroux.Entity.Lecture;
import pandaroux.Service.Entity.LectureService;

import java.util.Map;


@RestController
@RequestMapping("api/lecture")
public class LectureAPI {

    @Autowired
    private LectureService lectureService;


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Map add(@RequestBody Lecture lecture) {
        return lectureService.save(lecture);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public void delete(@PathVariable("id") int id) {
        lectureService.deleteById(id);
    }
}
