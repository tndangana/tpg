/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zw.co.hitrac.tpg.business.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zw.co.hitrac.tpg.business.domain.Period;
import zw.co.hitrac.tpg.business.repository.PeriodRepo;
import zw.co.hitrac.tpg.business.service.PeriodService;

/**
 *
 * @author g-birds
 */
@Service
public class PeriodServiceImpl implements PeriodService{
    
    @Autowired
    private PeriodRepo periodrepo;

    public Period save(Period period) {
        return periodrepo.save(period);
    }

    public List<Period> findAll() {
       return periodrepo.findAll();
    }

    public Period find(Long id) {
        return periodrepo.findOne(id);
    }

    public void delete(Period period) {
       periodrepo.delete(period);
    }
    
}
