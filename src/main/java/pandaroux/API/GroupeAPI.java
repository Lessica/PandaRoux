package pandaroux.API;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
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
}
