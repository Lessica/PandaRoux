package pandaroux.Service;

import pandaroux.Entity.Groupe;
import pandaroux.Repository.GroupeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupeService {

    @Autowired
    private GroupeRepository groupeRepository;


    public List<Groupe> findAllTeatcherGroupes(int id) {
        return groupeRepository.findAllTeatcherGroupes(id);
    }

    public void save(Groupe groupe) {
        groupeRepository.save(groupe);
    }
}
