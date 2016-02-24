package com.viettel.school.dao;
import java.util.List;

import javassist.convert.Transformer;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

 




import org.hibernate.transform.ResultTransformer;
import org.hibernate.transform.Transformers;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.viettel.school.model.Classentity;
import com.viettel.school.model.Student;
import com.viettel.school.model.Classentity_student;
import com.viettel.school.util.HibernateUtil;


 
public class ClassDao {
	SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
	 
	public ClassDao() {
	 
	}
	public List<Classentity> getClasses()
	 
	{
		 
		Session s=sessionFactory.openSession();
		
		//List<Student> students= s.createCriteria(Student.class).list();
		 
		List<Classentity> Classes= s.createQuery("from Classentity Classes where 1=1").setCacheable(false).list();
		
		s.flush();
		s.clear();
		
		//s.getTransaction().commit();
		s.close();
		return Classes;
	 
	}
	 
	public Classentity getClass(int Classid)
	 
	{
		Session s=sessionFactory.openSession();
		 
		Criteria cr=s.createCriteria(Classentity.class);
		 
		cr.add(Restrictions.eq("idclass", Classid));
		 
		Classentity Class=(Classentity) cr.list().get(0);
		s.flush();
		s.clear();
		//s.getTransaction().commit();
		s.close();
		return Class;
	 
	}
	public List<Student> getStudentsInClasses(int ClassId)
	{
		Session s=sessionFactory.openSession();
		 try {
	            String HQL = "Select stu.studentid as studentid, stu.name as name, stu.imageurl as imageurl, stu.address as address, stu.grade as grade, clas.idClass as idClass, clas.ClassName as ClassName, clas.ClassDescription as ClassDescription FROM "
	                    + "Student as stu, "
	                    + "Classentity_student as cls, "
	                    + "Classentity as clas "
	                    + "WHERE clas.idClass = (:id) "
	                    + "AND clas.idClass = cls.idClass "
	                    + "AND stu.studentid = cls.studentid";

	            Query q = s.createQuery(HQL);
	            q.setParameter("id", ClassId);
	            List<Student> Students = q.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
	            
	            //setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP)
	            return Students;
	        } catch (HibernateException he) {
	            throw he;
	        } finally {
	            
	        }
		
	}
	
	public List<Student> getAllStudents()
	{
		Session s=sessionFactory.openSession();
		 try {
	            String HQL = "Select stu.studentid as studentid, stu.name as name, stu.imageurl as imageurl, stu.address as address, stu.grade as grade, clas.idClass as idClass, clas.ClassName as ClassName, clas.ClassDescription as ClassDescription FROM "
	                    + "Student as stu, "
	                    + "Classentity_student as cls, "
	                    + "Classentity as clas "
	                    + "WHERE "
	                    + "clas.idClass = cls.idClass "
	                    + "AND stu.studentid = cls.studentid";

	            Query q = s.createQuery(HQL);

	            List<Student> Students = q.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
	            
	            //setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP)
	            return Students;
	        } catch (HibernateException he) {
	            throw he;
	        } finally {
	            
	        }
		
	}
	 
	
	}
