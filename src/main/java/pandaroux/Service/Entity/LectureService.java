package pandaroux.Service.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pandaroux.Entity.Lecture;
import pandaroux.Repository.LectureRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

@Service
public class LectureService {

    @Autowired
    private LectureRepository lectureRepository;


    public Map save(Lecture lecture) {
        lectureRepository.save(lecture);

        Map data = new HashMap();
        data.put("result", "succeed");

        return data;
    }

    public Map deleteById(int id) {
        lectureRepository.delete(id);

        Map data = new HashMap();
        data.put("result", "succeed");

        return data;
    }

    public Map modify(int id_lecture, Map lecture) throws ParseException {

        Lecture lectureDB = lectureRepository.findOne(id_lecture);

        if (lecture.containsKey("name")) {
            lectureDB.setName((String) lecture.get("name"));
        }

        if (lecture.containsKey("date")) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
            lectureDB.setDate(sdf.parse((String) lecture.get("date")));
        }

        if (lecture.containsKey("commentary")) {
            lectureDB.setCommentary((String) lecture.get("commentary"));
        }

        if (lecture.containsKey("rate")) {
            lectureDB.setRate((Integer) lecture.get("rate"));
        }

        lectureRepository.save(lectureDB);

        Map data = new HashMap();
        data.put("result", "succeed");

        return data;
    }
}
