/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zw.co.hitrac.tpg.business.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 *
 * @author hitrac
 */
@Entity
public class ResultSheet implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne
    private Teacher Teacher;
    @ManyToOne
    private Level level;
   
    @ManyToOne
    private Period period;
    @OneToOne
    private Student student;
    @ManyToOne
    private Subject Subject;
    private int Actualmark;
    private int PossibleMark;
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Teacher getTeacher() {
        return Teacher;
    }

    public void setTeacher(Teacher Teacher) {
        this.Teacher = Teacher;
    }

 

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

   

  
   

 
    public Subject getSubject() {
        return Subject;
    }

    public void setSubject(Subject Subject) {
        this.Subject = Subject;
    }

  

    public int getActualmark() {
        return Actualmark;
    }

    public void setActualmark(int Actualmark) {
        this.Actualmark = Actualmark;
    }

    public int getPossibleMark() {
        return PossibleMark;
    }

    public void setPossibleMark(int PossibleMark) {
        this.PossibleMark = PossibleMark;
    }

    public Period getPeriod() {
        return period;
    }

    public void setPeriod(Period period) {
        this.period = period;
    }
    


  

    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ResultSheet)) {
            return false;
        }
        ResultSheet other = (ResultSheet) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "zw.co.hitrac.tpg.business.domain.MarkShhet[ id=" + id + " ]";
    }
    
}
