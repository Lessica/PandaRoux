package pandaroux.Entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class User {

    @Id
    @GeneratedValue
    @Column
    private int id;

    @Column
    private int id_isep;

    @Column
    private String name;

    @Column
    private String first_name;

    @ManyToOne
    @JoinColumn(name = "id_role")
    private Role role;

    @ManyToMany
    @JoinTable(
            name = "student_groupe",
            joinColumns = @JoinColumn(name = "id_student", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "id_groupe", referencedColumnName = "id")
    )
    private List<Groupe> studentGroupes;

    @OneToMany(mappedBy = "teacher")
    private List<Groupe> teacherGroupes;

    @OneToMany(mappedBy = "student")
    private List<Answer> answers;

    @OneToMany(mappedBy = "teacher")
    private List<Quiz> teacherQuizzes;

    @OneToMany(mappedBy = "teacher")
    private List<Question> questions;


    public User() {}


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_isep() {
        return id_isep;
    }

    public void setId_isep(int id_isep) {
        this.id_isep = id_isep;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<Groupe> getStudentGroupes() {
        return studentGroupes;
    }

    public void setStudentGroupes(List<Groupe> studentGroupes) {
        this.studentGroupes = studentGroupes;
    }

    public List<Groupe> getTeacherGroupes() {
        return teacherGroupes;
    }

    public void setTeacherGroupes(List<Groupe> teacherGroupes) {
        this.teacherGroupes = teacherGroupes;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public List<Quiz> getTeacherQuizzes() {
        return teacherQuizzes;
    }

    public void setTeacherQuizzes(List<Quiz> teacherQuizzes) {
        this.teacherQuizzes = teacherQuizzes;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
}
