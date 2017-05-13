package pandaroux.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pandaroux.Entity.User;

import java.util.List;
import java.util.Map;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    @Query("SELECT u.id AS id, u.name AS name, u.first_name AS first_name, u.role AS role FROM User u")
    List<Map> findAllUser();

    boolean exists(int id);

    User findOne(int id);

    List<User> findAll();

    @Query("SELECT u.id AS id, u.name AS name, u.first_name AS first_name, u.role AS role FROM User u WHERE u.id = ?1")
    Map findOneById(int id);
}
