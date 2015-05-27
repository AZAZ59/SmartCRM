package test_test;

import javax.persistence.*;
import javax.xml.bind.annotation.*;


/**
 * Created by Grand on 31.03.2015.
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Entity(name = "rasp")
@Table(name = "Rasps")
public class Rasp {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "Groups_id", nullable = false)
    @XmlTransient
    Group group;

    @XmlElement(name = "group_name")
    String gr_name = "";

    @XmlElement(name = "univ_name")
    String un_name = "";

    @Column
    String name_pair;
    @Column
    Boolean odd;
    @Column
    int number_of_pair;
    @Column
    Type type;
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "University_id", nullable = false)
    @XmlTransient
    private University university;

    @Override
    public String toString() {
        return "Rasp{" +
                "id=" + id +
                ", university=" + university +
                ", group=" + group +
                ", name_pair='" + name_pair + '\'' +
                ", odd=" + odd +
                ", number_of_pair=" + number_of_pair +
                ", type=" + type +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.un_name = university.getName();
        this.university = university;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.gr_name = group.nameGroup;
        this.group = group;
    }

    public String getName_pair() {
        return name_pair;
    }

    public void setName_pair(String name_pair) {
        this.name_pair = name_pair;
    }

    public Boolean getOdd() {
        return odd;
    }

    public void setOdd(Boolean odd) {
        this.odd = odd;
    }

    public int getNumber_of_pair() {
        return number_of_pair;
    }

    public void setNumber_of_pair(int number_of_pair) {
        this.number_of_pair = number_of_pair;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
