/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zw.co.hitrac.tpg.web.model;

import org.apache.wicket.injection.Injector;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.spring.injection.annot.SpringBean;
import zw.co.hitrac.tpg.business.domain.Subject;
import zw.co.hitrac.tpg.business.service.SubjectService;

/**
 *
 * @author g-birds
 */
public class SubjectModel extends LoadableDetachableModel<Subject>{
    
      
    private Long id;
    
    @SpringBean
    private SubjectService subjectservice;

    public SubjectModel(Long id) {
        this.id = id;
        Injector.get().inject(this);
    }
    
    
    

    @Override
    protected Subject load() {
        if (id == null) {
            return new Subject();
        } else {
            return subjectservice.find(id);
        }
    }
}

    

