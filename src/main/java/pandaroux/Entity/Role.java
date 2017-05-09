package pandaroux.Entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Role
{
    @Id
    @GeneratedValue
    @Column
    private int id;

    @Column
    private String name;

    @OneToMany(mappedBy = "role")
    private List<User> users;


    public Role() {}


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
