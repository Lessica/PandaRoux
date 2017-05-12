package pandaroux.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pandaroux.Entity.Answer;

@Repository
public interface AnswerRepository extends CrudRepository<Answer, Integer> {
}
