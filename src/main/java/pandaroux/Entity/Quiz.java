package pandaroux.Entity;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table
public class Quiz {

    @Id
    @GeneratedValue
    @Column
    private int id;

    @Column
    private String name;

    @Column
    @Type(type = "date")
    private Date date_start;

    @Column
    @Type(type = "date")
    private Date date_end;

    @Column
    @Type(type = "boolean")
    private boolean active;

    @ManyToOne
    @JoinColumn(name = "id_teacher")
    private User teacher;

    @OneToMany(mappedBy = "quiz")
    private List<Quiz_question> quiz_question;

    @ManyToOne
    @JoinColumn(name = "id_groupe")
    private Groupe groupe;


    public Quiz() {}


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

    public Date getDate_start() {
        return date_start;
    }

    public void setDate_start(Date date_start) {
        this.date_start = date_start;
    }

    public Date getDate_end() {
        return date_end;
    }

    public void setDate_end(Date date_end) {
        this.date_end = date_end;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public User getTeacher() {
        return teacher;
    }

    public void setTeacher(User teacher) {
        this.teacher = teacher;
    }

    public List<Quiz_question> getQuiz_question() {
        return quiz_question;
    }

    public void setQuiz_question(List<Quiz_question> quiz_question) {
        this.quiz_question = quiz_question;
    }

    public Groupe getGroupe() {
        return groupe;
    }

    public void setGroupe(Groupe groupe) {
        this.groupe = groupe;
    }
}
