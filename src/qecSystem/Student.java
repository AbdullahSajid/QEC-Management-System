/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qecSystem;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Abdullah Sajid
 */
@Entity
@Table(name = "STUDENT", catalog = "", schema = "ABDULLAH")
@NamedQueries({
    @NamedQuery(name = "Student.findAll", query = "SELECT s FROM Student s"),
    @NamedQuery(name = "Student.findByStudentid", query = "SELECT s FROM Student s WHERE s.studentid = :studentid"),
    @NamedQuery(name = "Student.findByStudentname", query = "SELECT s FROM Student s WHERE s.studentname = :studentname"),
    @NamedQuery(name = "Student.findByFathername", query = "SELECT s FROM Student s WHERE s.fathername = :fathername"),
    @NamedQuery(name = "Student.findBySemester", query = "SELECT s FROM Student s WHERE s.semester = :semester"),
    @NamedQuery(name = "Student.findByDateofjoining", query = "SELECT s FROM Student s WHERE s.dateofjoining = :dateofjoining"),
    @NamedQuery(name = "Student.findByDepartment", query = "SELECT s FROM Student s WHERE s.department = :department")})
public class Student implements Serializable {

    @OneToMany(mappedBy = "studentname")
    private Collection<Evaluation> evaluationCollection;

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "STUDENTID")
    private String studentid;
    @Id
    @Basic(optional = false)
    @Column(name = "STUDENTNAME")
    private String studentname;
    @Basic(optional = false)
    @Column(name = "FATHERNAME")
    private String fathername;
    @Basic(optional = false)
    @Column(name = "SEMESTER")
    private int semester;
    @Column(name = "DATEOFJOINING")
    @Temporal(TemporalType.DATE)
    private Date dateofjoining;
    @Column(name = "DEPARTMENT")
    private String department;

    public Student() {
    }

    public Student(String studentname) {
        this.studentname = studentname;
    }

    public Student(String studentname, String studentid, String fathername, int semester) {
        this.studentname = studentname;
        this.studentid = studentid;
        this.fathername = fathername;
        this.semester = semester;
    }

    public String getStudentid() {
        return studentid;
    }

    public void setStudentid(String studentid) {
        String oldStudentid = this.studentid;
        this.studentid = studentid;
        changeSupport.firePropertyChange("studentid", oldStudentid, studentid);
    }

    public String getStudentname() {
        return studentname;
    }

    public void setStudentname(String studentname) {
        String oldStudentname = this.studentname;
        this.studentname = studentname;
        changeSupport.firePropertyChange("studentname", oldStudentname, studentname);
    }

    public String getFathername() {
        return fathername;
    }

    public void setFathername(String fathername) {
        String oldFathername = this.fathername;
        this.fathername = fathername;
        changeSupport.firePropertyChange("fathername", oldFathername, fathername);
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        int oldSemester = this.semester;
        this.semester = semester;
        changeSupport.firePropertyChange("semester", oldSemester, semester);
    }

    public Date getDateofjoining() {
        return dateofjoining;
    }

    public void setDateofjoining(Date dateofjoining) {
        Date oldDateofjoining = this.dateofjoining;
        this.dateofjoining = dateofjoining;
        changeSupport.firePropertyChange("dateofjoining", oldDateofjoining, dateofjoining);
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        String oldDepartment = this.department;
        this.department = department;
        changeSupport.firePropertyChange("department", oldDepartment, department);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (studentname != null ? studentname.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Student)) {
            return false;
        }
        Student other = (Student) object;
        if ((this.studentname == null && other.studentname != null) || (this.studentname != null && !this.studentname.equals(other.studentname))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "qecSystem.Student[ studentname=" + studentname + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }

    @XmlTransient
    public Collection<Evaluation> getEvaluationCollection() {
        return evaluationCollection;
    }

    public void setEvaluationCollection(Collection<Evaluation> evaluationCollection) {
        this.evaluationCollection = evaluationCollection;
    }
    
}
