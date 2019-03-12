package qecSystem;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Rusty
 */
public class CourseManager {
    EntityManagerFactory emf;
    EntityManager em;
    Courses c;
    
    
    //used for inserts
    public CourseManager() {
        emf = Persistence.createEntityManagerFactory("QECPU");
        em = emf.createEntityManager();
    }
    
    //used for update or delete
    public CourseManager(Courses c) {
        emf = Persistence.createEntityManagerFactory("QECPU");
        em = emf.createEntityManager();
        
        this.c = c;
    }
    
    //clean up all instances of this class
    public void close() {
        em.close();
        emf.close();
    }
    
    //insert this record
    public void insert(Courses c) {
        em.getTransaction().begin();
        em.persist(c);
        em.getTransaction().commit();
    }
    
    //find a record by it's id
    public Courses findById(String id) {
        Courses c = em.find(Courses.class, id);
        //this.e=e;
        return c;
    }
    
    //delete this record
    public void delete(Courses c) {
        em.getTransaction().begin();
        //this is a little weird as we have to find the object once again
        //before its deleted - required because the object has to be in
        //the same context - too complicated to explain fully here
        Courses std = findById(c.getCoursename());
        em.remove(std);
        em.getTransaction().commit();
    }
    
    //update this record
   public void update (Student newemp) {
        
       // e.getEmployeePhoneCollection().clear();
       // e.setEmployeePhoneCollection(newemp.getEmployeePhoneCollection());
       //em.merge(e);
       
       // em.getTransaction().commit();
    }  
}