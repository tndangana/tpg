/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zw.co.hitrac.tpg.business.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zw.co.hitrac.tpg.business.domain.Gender;
import zw.co.hitrac.tpg.business.repository.GenderRepo;
import zw.co.hitrac.tpg.business.service.GenderService;

/**
 *
 * @author pchikumba
 */
@Service
public class GenderServiceImpl implements GenderService{
@Autowired
private GenderRepo genderRepo;

    public Gender save(Gender gender) {
    return genderRepo.save(gender);
        
        
    }

    public List<Gender> findAll() {
    return genderRepo.findAll();
        
    }

    public Gender find(Long id) {
        Gender gender=genderRepo.findOne(id);
    return genderRepo.findOne(id);
        
    }

    public void delete(Gender gender) {
        genderRepo.delete(gender);
        
        
    }
    
}
