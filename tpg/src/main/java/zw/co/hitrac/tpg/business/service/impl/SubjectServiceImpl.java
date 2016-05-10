/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zw.co.hitrac.tpg.business.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zw.co.hitrac.tpg.business.domain.Subject;
import zw.co.hitrac.tpg.business.repository.SubjectRepo;
import zw.co.hitrac.tpg.business.service.SubjectService;

/**
 *
 * @author g-birds
 */
@Service
public class SubjectServiceImpl implements SubjectService{
    
    @Autowired
    private SubjectRepo subjectrepo;

    public Subject save(Subject subject) {
        return subjectrepo.save(subject);
    }

    public List<Subject> findAll() {
       return subjectrepo.findAll();
    }

    public Subject find(Long id) {
        return subjectrepo.findOne(id);
    }

    public void delete(Subject subject) {
        subjectrepo.delete(subject);
    }
    
}
