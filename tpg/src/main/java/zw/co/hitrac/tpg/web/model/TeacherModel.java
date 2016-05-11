/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zw.co.hitrac.tpg.web.model;

import org.apache.wicket.injection.Injector;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.spring.injection.annot.SpringBean;
import zw.co.hitrac.tpg.business.domain.Teacher;
import zw.co.hitrac.tpg.business.service.TeacherService;

/**
 *
 * @author hitrac
 */
public class TeacherModel extends LoadableDetachableModel<Teacher> {
    private final Long id;
    @SpringBean
    private TeacherService teacherservice;

    public TeacherModel(Long id) {
        this.id = id;
        Injector.get().inject(this);
    }
    
    
    
    
    

    @Override
    protected Teacher load() {
        
        if(id==null){
        return new  Teacher();
        
        }else{
        return teacherservice.find(id);
        }
        
        
    }
    
}
