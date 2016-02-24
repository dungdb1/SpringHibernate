package com.viettel.school.model;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
 

@Entity
@Table(name="classentity")
public class Classentity {
       @Id
       @GeneratedValue
       @Column(name="idClass")
       int idClass;
 
       @Column(name="ClassDescription",nullable=false,length=255)
       String ClassDescription;
 
       @Column(name="ClassName",nullable=false,length=255)
       String ClassName;
       
       //private List<Student> Student;
       
       @OneToMany(cascade = CascadeType.ALL)
       @JoinTable(
               name = "classentity_student",
               joinColumns = @JoinColumn(name = "idClass"),
               inverseJoinColumns = @JoinColumn(name = "studentid")
       )
       
       public int getidClass() {
              return idClass;
       }

       public void setidClass(int idClass) {
	           this.idClass = idClass;
	    }
       
       public String getClassDescription() {
              return ClassDescription;
       }
 
       public void setClassDescription(String ClassDescription) {
              this.ClassDescription = ClassDescription;
       }
 
       public String getClassName() {
              return ClassName;
       }
 
       public void setClassName(String ClassName) {
              this.ClassName = ClassName;
       }
 
       /*
       public List<Student> getStudents() {
           return Student;
       }
       
       public void setStudents(List<Student> Student) {
    	   this.Student = Student;
       }
       
       */
     
}