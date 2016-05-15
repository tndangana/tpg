/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zw.co.hitrac.tpg.web.model;

import org.apache.wicket.injection.Injector;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.spring.injection.annot.SpringBean;
import zw.co.hitrac.tpg.business.domain.ResultSheet;
import zw.co.hitrac.tpg.business.service.ResultSheetService;

/**
 *
 * @author hitrac
 */
public class ResultSheetModel extends LoadableDetachableModel<ResultSheet> {
    
    private Long id;
    
    @SpringBean
    private ResultSheetService resultservice;

    public ResultSheetModel(Long id) {
        this.id = id;
        Injector.get().inject(this);
    }

    public ResultSheetModel(Long id, Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    

    @Override
    protected ResultSheet load() {
        if(id == null){
        return new ResultSheet();
        }
        else
        {return resultservice.find(id);
        
        }
    }
    
}
