package pandaroux.Service.Entity;

import pandaroux.Entity.Groupe;
import pandaroux.Entity.Lecture;
import pandaroux.Entity.User;
import pandaroux.Repository.GroupeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pandaroux.Repository.LectureRepository;
import pandaroux.Repository.UserRepository;

import java.util.*;

@Service
public class GroupeService {

    @Autowired
    private GroupeRepository groupeRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LectureRepository lectureRepository;


    public Map getGroupes(int userId) {

        Map groupesData = new HashMap();

        groupesData.put("result", "succeed");
        groupesData.put("groupes", groupeRepository.getGroupes(userId));

        return groupesData;
    }

    public Map getGroup(int groupeId) {

        Map groupeData = new HashMap();
        groupeData.put("result", "succeed");

        Groupe groupe = groupeRepository.findOne(groupeId);
        groupeData.put("id", groupeId);
        groupeData.put("name", groupe.getName());

        Map groupeDetails = new HashMap();
        groupeDetails.put("students", groupeRepository.getGroupStudents(groupeId));
        groupeDetails.put("lectures", groupeRepository.getGroupLectures(groupeId));
        groupeData.put("groupeDetails", groupeDetails);

        return groupeData;
    }

    public Map save(Groupe groupe, int userId) {
        groupe.setTeacher(userRepository.findOne(userId));
        groupeRepository.save(groupe);

        Map data = new HashMap();
        data.put("result", "succeed");

        return data;
    }

    public Map addStudentsToGroupe(int id_groupe, List<Integer> id_students) {

        Groupe groupe = groupeRepository.findOne(id_groupe);

        for (int id_student : id_students) {
            User student = userRepository.findOne(id_student);

            if (!student.getStudentGroupes().contains(groupe)) {
                student.getStudentGroupes().add(groupe);
            }

            userRepository.save(student);
        }

        Map data = new HashMap();
        data.put("result", "succeed");

        return data;
    }

    public Map removeStudentsFromGroupe(int id_groupe, List<Integer> id_students) {

        Groupe groupe = groupeRepository.findOne(id_groupe);

        for (int id_student : id_students) {
            User student = userRepository.findOne(id_student);

            if (student.getStudentGroupes().contains(groupe)) {
                student.getStudentGroupes().remove(groupe);
            }

            userRepository.save(student);
        }

        Map data = new HashMap();
        data.put("result", "succeed");

        return data;
    }

    public Map modifyGroupe(int id_groupe, Map groupe) {

        Groupe groupeDB = groupeRepository.findOne(id_groupe);

        if (groupe.containsKey("name")) {
            groupeDB.setName((String) groupe.get("name"));
        }

        groupeRepository.save(groupeDB);


        Map data = new HashMap();
        data.put("result", "succeed");

        return data;
    }
}
