package pandaroux.Repository;

import org.springframework.data.jpa.repository.Query;
import pandaroux.Entity.Question;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


@Repository
public interface QuestionRepository extends CrudRepository<Question, Integer> {

    @Query("SELECT q.id AS id, q.has_commentary AS has_commentary, q.name AS name, q.questionType.id AS id_question_type, q.teacher.id AS id_teacher,  q.jsonParameters AS parameters FROM Question q")
    List<Map> getQuestions();

    @Query("SELECT q.id AS id, q.has_commentary AS has_commentary, q.name AS name, qt.id AS id_question_type, qt.name AS question_type_name FROM Question q JOIN q.questionType qt WHERE q.teacher.id = ?1")
    List<Map> getTeacherQuestions(int id);
}
