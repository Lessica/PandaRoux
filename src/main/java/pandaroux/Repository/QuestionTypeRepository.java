package pandaroux.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pandaroux.Entity.QuestionType;

@Repository
public interface QuestionTypeRepository extends CrudRepository<QuestionType, Integer> {
}
