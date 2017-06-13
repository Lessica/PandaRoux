package pandaroux.Service.Entity;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pandaroux.Entity.Question;
import pandaroux.Entity.QuestionType;
import pandaroux.Entity.User;
import pandaroux.Repository.QuestionRepository;
import pandaroux.Repository.QuestionTypeRepository;
import pandaroux.Repository.UserRepository;
import pandaroux.Service.ParametersService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private QuestionTypeRepository questionTypeRepository;

    @Autowired
    private UserRepository userRepository;


    public Map getQuestions() {
        Map data = new HashMap();

        List<Map> questions = questionRepository.getQuestions();

        questions = ParametersService.parametersObject(questions);

        data.put("question_list", questions);

        return data;
    }

    public Map getTeacherQuestions(int userId) {

        Map data = new HashMap();

        data.put("result", "succeed");
        data.put("teacher_questions", questionRepository.getTeacherQuestions(userId));

        return data;

    }

    public Map add(Map question, int teacherId) {

        Question questionDB;

        if (question.containsKey("id")) {
            int id_question = (int) question.get("id");

            if (questionRepository.exists(id_question)) {
                questionDB = questionRepository.findOne(id_question);

            } else {
                questionDB = new Question();
                questionDB.setId(id_question);
            }
        } else {
            questionDB = new Question();
        }

        User teacher = userRepository.findOne(teacherId);
        questionDB.setTeacher(teacher);

        if (question.containsKey("name")) {
            questionDB.setName((String) question.get("name"));
        }

        if (question.containsKey("has_commentary")) {
            questionDB.setHas_commentary((Boolean) question.get("has_commentary"));
        }

        if (question.containsKey("mandatory")) {
            questionDB.setMandatory((Boolean) question.get("mandatory"));
        }

        if (question.containsKey("id_question_type")) {
            QuestionType questionType = questionTypeRepository.findOne((int) question.get("id_question_type"));
            questionDB.setQuestionType(questionType);
        }

        if (question.containsKey("id_questionType")) {
            QuestionType questionType = questionTypeRepository.findOne((int) question.get("id_questionType"));
            questionDB.setQuestionType(questionType);
        }

        if (question.containsKey("parameters")) {
            String json = new Gson().toJson(question.get("parameters"), Object.class);
            questionDB.setJsonParameters(json);
        }

        questionRepository.save(questionDB);

        Map data = new HashMap();
        data.put("result", "succeed");
        data.put("id", questionDB.getId());

        return data;
    }
}
