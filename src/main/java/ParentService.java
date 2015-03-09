import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by azaz on 09.03.15.
 */
public class ParentService {

    private EntityManager em;

    public ParentService(EntityManager em) {
        this.em = em;
    }

    public Parent createParent(int id, String name, String name1, String name2) {
        Parent parent = new Parent(id, name, name1, name2);
        em.persist(parent);
        return parent;
    }

    public void removeParent(int id) {
        Parent parent = em.find(Parent.class, id);

        if (parent != null) {
            em.remove(parent);
        }
    }

    public Parent changeChild1Name(int id, String name) {
        Parent parent = em.find(Parent.class, id);

        if (parent != null) {
            parent.setCh1Name(name);
        }

        return parent;
    }

    public Parent findParent(int id) {
        return em.find(Parent.class, id);
    }

    public List<Parent> findAllParents() {
        TypedQuery<Parent> query = em.createQuery("SELECT a FROM Parent a", Parent.class);
        return query.getResultList();
    }
}
