package qecSystem;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Rusty
 */
public class StudentManager {
    EntityManagerFactory emf;
    EntityManager em;
    Student s;
    
    
    //used for inserts
    public StudentManager() {
        emf = Persistence.createEntityManagerFactory("QECPU");
        em = emf.createEntityManager();
    }
    
    //used for update or delete
    public StudentManager(Student s) {
        emf = Persistence.createEntityManagerFactory("QECPU");
        em = emf.createEntityManager();
        
        this.s = s;
    }
    
    //clean up all instances of this class
    public void close() {
        em.close();
        emf.close();
    }
    
    //insert this record
    public void insert(Student s) {
        em.getTransaction().begin();
        em.persist(s);
        em.getTransaction().commit();
    }
    
    //find a record by it's id
    public Student findById(String id) {
        Student s = em.find(Student.class, id);
        //this.e=e;
        return s;
    }
    
    //delete this record
    public void delete(Student e) {
        em.getTransaction().begin();
        //this is a little weird as we have to find the object once again
        //before its deleted - required because the object has to be in
        //the same context - too complicated to explain fully here
        Student std = findById(e.getStudentid());
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