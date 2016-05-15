/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zw.co.hitrac.tpg.web.model;

import org.apache.wicket.model.LoadableDetachableModel;
import zw.co.hitrac.tpg.web.config.GeneralSearch;

/**
 *
 * @author g-birds
 */
public class GeneralSearchModel extends LoadableDetachableModel<GeneralSearch> {

  

    public GeneralSearchModel() {      
    }

    protected GeneralSearch load() {
       return new GeneralSearch();
    }
}
