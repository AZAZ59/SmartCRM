import javax.persistence.*;
import java.util.Set;

/**
 * Created by azaz on 09.03.15.
 */
@Entity
public class University {
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "university")
    private Set<Group> groups;
    @Id
    private int id;
    @Column
    private String name;

    public University(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public University() {
    }

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

    public Set<Group> getGroups() {
        return groups;
    }

    public void setGroups(Set<Group> groups) {
        this.groups = groups;
    }
}
