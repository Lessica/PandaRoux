package pandaroux.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pandaroux.Entity.Quiz;

@Repository
public interface QuizRepository extends CrudRepository<Quiz, Integer> {
}
