package pandaroux.Repository;

import org.springframework.data.jpa.repository.Query;
import pandaroux.Entity.Option;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


@Repository
public interface OptionRepository extends CrudRepository<Option, Integer> {


}
