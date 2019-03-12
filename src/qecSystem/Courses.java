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
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Abdullah Sajid
 */
@Entity
@Table(name = "COURSES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Courses.findAll", query = "SELECT c FROM Courses c"),
    @NamedQuery(name = "Courses.findByCourseid", query = "SELECT c FROM Courses c WHERE c.courseid = :courseid"),
    @NamedQuery(name = "Courses.findByCoursename", query = "SELECT c FROM Courses c WHERE c.coursename = :coursename"),
    @NamedQuery(name = "Courses.findByCoursesemester", query = "SELECT c FROM Courses c WHERE c.coursesemester = :coursesemester")})
public class Courses implements Serializable {

    @OneToMany(mappedBy = "coursename")
    private Collection<Evaluation> evaluationCollection;

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "COURSEID")
    private int courseid;
    @Id
    @Basic(optional = false)
    @Column(name = "COURSENAME")
    private String coursename;
    @Column(name = "COURSESEMESTER")
    private Integer coursesemester;

    public Courses() {
    }

    public Courses(String coursename) {
        this.coursename = coursename;
    }

    public Courses(String coursename, int courseid) {
        this.coursename = coursename;
        this.courseid = courseid;
    }

    public int getCourseid() {
        return courseid;
    }

    public void setCourseid(int courseid) {
        int oldCourseid = this.courseid;
        this.courseid = courseid;
        changeSupport.firePropertyChange("courseid", oldCourseid, courseid);
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        String oldCoursename = this.coursename;
        this.coursename = coursename;
        changeSupport.firePropertyChange("coursename", oldCoursename, coursename);
    }

    public Integer getCoursesemester() {
        return coursesemester;
    }

    public void setCoursesemester(Integer coursesemester) {
        Integer oldCoursesemester = this.coursesemester;
        this.coursesemester = coursesemester;
        changeSupport.firePropertyChange("coursesemester", oldCoursesemester, coursesemester);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (coursename != null ? coursename.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Courses)) {
            return false;
        }
        Courses other = (Courses) object;
        if ((this.coursename == null && other.coursename != null) || (this.coursename != null && !this.coursename.equals(other.coursename))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "qecSystem.Courses[ coursename=" + coursename + " ]";
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
