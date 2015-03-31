import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Grand on 31.03.2015.
 */
@Entity
public class UserRights {
    @Id
    private Integer id;
    @Column
    Integer rights; //0 - обычный юзер, 1 - админ
    

}
