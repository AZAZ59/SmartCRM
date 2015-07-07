package CRM;

import javax.persistence.EntityManager;

/**
 * Created by azaz on 07.07.15.
 */
public class Variables {
    public EntityManager em;
    private static Variables ourInstance = new Variables();

    public static Variables getInstance() {
        return ourInstance;
    }

    private Variables() {
    }
}
