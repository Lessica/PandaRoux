package pandaroux.API;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pandaroux.Service.StatisticService;

import java.util.Map;

@RestController
@RequestMapping("api/statistic")
public class StatisticAPI {

    @Autowired
    private StatisticService statisticService;


    @RequestMapping(value = "/quiz/{id_quiz}", method = RequestMethod.POST)
    public Map quiz(@PathVariable("id_quiz") int id_quiz) {
        return statisticService.getQuizStatistic(id_quiz);
    }
}
