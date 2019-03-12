/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qecSystem;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Abdullah Sajid
 */
@Entity
@Table(name = "EVALUATION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Evaluation.findAll", query = "SELECT e FROM Evaluation e"),
    @NamedQuery(name = "Evaluation.findByCourseevaluation", query = "SELECT e FROM Evaluation e WHERE e.courseevaluation = :courseevaluation"),
    @NamedQuery(name = "Evaluation.findByInstructorevaluation", query = "SELECT e FROM Evaluation e WHERE e.instructorevaluation = :instructorevaluation"),
    @NamedQuery(name = "Evaluation.findByTotalevaluation", query = "SELECT e FROM Evaluation e WHERE e.totalevaluation = :totalevaluation"),
    @NamedQuery(name = "Evaluation.findByStudentevaluation", query = "SELECT e FROM Evaluation e WHERE e.studentevaluation = :studentevaluation"),
    @NamedQuery(name = "Evaluation.findByEno", query = "SELECT e FROM Evaluation e WHERE e.eno = :eno")})
public class Evaluation implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "COURSEEVALUATION")
    private Double courseevaluation;
    @Column(name = "INSTRUCTOREVALUATION")
    private Double instructorevaluation;
    @Column(name = "TOTALEVALUATION")
    private Double totalevaluation;
    @Column(name = "STUDENTEVALUATION")
    private Double studentevaluation;
    @Id
    @Basic(optional = false)
    @Column(name = "ENO")
    private Integer eno;
    @JoinColumn(name = "COURSENAME", referencedColumnName = "COURSENAME")
    @ManyToOne
    private Courses coursename;
    @JoinColumn(name = "INSTRUCTORNAME", referencedColumnName = "INSTRUCTORNAME")
    @ManyToOne
    private Instructor instructorname;
    @JoinColumn(name = "STUDENTNAME", referencedColumnName = "STUDENTNAME")
    @ManyToOne
    private Student studentname;

    public Evaluation() {
    }

    public Evaluation(Integer eno) {
        this.eno = eno;
    }

    public Double getCourseevaluation() {
        return courseevaluation;
    }

    public void setCourseevaluation(Double courseevaluation) {
        this.courseevaluation = courseevaluation;
    }

    public Double getInstructorevaluation() {
        return instructorevaluation;
    }

    public void setInstructorevaluation(Double instructorevaluation) {
        this.instructorevaluation = instructorevaluation;
    }

    public Double getTotalevaluation() {
        return totalevaluation;
    }

    public void setTotalevaluation(Double totalevaluation) {
        this.totalevaluation = totalevaluation;
    }

    public Double getStudentevaluation() {
        return studentevaluation;
    }

    public void setStudentevaluation(Double studentevaluation) {
        this.studentevaluation = studentevaluation;
    }

    public Integer getEno() {
        return eno;
    }

    public void setEno(Integer eno) {
        this.eno = eno;
    }

    public Courses getCoursename() {
        return coursename;
    }

    public void setCoursename(Courses coursename) {
        this.coursename = coursename;
    }

    public Instructor getInstructorname() {
        return instructorname;
    }

    public void setInstructorname(Instructor instructorname) {
        this.instructorname = instructorname;
    }

    public Student getStudentname() {
        return studentname;
    }

    public void setStudentname(Student studentname) {
        this.studentname = studentname;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (eno != null ? eno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Evaluation)) {
            return false;
        }
        Evaluation other = (Evaluation) object;
        if ((this.eno == null && other.eno != null) || (this.eno != null && !this.eno.equals(other.eno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "qecSystem.Evaluation[ eno=" + eno + " ]";
    }
    
}
