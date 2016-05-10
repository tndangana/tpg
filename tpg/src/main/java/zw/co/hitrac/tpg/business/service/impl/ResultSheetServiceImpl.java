/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zw.co.hitrac.tpg.business.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zw.co.hitrac.tpg.business.domain.ResultSheet;
import zw.co.hitrac.tpg.business.repository.ResultSheetRepo;
import zw.co.hitrac.tpg.business.service.ResultSheetService;

/**
 *
 * @author hitrac
 */
@Service
public class ResultSheetServiceImpl implements ResultSheetService {
    
    @Autowired
    private ResultSheetRepo resultrepo;

    public ResultSheet save(ResultSheet resultsheet) {
        return resultrepo.save(resultsheet);
    }

    public List<ResultSheet> findAll() {
        return resultrepo.findAll();
    }

    public ResultSheet find(Long id) {
      return resultrepo.findOne(id);
    }

    public void delete(ResultSheet resultsheet) {
       resultrepo.delete(resultsheet);
    }
    
}
