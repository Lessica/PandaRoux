package pandaroux.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Groupe {

    @Id
    @GeneratedValue
    @Column
    private int id;

    @Column
    private String name;

    @ManyToOne
    @JoinColumn(name = "id_teacher")
    private User teacher;

    @ManyToMany(mappedBy = "studentGroupes")
    private List<User> students;

    @OneToMany(mappedBy = "groupe")
    private List<Lecture> lectures;

    @JsonManagedReference
    @OneToMany(mappedBy = "groupe")
    private List<Quiz> quizzes;


    public Groupe() {}


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

    public User getTeacher() {
        return teacher;
    }

    public void setTeacher(User teacher) {
        this.teacher = teacher;
    }

    public List<User> getStudents() {
        return students;
    }

    public void setStudents(List<User> students) {
        this.students = students;
    }

    public List<Lecture> getLectures() {
        return lectures;
    }

    public void setLectures(List<Lecture> lectures) {
        this.lectures = lectures;
    }

    public List<Quiz> getQuizzes() {
        return quizzes;
    }

    public void setQuizzes(List<Quiz> quizzes) {
        this.quizzes = quizzes;
    }
}
