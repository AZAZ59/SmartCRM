package CRM.model;/**
 * Created by azaz on 07.07.15.
 */

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Entity(name = "sellPoint")
@Table(name = "SellPoint")
public class SellPoint {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    @Column
    String name;

    @Column
    @OneToMany
    List<CofeeEntry> balance;

    @Column
    @OneToOne
    Baristo seller;


    public SellPoint(String name) {
        this.name = name;
    }

    public SellPoint() throws Exception {
        ;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
