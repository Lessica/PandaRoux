package pandaroux.Service;

import pandaroux.Repository.GroupeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class GroupeService {

    @Autowired
    private GroupeRepository groupeRepository;


    public List<Map> getGroupes() {
        return groupeRepository.getGroupes(1);
    }
}
