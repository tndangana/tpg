
package zw.co.hitrac.tpg.web.model;

import org.apache.wicket.injection.Injector;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.spring.injection.annot.SpringBean;
import zw.co.hitrac.tpg.business.domain.Religion;
import zw.co.hitrac.tpg.business.service.ReligionService;


/**
 *
 * @author pchikumba
 * 27/04/2016
 */
public class ReligionModel extends LoadableDetachableModel<Religion>{

   private Long id;
   @SpringBean
    private ReligionService religionService;
    public ReligionModel(Long id){
        this.id=id;
        Injector.get().inject(this);
    }
    
    
    @Override
    protected Religion load() {
        
      if (id==null){
         return new Religion();
      } else{
          return religionService.find(id);
      } 
    }

 
    
}

    

