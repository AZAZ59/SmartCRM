package test_test;

import javax.persistence.*;

/**
 * Created by Grand on 31.03.2015.
 */
@Entity(name = "userRights")
@Table(name = "UserRights")
public class UserRights {
    @Column
    Integer rights; //0 - обычный юзер, 1 - админ
    //@OneToOne(optional = false,mappedBy = "userRights")
    @OneToOne
    private User user;
    @Id
    private Integer id;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRights() {
        return rights;
    }

    public void setRights(Integer rights) {
        this.rights = rights;
    }
}
