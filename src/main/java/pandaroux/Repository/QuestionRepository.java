package pandaroux.Repository;

import pandaroux.Entity.Question;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository  extends CrudRepository<Question, Integer> {

    @Query("SELECT q FROM Question q WHERE q.teacher.id = 1")
    List<Question> findAllTeatcherQuestions();
}
