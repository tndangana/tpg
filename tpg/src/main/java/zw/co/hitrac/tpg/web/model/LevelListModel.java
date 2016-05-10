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
import zw.co.hitrac.tpg.business.domain.Level;
import zw.co.hitrac.tpg.business.service.LevelService;

/**
 *
 * @author hitrac
 */
public class LevelListModel extends LoadableDetachableModel<List<Level>> {
    
    @SpringBean
    private LevelService levelservice;

    public LevelListModel() {
        Injector.get().inject(this);
    }
    
    

    @Override
    protected List<Level> load() {
        return levelservice.findAll();
        
    }
    
}
