package pandaroux.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pandaroux.Entity.Groupe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pandaroux.Entity.Question;

import java.util.List;
import java.util.Map;

@Repository
public interface GroupeRepository  extends CrudRepository<Groupe, Integer> {

    List<Groupe> findAll();

    @Query("SELECT g.id AS id, g.name AS name FROM Groupe g WHERE g.teacher.id = ?1")
    List<Map> getGroupes(int teacherId);
}
