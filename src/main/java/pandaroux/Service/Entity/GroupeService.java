package pandaroux.Service.Entity;

import pandaroux.Entity.Groupe;
import pandaroux.Repository.GroupeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class GroupeService {

    @Autowired
    private GroupeRepository groupeRepository;


    public List<Map> getGroupes() {
        return groupeRepository.getGroupes(1);
    }

    public Map getGroup(int groupeId) {

        Map groupeData = new HashMap<>();

        groupeData.put("students", groupeRepository.getGroupSudents(groupeId));
        groupeData.put("lectures", groupeRepository.getGroupLectures(groupeId));

        return groupeData;
    }

    public void save(Groupe groupe) {
        groupeRepository.save(groupe);
    }
}
