package pandaroux.API;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pandaroux.Entity.Groupe;
import pandaroux.Service.Entity.GroupeService;

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

    @RequestMapping(value = "/{id}/add/students", method = RequestMethod.POST)
    public Map addStudentsFromGroupe(@PathVariable("id") int id_groupe,
                                     @RequestBody Map map) {
        return groupeService.addStudentsToGroupe(id_groupe, (List<Integer>) map.get("id_students"));
    }

    @RequestMapping(value = "/{id}/remove/students", method = RequestMethod.POST)
    public Map removeStudentsFromGroupe(@PathVariable("id") int id_groupe,
                                        @RequestBody Map map) {
        return groupeService.removeStudentsFromGroupe(id_groupe, (List<Integer>) map.get("id_students"));
    }

    @RequestMapping(value = "{id}/modify", method = RequestMethod.POST)
    private Map modifyGroupe(@PathVariable("id") int id_groupe,
                           @RequestBody Map groupe) {
        return groupeService.modifyGroupe(id_groupe, groupe);
    }
}
