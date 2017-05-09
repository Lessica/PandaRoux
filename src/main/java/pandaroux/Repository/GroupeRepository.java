package pandaroux.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pandaroux.Entity.Groupe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pandaroux.Entity.Question;

import java.util.List;

@Repository
public interface GroupeRepository  extends CrudRepository<Groupe, Integer> {

    List<Groupe> findAll();

    @Query("SELECT g FROM Groupe g WHERE g.teacher.id = :id")
    List<Groupe> findAllTeatcherGroupes(@Param("id") int id);
}
