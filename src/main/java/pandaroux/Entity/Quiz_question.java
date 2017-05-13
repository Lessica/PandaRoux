package pandaroux.Entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Quiz_question")
public class Quiz_question {

    @Id
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_question", insertable = false, updatable = false)
    private Question question;

    @ManyToOne
    @JoinColumn(name = "id_quiz", insertable = false, updatable = false)
    private Quiz quiz;

    @OneToMany(mappedBy = "quiz_question")
    private List<Answer> answers;
}
