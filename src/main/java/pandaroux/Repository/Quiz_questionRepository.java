package pandaroux.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pandaroux.Entity.Quiz_question;

@Repository
public interface Quiz_questionRepository extends CrudRepository<Quiz_question, Integer> {
}
