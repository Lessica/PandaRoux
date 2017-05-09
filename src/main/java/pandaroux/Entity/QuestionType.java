package pandaroux.Entity;

import javax.persistence.*;

@Entity
@Table
public class QuestionType {

    @Id
    @GeneratedValue
    @Column
    private int id;

    @Column(unique = true)
    private String name;

    public QuestionType() {}

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
}
