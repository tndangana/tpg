/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zw.co.hitrac.tpg.business.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zw.co.hitrac.tpg.business.domain.StaffMember;
import zw.co.hitrac.tpg.business.repository.StaffMemberRepo;
import zw.co.hitrac.tpg.business.service.StaffMemberService;

/**
 *
 * @author g-birds
 */
@Service
public class StaffMemberSeviceImpl implements StaffMemberService{

    @Autowired
    private StaffMemberRepo staffmemberrepo;
    
    public StaffMember save(StaffMember staffmember) {
        return staffmemberrepo.save(staffmember);
    }

    public List<StaffMember> findAll() {
       return staffmemberrepo.findAll();
    }

    public StaffMember find(Long id) {
       return staffmemberrepo.findOne(id);
    }

    public void delete(StaffMember staffmember) {
       staffmemberrepo.delete(staffmember);
    }
    
}
