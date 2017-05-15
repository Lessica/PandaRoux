package pandaroux.Service.Entity;

import pandaroux.Entity.Groupe;
import pandaroux.Entity.User;
import pandaroux.Repository.GroupeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pandaroux.Repository.UserRepository;

import java.util.*;

@Service
public class GroupeService {

    @Autowired
    private GroupeRepository groupeRepository;

    @Autowired
    private UserRepository userRepository;


    public Map getGroupes() {

        Map groupesData = new HashMap();

        groupesData.put("result", "succeed");
        groupesData.put("groupes", groupeRepository.getGroupes(1));

        return groupesData;
    }

    public Map getGroup(int groupeId) {

        Map groupeData = new HashMap();
        Map groupeDetails = new HashMap();

        groupeDetails.put("students", groupeRepository.getGroupSudents(groupeId));
        groupeDetails.put("lectures", groupeRepository.getGroupLectures(groupeId));
        groupeDetails.put("id", groupeId);

        groupeData.put("result", "succeed");
        groupeData.put("groupeDetails", groupeDetails);

        return groupeData;
    }

    public Map save(Groupe groupe) {
        groupe.setTeacher(userRepository.findOne(1));
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
}
