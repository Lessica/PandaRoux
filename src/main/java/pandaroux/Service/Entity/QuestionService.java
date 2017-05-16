package pandaroux.Service.Entity;

import jdk.nashorn.internal.runtime.options.Options;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pandaroux.Entity.Option;
import pandaroux.Entity.Question;
import pandaroux.Entity.QuestionType;
import pandaroux.Entity.User;
import pandaroux.Repository.OptionRepository;
import pandaroux.Repository.QuestionRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    public Map save(Question question) {
        questionRepository.save(question);

        Map data = new HashMap();
        data.put("result", "succeed");

        return data;
    }

    public List<Map> getQuestions() {
        return questionRepository.getQuestions();
    }

    public List<Map> getTeacherQuestions(int id) {
        return questionRepository.getTeacherQuestions(id);
    }

    public void create(QuestionType type, String name, User teacher, boolean has_commentary, String option_text, int rate, boolean mandatory){
        Question question = new Question();

        question.setName(name);
        question.setQuestionType(type);
        question.setTeacher(teacher);

        save(question);

        OptionService optionService = new OptionService();
        Option option = new Option();
        option.setOption_text(option_text);
        option.setHas_commentary(has_commentary);
        option.setRate(rate);
        option.setQuestion(question);

        optionService.save(option);
    }
    public void alter(int id, QuestionType type, String name, User teacher, boolean has_commentary, String option_text, int rate, boolean mandatory){
        questionRepository.delete(id);
        create(type, name, teacher, has_commentary, option_text, rate, mandatory);
    }
}
