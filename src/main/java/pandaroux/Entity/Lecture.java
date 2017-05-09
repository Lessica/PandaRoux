package pandaroux.Entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Lecture")
public class Lecture {

    @Id
    @GeneratedValue
    @Column
    private int id;

    @Column
    private String name;

    @Column
    private Date date;

    @Column
    private String commentary;

    @Column
    private int rate;

    @ManyToOne
    @JoinColumn(name = "id_groupe")
    private Groupe groupe;


    public Lecture() {}


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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCommentary() {
        return commentary;
    }

    public void setCommentary(String commentary) {
        this.commentary = commentary;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public Groupe getGroupe() {
        return groupe;
    }

    public void setGroupe(Groupe groupe) {
        this.groupe = groupe;
    }
}
