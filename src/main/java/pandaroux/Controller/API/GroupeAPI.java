package pandaroux.Controller.API;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pandaroux.Entity.Groupe;
import pandaroux.Service.GroupeService;

import java.util.List;

@RestController
@RequestMapping("api/groupe")
public class GroupeAPI {

    @Autowired
    private GroupeService groupeService;


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public List<Groupe> findAllTeatcherGroupes(@PathVariable("id") int id) {
        return groupeService.findAllTeatcherGroupes(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void addGroupe(@RequestBody Groupe groupe) {
        groupeService.save(groupe);
    }
}
