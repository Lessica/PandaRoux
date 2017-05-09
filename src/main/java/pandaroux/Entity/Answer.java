package pandaroux.Entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table
public class Answer {

    @Id
    @GeneratedValue
    @Column
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_question")
    private Question question;

    @ManyToOne
    @JoinColumn(name = "id_student")
    private User student;

    @Column
    private String text;

    @Column
    private Date date;

    @OneToMany(mappedBy = "answer")
    private List<Quiz_question_answer> quiz_question_answers;


    public Answer() {}


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public User getStudent() {
        return student;
    }

    public void setStudent(User student) {
        this.student = student;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Quiz_question_answer> getQuiz_question_answers() {
        return quiz_question_answers;
    }

    public void setQuiz_question_answers(List<Quiz_question_answer> quiz_question_answers) {
        this.quiz_question_answers = quiz_question_answers;
    }
}
