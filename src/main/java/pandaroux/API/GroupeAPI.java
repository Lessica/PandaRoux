package pandaroux.API;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pandaroux.Service.GroupeService;

import java.util.List;


@RestController
@RequestMapping("api/groupe")
public class GroupeAPI {

    @Autowired
    private GroupeService groupeService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Object> getGroupes() {
        return groupeService.getGroupes();
    }
}
