package pandaroux.API;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pandaroux.Entity.Groupe;
import pandaroux.Service.Entity.GroupeService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("api/groupe")
public class GroupeAPI {

    @Autowired
    private GroupeService groupeService;


    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public Map getGroup(@PathVariable("id") int id) {
        return groupeService.getGroup(id);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void add(@RequestBody Groupe groupe) {
        groupeService.save(groupe);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Map getGroupes() {
        return groupeService.getGroupes();
    }
}
