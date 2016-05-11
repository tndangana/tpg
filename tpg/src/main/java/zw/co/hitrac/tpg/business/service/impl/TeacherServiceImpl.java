/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zw.co.hitrac.tpg.business.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zw.co.hitrac.tpg.business.domain.Teacher;
import zw.co.hitrac.tpg.business.repository.TeacherRepo;
import zw.co.hitrac.tpg.business.service.TeacherService;

/**
 *
 * @author hitrac
 */
@Service
public class TeacherServiceImpl implements TeacherService {
    
    @Autowired
    private TeacherRepo teacherrepo;

    public Teacher save(Teacher teacher) {
       return teacherrepo.save(teacher);
    }

    public List<Teacher> findAll() {
        return teacherrepo.findAll();
    }

    public Teacher find(Long id) {
       return teacherrepo.findOne(id);
    }

    public void delete(Teacher teacher) {
        teacherrepo.delete(teacher);
        
    }
    
}
