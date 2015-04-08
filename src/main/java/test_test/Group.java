package test_test;

import javax.persistence.*;
import java.util.Set;


/**
 * Created by Grand on 31.03.2015.
 */
@Entity(name = "group")
@Table(name = "Groups")
public class Group {
    @Id
    Integer id;
    @Column
    String nameGroup;
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "University_id", nullable = false)
    private University university;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "group")
    private Set<User> users;

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameGroup() {
        return nameGroup;
    }

    public void setNameGroup(String nameGroup) {
        this.nameGroup = nameGroup;
    }
}
