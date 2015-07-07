package CRM.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Set;


/**
 * Created by Grand on 31.03.2015.
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Entity(name = "stock")
@Table(name = "Stock")
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    @OneToMany
    @Column
    Set<CofeeEntry> current;

    @Column
    String name;


    public Set<CofeeEntry> getCurrent() {
        return current;
    }

    public void setCurrent(Set<CofeeEntry> current) {
        this.current = current;
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

    public Stock(String name) {
        this.name = name;
    }

    public Stock() throws Exception {;}
}