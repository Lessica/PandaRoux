package pandaroux.Entity;

import org.hibernate.annotations.Type;

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
    @JoinColumn(name = "id_quiz_question")
    private Quiz_question quiz_question;

    @ManyToOne
    @JoinColumn(name = "id_student")
    private User student;

    @Column(columnDefinition="TEXT")
    private String text;

    @Column
    @Type(type = "date")
    private Date date;

    @Column(columnDefinition="TEXT")
    private String jsonParameters;


    public Answer() {}


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Quiz_question getQuiz_question() {
        return quiz_question;
    }

    public void setQuiz_question(Quiz_question quiz_question) {
        this.quiz_question = quiz_question;
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

    public String getJsonParameters() {
        return jsonParameters;
    }

    public void setJsonParameters(String jsonParameters) {
        this.jsonParameters = jsonParameters;
    }
}
