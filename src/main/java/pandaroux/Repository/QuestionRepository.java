package pandaroux.Repository;

import org.springframework.data.jpa.repository.Query;
import pandaroux.Entity.Question;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


@Repository
public interface QuestionRepository extends CrudRepository<Question, Integer> {

    @Query("SELECT q.id AS id, q.has_commentary AS has_commentary, q.name AS name, q.questionType.id AS id_questionType, q.teacher.id AS teacher_id FROM Question q")
    List<Map> getQuestions();
}
