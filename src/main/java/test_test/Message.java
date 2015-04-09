package test_test;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Grand on 09.04.2015.
 */
@Entity(name = "message")
@Table(name = "Message")
public class Message {
    @Id
    Integer id;
    @Column
    String message;

    @Temporal(TemporalType.DATE)
    @Column(name = "DATE_FIELD")
    private java.util.Date dateField;

    @Temporal(TemporalType.TIME)
    @Column(name = "TIME_FIELD")
    private java.util.Date timeField;


    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "Groups_id", nullable = false)
    private Group group;

    public Date getDateField() {
        return dateField;
    }

    public void setDateField(Date dateField) {
        this.dateField = dateField;
    }

    public Date getTimeField() {
        return timeField;
    }

    public void setTimeField(Date timeField) {
        this.timeField = timeField;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}
