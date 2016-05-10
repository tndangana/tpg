/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zw.co.hitrac.tpg.web.model;

import java.util.List;
import org.apache.wicket.injection.Injector;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.spring.injection.annot.SpringBean;
import zw.co.hitrac.tpg.business.domain.Subject;
import zw.co.hitrac.tpg.business.service.SubjectService;

/**
 *
 * @author g-birds
 */
public class SubjectListModel extends LoadableDetachableModel<List<Subject>>{
    
        
    @SpringBean
    private SubjectService subjectService;

    public SubjectListModel() {
        Injector.get().inject(this);
    }
    
    

    @Override
    protected List<Subject> load() {
        return subjectService.findAll();
        
    }
    
}

    

