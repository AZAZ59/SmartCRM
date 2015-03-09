import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by azaz on 09.03.15.
 */
@Entity
public class Child {
    String name;
    @Id
    private int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
