package test_test.services;

import test_test.University;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by azaz on 09.03.15.
 */
public class UniversityService {

    private EntityManager em;

    public UniversityService(EntityManager em) {
        this.em = em;
    }

    public University createParent(int id, String name) {
        University parent = new University(id, name);
        em.persist(parent);
        return parent;
    }

    public void removeParent(int id) {
        University parent = em.find(University.class, id);

        if (parent != null) {
            em.remove(parent);
        }
    }

    public University changeChild1Name(int id, String name) {
        University parent = em.find(University.class, id);

        if (parent != null) {
            //parent.setCh1Name(name);
        }

        return parent;
    }

    public University findParent(int id) {
        return em.find(University.class, id);
    }

    public List<University> findAllParents() {
        TypedQuery<University> query = em.createQuery("SELECT a FROM university a", University.class);
        return query.getResultList();
    }
}
