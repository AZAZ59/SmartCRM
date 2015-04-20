package test_test;

import javax.persistence.*;

/**
 * Created by Grand on 31.03.2015.
 */
@Entity(name = "user")
@Table(name = "User")
public class User {

    @Column
    String name;
    @Column
    String password;
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "Groups_id", nullable = false)
    private Group group;

    //@OneToOne(optional = false)
    //@JoinColumn(name = "UserRights_id", unique = true, nullable = false, updatable = false)
    @OneToOne
    private UserRights rights;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    public UserRights getRights() {
        return rights;
    }

    public void setRights(UserRights rights) {
        this.rights = rights;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Integer getId() {
        return this.id;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = MD5(password);
    }

    public String MD5(String md5) {
        try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
            byte[] array = md.digest(md5.getBytes());
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < array.length; ++i) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3));
            }
            return sb.toString();
        } catch (java.security.NoSuchAlgorithmException e) {
        }
        return null;
    }
}
