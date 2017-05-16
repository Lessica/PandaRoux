package pandaroux.API;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pandaroux.Entity.Lecture;
import pandaroux.Service.Entity.LectureService;

import java.text.ParseException;
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

    @RequestMapping(value = "/{id}/delete", method = RequestMethod.POST)
    public Map delete(@PathVariable("id") int id) {
        return lectureService.deleteById(id);
    }

    @RequestMapping(value = "/{id}/modify", method = RequestMethod.POST)
    public Map modify(@PathVariable("id") int id_lecture, @RequestBody Map lecture) throws ParseException {
        return lectureService.modify(id_lecture, lecture);
    }
}
