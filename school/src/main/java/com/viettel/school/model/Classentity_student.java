package com.viettel.school.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import javax.persistence.Table;
import javax.persistence.Id;


@Entity
@Table(name="classentity_student")
public class Classentity_student {
	
	@Id
    @GeneratedValue
    @Column(name="id")
    int id;
    
    @Column(name="idClass",nullable=false)
    int idClass;

    @Column(name="studentid",nullable=false)
    int studentid;
     
    public int getid() {
        return id;
	 }
	
	 public void setid(int id) {
	        this.id = id;
	 }

     
     public int getidClass() {
            return idClass;
     }

     public void setidClass(int idClass) {
            this.idClass = idClass;
     }

     public int getstudentid() {
         return studentid;
	  }
	
	  public void setstudentid(int studentid) {
	         this.studentid = studentid;
	  }     


}