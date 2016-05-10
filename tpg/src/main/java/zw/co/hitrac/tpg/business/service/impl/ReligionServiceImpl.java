/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zw.co.hitrac.tpg.business.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zw.co.hitrac.tpg.business.domain.Religion;
import zw.co.hitrac.tpg.business.repository.ReligionRepo;
import zw.co.hitrac.tpg.business.service.ReligionService;


/**
 *
 * @author pchikumba
 */

@Service
public class ReligionServiceImpl implements ReligionService{

   @Autowired
   
   private ReligionRepo religionRepo;

    public Religion save(Religion religion) {
        return religionRepo.save(religion) ;
    }

    public List<Religion> findAll() {
        return religionRepo.findAll();
    }

    public Religion find(Long id) {
        return religionRepo.findOne(id);
    }

    public void delete(Religion religion) {
        
        religionRepo.delete(religion);
       
    }
   
    
}
