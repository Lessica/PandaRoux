package pandaroux.Repository;

import org.springframework.data.repository.query.Param;
import pandaroux.Entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    List<User> findAll();

    User findById(int id);

    void deleteById(Integer id);

    boolean exists(int id);
}
