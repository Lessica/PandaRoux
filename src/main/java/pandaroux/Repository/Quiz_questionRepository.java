package pandaroux.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pandaroux.Entity.Quiz_question;

@Repository
public interface Quiz_questionRepository extends CrudRepository<Quiz_question, Integer> {

    @Query("SELECT q FROM Quiz_question q WHERE q.quiz.id = ?1 AND q.question.id = ?2")
    Quiz_question findOneQuiz_question(int id_quiz, int id_question);
}
