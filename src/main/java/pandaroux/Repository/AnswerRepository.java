package pandaroux.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pandaroux.Entity.Answer;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Repository
public interface AnswerRepository extends CrudRepository<Answer, Integer> {

    @Query("SELECT a.id AS id, a.date AS date, a.jsonParameters AS parameters, a.text AS text, a.student.id AS id_student, a.quiz_question.id AS id_quiz_question FROM Answer a")
    List<Map> getAnswers();

    @Query("SELECT a.id AS id, a.jsonParameters AS parameters, a.text AS text, a.student.id AS id_student, a.quiz_question.question.id AS id_question FROM Answer a WHERE a.quiz_question.quiz.id = ?1")
    List<Map> getAnswerStatistic(int id_quiz);

    @Query("SELECT a.id AS id, a.jsonParameters AS parameters, a.text AS text, a.student.id AS id_student, a.quiz_question.question.id AS id_question FROM Answer a WHERE a.student.id = ?1 AND a.quiz_question.quiz.id = ?2")
    List<Map> getAnswerUserStatistic(int id_user, int id_quiz);

}