package pandaroux.Repository;

import org.springframework.data.jpa.repository.Query;
import pandaroux.Entity.Groupe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface GroupeRepository extends CrudRepository<Groupe, Integer> {

    @Query("SELECT g.id AS id, g.name AS name FROM Groupe g WHERE g.teacher.id = ?1")
    List<Map> getGroupes(int teacherId);

    @Query("SELECT s.id AS id, s.name AS name, s.first_name AS first_name FROM Groupe g JOIN g.students s WHERE g.id = ?1")
    List<Map> getGroupStudents(int groupeId);

    @Query("SELECT l.id AS id, l.name AS name, l.date AS date, l.rate AS rate, l.commentary AS commentary FROM Groupe g JOIN g.lectures l WHERE g.id = ?1")
    List<Map> getGroupLectures(int groupeId);

    @Query("SELECT g.id AS id, g.name AS name, (SELECT COUNT(*) FROM g.lectures) AS lecture_count, (SELECT COUNT(*) FROM g.quizzes) AS quiz_count FROM Groupe g JOIN g.students s WHERE s.id = ?1")
    List<Map> getStudentGroups(int studentId);

    @Query("SELECT q.id AS id, q.name AS name, q.active AS active, q.date_start AS date_start, q.date_end AS date_end, q.teacher.id AS id_teacher, q.groupe.id AS id_groupe, q.groupe.name AS groupe_name FROM Groupe g JOIN g.quizzes q WHERE g.id = ?1")
    List<Map> getGroupQuizzes(int groupeId);

}
