package pandaroux.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pandaroux.Repository.AnswerRepository;
import pandaroux.Repository.QuizRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StatisticService {

    @Autowired
    private QuizRepository quizRepository;

    @Autowired
    private AnswerRepository answerRepository;


    public Map getQuizStatistic(int id_quiz) {

        List<Map> quizStatistic = answerRepository.getAnswerStatistic(id_quiz);

        Map data = new HashMap();
        data.put("result", "succeed");
        data.put("quiz_statistic", quizStatistic);

        return data;
    }
}
