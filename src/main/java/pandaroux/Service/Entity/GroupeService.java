package pandaroux.Service.Entity;

import pandaroux.Entity.Groupe;
import pandaroux.Entity.Lecture;
import pandaroux.Entity.User;
import pandaroux.Repository.GroupeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pandaroux.Repository.LectureRepository;
import pandaroux.Repository.UserRepository;

import java.text.SimpleDateFormat;
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

    public Map add(Groupe groupe, int userId) {
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

    public Map getStudentGroupes(int userId) {

        Map groupesData = new HashMap();

        groupesData.put("result", "succeed");
        groupesData.put("groupes", groupeRepository.getStudentGroups(userId));

        return groupesData;
    }

    public Map getGroupQuizzes(int id_groupe) {

        Groupe groupeDB = groupeRepository.findOne(id_groupe);
        
        Map data = new HashMap();
        data.put("result", "succeed");
        data.put("id_groupe", groupeDB.getId());

        List<Map> groupQuizzes = groupeRepository.getGroupQuizzes(id_groupe);
        data.put("quizzes_active", new ArrayList<Map>());
        data.put("quizzes_inactive", new ArrayList<Map>());
        data.put("quizzes_finished", new ArrayList<Map>());
        data.put("quizzes_coming", new ArrayList<Map>());


        Date now = new Date();

        System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(now));

        for (Map groupQuiz : groupQuizzes) {

            Date date_start = (Date) groupQuiz.get("date_start");
            Date date_end = (Date) groupQuiz.get("date_end");
            boolean active = (boolean) groupQuiz.get("active");

            if (!active) {
                ((List) data.get("quizzes_inactive")).add(groupQuiz);
            }
            else if (now.after(date_start) && now.before(date_end)){
                ((List) data.get("quizzes_active")).add(groupQuiz);
            }
            else if (now.after(date_end)) {
                ((List) data.get("quizzes_finished")).add(groupQuiz);
            }
            else {
                ((List) data.get("quizzes_coming")).add(groupQuiz);
            }

        }
        return data;
    }

}
