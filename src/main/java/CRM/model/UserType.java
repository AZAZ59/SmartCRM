package CRM.model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by azaz on 07.07.15.
 */
@Entity
public enum UserType {
    Baristo,Adminictrator;//info add another user type
    private Integer id;

    @Id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
