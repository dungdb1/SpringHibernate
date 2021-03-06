package com.viettel.school.dao;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

 



import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.viettel.school.model.Student;
import com.viettel.school.util.HibernateUtil;
 
public class StudentDao {
 
SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
 
public StudentDao() {
 
}
public List<Student> getStudents()
 
{
	 
	Session s=sessionFactory.openSession();
	
	//List<Student> students= s.createCriteria(Student.class).list();
	 
	List<Student> students= s.createQuery("from Student students where 1=1").setCacheable(false).list();
	
	s.flush();
	s.clear();
	
	//s.getTransaction().commit();
	s.close();
	return students;
 
}
 
public Student getStudent(int studentid)
 
{
	 
	Session s=sessionFactory.openSession();
	 
	Criteria cr=s.createCriteria(Student.class);
	 
	cr.add(Restrictions.eq("studentid", studentid));
	 
	Student student=(Student) cr.list().get(0);
	s.flush();
	s.clear();
	//s.getTransaction().commit();
	s.close();
	return student;
 
}


 
}