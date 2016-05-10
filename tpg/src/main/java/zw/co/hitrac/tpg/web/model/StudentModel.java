/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zw.co.hitrac.tpg.web.model;

import org.apache.wicket.injection.Injector;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.spring.injection.annot.SpringBean;
import zw.co.hitrac.tpg.business.domain.Student;
import zw.co.hitrac.tpg.business.service.StudentService;

/**
 *
 * @author pchikumba
 */
public class StudentModel extends LoadableDetachableModel<Student>{
    private Long id;
    
    @SpringBean
    private StudentService studentservice;
    public StudentModel(Long id){
    this.id = id;
        Injector.get().inject(this);    
        
    }

    @Override
    protected Student load() {
        
        if (id == null) {
            return new Student();
        } else {
            return studentservice.find(id);
        
    }
    
    
    }}

    

