/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zw.co.hitrac.tpg.web.model;

import java.util.ArrayList;
import java.util.List;
import org.apache.wicket.injection.Injector;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.apache.wicket.util.string.Strings;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import zw.co.hitrac.tpg.business.domain.Student;
import zw.co.hitrac.tpg.business.service.StudentService;

/**
 *
 * @author pchikumba
 */
public class StudentListModel extends LoadableDetachableModel<List<Student>>{
  
     @SpringBean
    private StudentService studentService;

    public StudentListModel() {
        Injector.get().inject(this);
    }
    
    

    @Override
    protected List<Student> load() {
        return studentService.findAll();
        
    }
    
}

