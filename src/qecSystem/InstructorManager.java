package qecSystem;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Rusty
 */
public class InstructorManager {
    EntityManagerFactory emf;
    EntityManager em;
    Instructor i;
    
    
    //used for inserts
    public InstructorManager() {
        emf = Persistence.createEntityManagerFactory("QECPU");
        em = emf.createEntityManager();
    }
    
    //used for update or delete
    public InstructorManager(Instructor i) {
        emf = Persistence.createEntityManagerFactory("QECPU");
        em = emf.createEntityManager();
        
        this.i = i;
    }
    
    //clean up all instances of this class
    public void close() {
        em.close();
        emf.close();
    }
    
    //insert this record
    public void insert(Instructor i) {
        em.getTransaction().begin();
        em.persist(i);
        em.getTransaction().commit();
    }
    
    //find a record by it's id
    public Instructor findById(String id) {
        Instructor i = em.find(Instructor.class, id);
        //this.e=e;
        return i;
    }
    
    //delete this record
    public void delete(Instructor e) {
        em.getTransaction().begin();
        //this is a little weird as we have to find the object once again
        //before its deleted - required because the object has to be in
        //the same context - too complicated to explain fully here
        Instructor std = findById(e.getInstructorname());
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