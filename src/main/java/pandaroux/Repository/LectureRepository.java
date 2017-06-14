package pandaroux.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pandaroux.Entity.Lecture;

@Repository
public interface LectureRepository extends CrudRepository<Lecture, Integer> {
}
