/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zw.co.hitrac.tpg.web.model;

import org.apache.wicket.injection.Injector;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.spring.injection.annot.SpringBean;
import zw.co.hitrac.tpg.business.domain.StaffMember;
import zw.co.hitrac.tpg.business.service.StaffMemberService;

/**
 *
 * @author g-birds
 */
public class StaffMemberModel extends LoadableDetachableModel<StaffMember>{
    
    
    private Long id;
    
    @SpringBean
    private StaffMemberService staffmemberservice;

    public StaffMemberModel(Long id) {
        this.id = id;
        Injector.get().inject(this);
    }
    
    
    

    @Override
    protected StaffMember load() {
        if (id == null) {
            return new StaffMember();
        } else {
            return staffmemberservice.find(id);
        }
    }
}


