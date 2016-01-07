package com.viettel.school.ws;
 
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.viettel.school.dao.StudentDao;
import com.viettel.school.model.Student;
 
@RestController
@RequestMapping("/service")
@CachePut("/service")
public class RestServiceController {
 
    private StudentDao studentdao=new StudentDao();
     
    @RequestMapping(value="/students", method=RequestMethod.GET)
    @CachePut(value="/students")
    public List<Student> students() {
        return studentdao.getStudents();
    }
     
    @RequestMapping(value="/student", method=RequestMethod.GET)
    @CachePut(value="/student")
    public Student student(HttpServletRequest request) {
        if(request.getParameter("id")!=null)
        {
        return studentdao.getStudent(Integer.parseInt(request.getParameter("id")));
        }
        return null;
    }
}