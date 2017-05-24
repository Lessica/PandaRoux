package pandaroux.Service.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pandaroux.Entity.Question;
import pandaroux.Entity.QuestionType;
import pandaroux.Entity.User;
import pandaroux.Repository.QuestionRepository;
import pandaroux.Repository.QuestionTypeRepository;
import pandaroux.Repository.UserRepository;

import java.util.HashMap;
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
        Map questions = new HashMap();
        questions.put("question_list", questionRepository.getQuestions());
        return questions;
    }

    public Map getTeacherQuestions() {

        Map data = new HashMap();

        data.put("result", "succeed");
        data.put("teacher_questions", questionRepository.getTeacherQuestions(1));

        return data;

    }

    public Map add(Map question) {

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

        if (question.containsKey("name")) {
            questionDB.setName((String) question.get("name"));
        }

        if (question.containsKey("has_commentary")) {
            questionDB.setHas_commentary((Boolean) question.get("has_commentary"));
        }

        if (question.containsKey("id_question_type")) {
            QuestionType questionType = questionTypeRepository.findOne((int) question.get("id_question_type"));
            questionDB.setQuestionType(questionType);
        }

        if (question.containsKey("id_teacher")) {
            User teacher = userRepository.findOne((int) question.get("id_teacher"));
            questionDB.setTeacher(teacher);
        }

        if (question.containsKey("id_questionType")) {
            QuestionType questionType = questionTypeRepository.findOne((int) question.get("id_questionType"));
            questionDB.setQuestionType(questionType);
        }

        questionRepository.save(questionDB);

        Map data = new HashMap();
        data.put("result", "succeed");
        data.put("id", questionDB.getId());

        return data;
    }
}
