package com.viettel.school.dao;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

 
import com.viettel.school.model.Student;
import com.viettel.school.util.HibernateUtil;
 
public class StudentDao {
 
SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
 
public StudentDao() {
 
}
public List<Student> getStudents()
 
{
	 
	Session s=sessionFactory.openSession();
	 
	List<Student> students= s.createCriteria(Student.class).list();
	 
	s.clear();
	s.close();
	return students;
 
}
 
public Student getStudent(int studentid)
 
{
	 
	Session s=sessionFactory.openSession();
	 
	Criteria cr=s.createCriteria(Student.class);
	 
	cr.add(Restrictions.eq("studentid", studentid));
	 
	Student student=(Student) cr.list().get(0);
	 
	s.close();
	return student;
 
}
 
}