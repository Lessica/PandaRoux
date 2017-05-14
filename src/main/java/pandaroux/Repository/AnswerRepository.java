package pandaroux.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pandaroux.Entity.Answer;

import java.util.List;
import java.util.Map;

@Repository
public interface AnswerRepository extends CrudRepository<Answer, Integer> {

    List<Answer> findAll();

    @Query("SELECT a.id AS id, a.date AS date, a.text AS text, a.student.id AS id_student, a.quiz_question.quiz.id AS id_quiz, a.quiz_question.question.id AS id_question FROM Answer a WHERE a.id = ?1")
    Map getAnswer(int id);

    Answer getOne(int id);
}
