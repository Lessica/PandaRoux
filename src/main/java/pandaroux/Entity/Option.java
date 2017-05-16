package pandaroux.Entity;

import javax.persistence.*;

@Entity
@Table(name = "Options")
public class Option {

    @Id
    @GeneratedValue
    @Column
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_question")
    private Question question;

    @Column
    private String option_text;

    @Column
    private boolean has_commentary;

    @Column
    private int rate;


    public Option() {}


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

    public String getOption_text() {
        return option_text;
    }

    public void setOption_text(String option_text) {
        this.option_text = option_text;
    }

    public boolean isHas_commentary() {
        return has_commentary;
    }

    public void setHas_commentary(boolean has_commentary) {
        this.has_commentary = has_commentary;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }
}
