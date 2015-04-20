package test_test;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by azaz on 09.03.15.
 */
@Entity(name = "university")
@Table(name = "University")
public class University {
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "university")
    private Set<Group> groups;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column
    private String name;

    public University(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public University() {
    }

    public Set<Group> getGroups() {
        return groups;
    }

    public void setGroups(Set<Group> groups) {
        this.groups = groups;
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


}
