package pandaroux.Entity;

import javax.persistence.*;

@Entity
@Table(name = "Quiz_question_answer")
public class Quiz_question_answer {

    @Id
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_question", insertable = false, updatable = false)
    private Question question;

    @ManyToOne
    @JoinColumn(name = "id_quiz", insertable = false, updatable = false)
    private Quiz quiz;

    @ManyToOne
    @JoinColumn(name = "id_answer", insertable = false, updatable = false)
    private Answer answer;
}
