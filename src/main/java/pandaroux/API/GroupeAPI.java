package pandaroux.API;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pandaroux.Service.GroupeService;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("api/groupe")
public class GroupeAPI {

    @Autowired
    private GroupeService groupeService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Map> getGroupes() {
        return groupeService.getGroupes();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Map getGroupData(@PathVariable("id") int id) {
        return groupeService.getGroupData(id);
    }
}
