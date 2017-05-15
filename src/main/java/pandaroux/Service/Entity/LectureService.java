package pandaroux.Service.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pandaroux.Entity.Lecture;
import pandaroux.Repository.LectureRepository;

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

    public void deleteById(int id) {
        lectureRepository.delete(id);
    }
}
