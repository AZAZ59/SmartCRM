import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * Created by azaz on 09.03.15.
 */
@Entity
public class Parent {
    @Id
    private int id;
    private String name;
    @OneToOne
    private Child ch1;
    @OneToOne
    private Child ch2;

    public Parent(int id, String name, String name1, String name2) {
        this.id = id;
        this.name = name;
    }

    public Parent() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Child getCh2() {
        return ch2;
    }

    public void setCh2(Child ch2) {
        this.ch2 = ch2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Child getCh1() {
        return ch1;
    }

    public void setCh1(Child ch1) {
        this.ch1 = ch1;
    }

    public void setCh1Name(String ch1) {
        this.ch1.name = ch1;
    }
}
