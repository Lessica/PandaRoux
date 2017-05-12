package pandaroux.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pandaroux.Entity.Quiz_question_answer;

@Repository
public interface Quiz_question_answerRepository extends CrudRepository<Quiz_question_answer, Integer> {
}
