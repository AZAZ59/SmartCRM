package CRM.model;/**
 * Created by azaz on 07.07.15.
 */

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Entity(name = "Baristo")
@Table(name = "Baristo")
public class Baristo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    @Column
    String name;//info maybe need id??



    public Baristo(String name) {
        this.name = name;
    }

    public Baristo() throws Exception {
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
