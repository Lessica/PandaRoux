package pandaroux.API;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pandaroux.Entity.Groupe;
import pandaroux.Entity.User;
import pandaroux.Service.Entity.GroupeService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController()
@RequestMapping("api/groupe")
public class GroupeAPI {

    @Autowired
    private GroupeService groupeService;


    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public Map getGroup(@PathVariable("id") int id) {
        return groupeService.getGroup(id);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Map add(@RequestBody Groupe groupe) {
        return groupeService.save(groupe);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Map getGroupes() {
        return groupeService.getGroupes();
    }

    @RequestMapping(value = "/{id}/students", method = RequestMethod.POST)
    public Map addStudentsToGroupe(@PathVariable("id") int id_groupe,
                                   @RequestBody List<User> students) {
        return groupeService.addStudentsToGroupe(id_groupe, students);
    }
}
