package pandaroux.Repository;

import org.springframework.data.jpa.repository.Query;
import pandaroux.Entity.Question;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


@Repository
public interface QuestionRepository extends CrudRepository<Question, Integer> {

    @Query("SELECT q.id AS id, q.has_commentary AS has_commentary, q.mandatory AS mandatory, q.name AS name, q.questionType.id AS id_question_type, q.teacher.id AS id_teacher,  q.jsonParameters AS parameters FROM Question q")
    List<Map> getQuestions();

    @Query("SELECT q.id AS id, q.has_commentary AS has_commentary, q.mandatory AS mandatory, q.name AS name, q.questionType.id AS id_question_type, q.teacher.id AS id_teacher,  q.jsonParameters AS parameters FROM Question q WHERE q.teacher.id = ?1")
    List<Map> getTeacherQuestions(int id);

    @Query("SELECT q.id AS id, q.has_commentary AS has_commentary, q.mandatory AS mandatory, q.name AS name, q.questionType.id AS id_question_type, q.teacher.id AS id_teacher,  q.jsonParameters AS parameters FROM Question q JOIN q.quiz_question qq WHERE qq.quiz.id = ?1")
    List<Map> getQuizQuestions(int id_quiz);

}
