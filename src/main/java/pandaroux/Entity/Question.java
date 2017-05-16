package pandaroux.Entity;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Question {

    @Id
    @GeneratedValue
    @Column
    private int id;

    @Column
    private String name;

    @Column
    @Type(type = "boolean")
    private boolean has_commentary;

    @ManyToOne
    @JoinColumn(name = "id_questionType")
    private QuestionType questionType;

    @OneToMany(mappedBy = "question")
    private List<Quiz_question> quiz_question;

    @ManyToOne
    @JoinColumn(name = "id_teacher")
    private User teacher;

    @OneToMany(mappedBy = "question")
    private List<Option> options;

    public Question() {}


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isHas_commentary() {
        return has_commentary;
    }

    public void setHas_commentary(boolean has_commentary) {
        this.has_commentary = has_commentary;
    }

    public QuestionType getQuestionType() {
        return questionType;
    }

    public void setQuestionType(QuestionType questionType) {
        this.questionType = questionType;
    }

    public List<Quiz_question> getQuiz_question() {
        return quiz_question;
    }

    public void setQuiz_question(List<Quiz_question> quiz_question) {
        this.quiz_question = quiz_question;
    }

    public User getTeacher() {
        return teacher;
    }

    public void setTeacher(User teacher) {
        this.teacher = teacher;
    }
}
