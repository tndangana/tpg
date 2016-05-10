/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zw.co.hitrac.tpg.web.model;

import org.apache.wicket.injection.Injector;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.spring.injection.annot.SpringBean;
import zw.co.hitrac.tpg.business.domain.Period;
import zw.co.hitrac.tpg.business.service.PeriodService;

/**
 *
 * @author g-birds
 */
public class PeriodModel extends LoadableDetachableModel<Period>{
   
    private Long id;
    
    @SpringBean
    private PeriodService periodService;

    public PeriodModel(Long id) {
        this.id = id;
        Injector.get().inject(this);
    }
    
    
    

    @Override
    protected Period load() {
        if (id == null) {
            return new Period();
        } else {
            return periodService.find(id);
        }
    }
}


