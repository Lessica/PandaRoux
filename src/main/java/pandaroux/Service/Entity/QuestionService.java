package pandaroux.Service.Entity;

import jdk.nashorn.internal.runtime.options.Options;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pandaroux.Entity.Option;
import pandaroux.Entity.Question;
import pandaroux.Repository.OptionRepository;
import pandaroux.Repository.QuestionRepository;

import java.util.List;
import java.util.Map;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    public void save(Question question, List<Option> options) {
        questionRepository.save(question);

    }

    public List<Map> getQuestions() {
        return questionRepository.getQuestions();
    }

    public void handleOptions(List<Options> options){
         OptionRepository optionRepository;

    }
}
