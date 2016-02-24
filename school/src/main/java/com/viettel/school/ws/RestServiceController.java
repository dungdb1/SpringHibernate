package com.viettel.school.ws;
 
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.viettel.school.dao.ClassDao;
import com.viettel.school.dao.StudentDao;
import com.viettel.school.model.Classentity;
import com.viettel.school.model.Student;

 
@RestController
@RequestMapping("/service")
public class RestServiceController {
 
    private StudentDao studentdao=new StudentDao();
    private ClassDao classdao = new ClassDao();
     
    @RequestMapping(value="/students", method=RequestMethod.GET)
    
    public List<Student> students() {
        return studentdao.getStudents();
    }
     
    @RequestMapping(value="/student", method=RequestMethod.GET)
    
    public Student student(HttpServletRequest request) {
        if(request.getParameter("id")!=null)
        {
        return studentdao.getStudent(Integer.parseInt(request.getParameter("id")));
        }
        return null;
    }
    
    @RequestMapping(value="/students_in_class", method=RequestMethod.GET)
    public List<Student> students_in_class(HttpServletRequest request){
    	if (request.getParameter("ClassId")!=null)
    	{
    		return classdao.getStudentsInClasses(Integer.parseInt(request.getParameter("ClassId")));
    	}
    	return null;
    }
    @RequestMapping(value="/all_students", method=RequestMethod.GET)
    public List<Student> all_students(HttpServletRequest request){
    	return classdao.getAllStudents();
    	
    }    
    
    
}