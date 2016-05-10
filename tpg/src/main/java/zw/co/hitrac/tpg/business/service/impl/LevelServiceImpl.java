/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zw.co.hitrac.tpg.business.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zw.co.hitrac.tpg.business.domain.Level;
import zw.co.hitrac.tpg.business.repository.LevelRepo;
import zw.co.hitrac.tpg.business.service.LevelService;

/**
 *
 * @author hitrac
 */
@Service
public class LevelServiceImpl implements LevelService {
    
    @Autowired
    private LevelRepo levelrepo;

    public Level save(Level level) {
        return levelrepo.save(level);
       
    }

    public List<Level> findAll() {
      return levelrepo.findAll();
    }

    public Level find(Long id) {
      return levelrepo.findOne(id);
    }

    public void delete(Level level) {
         levelrepo.delete(level);
    }
    
}
