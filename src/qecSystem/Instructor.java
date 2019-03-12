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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Abdullah Sajid
 */
@Entity
@Table(name = "INSTRUCTOR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Instructor.findAll", query = "SELECT i FROM Instructor i"),
    @NamedQuery(name = "Instructor.findByInstructorid", query = "SELECT i FROM Instructor i WHERE i.instructorid = :instructorid"),
    @NamedQuery(name = "Instructor.findByInstructorname", query = "SELECT i FROM Instructor i WHERE i.instructorname = :instructorname"),
    @NamedQuery(name = "Instructor.findByDepartment", query = "SELECT i FROM Instructor i WHERE i.department = :department"),
    @NamedQuery(name = "Instructor.findByDateofjoining", query = "SELECT i FROM Instructor i WHERE i.dateofjoining = :dateofjoining")})
public class Instructor implements Serializable {

    @OneToMany(mappedBy = "instructorname")
    private Collection<Evaluation> evaluationCollection;

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "INSTRUCTORID")
    private int instructorid;
    @Id
    @Basic(optional = false)
    @Column(name = "INSTRUCTORNAME")
    private String instructorname;
    @Basic(optional = false)
    @Column(name = "DEPARTMENT")
    private String department;
    @Column(name = "DATEOFJOINING")
    @Temporal(TemporalType.DATE)
    private Date dateofjoining;

    public Instructor() {
    }

    public Instructor(String instructorname) {
        this.instructorname = instructorname;
    }

    public Instructor(String instructorname, int instructorid, String department) {
        this.instructorname = instructorname;
        this.instructorid = instructorid;
        this.department = department;
    }

    public int getInstructorid() {
        return instructorid;
    }

    public void setInstructorid(int instructorid) {
        int oldInstructorid = this.instructorid;
        this.instructorid = instructorid;
        changeSupport.firePropertyChange("instructorid", oldInstructorid, instructorid);
    }

    public String getInstructorname() {
        return instructorname;
    }

    public void setInstructorname(String instructorname) {
        String oldInstructorname = this.instructorname;
        this.instructorname = instructorname;
        changeSupport.firePropertyChange("instructorname", oldInstructorname, instructorname);
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        String oldDepartment = this.department;
        this.department = department;
        changeSupport.firePropertyChange("department", oldDepartment, department);
    }

    public Date getDateofjoining() {
        return dateofjoining;
    }

    public void setDateofjoining(Date dateofjoining) {
        Date oldDateofjoining = this.dateofjoining;
        this.dateofjoining = dateofjoining;
        changeSupport.firePropertyChange("dateofjoining", oldDateofjoining, dateofjoining);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (instructorname != null ? instructorname.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Instructor)) {
            return false;
        }
        Instructor other = (Instructor) object;
        if ((this.instructorname == null && other.instructorname != null) || (this.instructorname != null && !this.instructorname.equals(other.instructorname))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "qecSystem.Instructor[ instructorname=" + instructorname + " ]";
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
