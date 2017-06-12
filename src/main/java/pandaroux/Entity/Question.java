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

    @Column
    @Type(type = "boolean")
    private boolean mandatory;

    @ManyToOne
    @JoinColumn(name = "id_questionType")
    private QuestionType questionType;

    @OneToMany(mappedBy = "question")
    private List<Quiz_question> quiz_question;

    @ManyToOne
    @JoinColumn(name = "id_teacher")
    private User teacher;

    @Column(columnDefinition="TEXT")
    private String jsonParameters;


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

    public String getJsonParameters() {
        return jsonParameters;
    }

    public void setJsonParameters(String jsonParameters) {
        this.jsonParameters = jsonParameters;
    }

    public boolean isMandatory() {
        return mandatory;
    }

    public void setMandatory(boolean mandatory) {
        this.mandatory = mandatory;
    }
}
