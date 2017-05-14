package pandaroux.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pandaroux.Entity.Quiz;

import java.util.List;
import java.util.Map;

@Repository
public interface QuizRepository extends CrudRepository<Quiz, Integer> {

    @Query("SELECT q.id AS id, q.name AS name, q.active AS active, q.date_start AS date_start, q.date_end AS date_end, q.teacher.id AS id_teacher, q.groupe.id AS id_groupe FROM Quiz q")
    List<Map> findAllQuizzes();

    @Query("SELECT q.id AS id, q.name AS name, q.active AS active, q.date_start AS date_start, q.date_end AS date_end, q.teacher.id AS id_teacher, q.groupe.id AS id_groupe FROM Quiz q WHERE q.id = ?1")
    Map getQuiz(int id);

    /*
    @Query("SELECT q.id AS id, q.name AS name, q.active AS active, q.date_start AS date_start, q.date_end AS date_end FROM Quiz q WHERE ")
    List<Map> findAllStudentQuizzes(int userId);

    @Query("SELECT q.id AS id, q.name AS name, q.active AS active, q.date_start AS date_start, q.date_end AS date_end FROM User u JOIN u.quiz")
    List<Map> findAllTeacherQuizzes(int userId);
    */
}
