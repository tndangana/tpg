/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zw.co.hitrac.tpg.business.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import zw.co.hitrac.tpg.business.domain.Student;
import zw.co.hitrac.tpg.business.repository.StudentRepo;
import zw.co.hitrac.tpg.business.service.StudentService;

/**
 *
 * @author pchikumba
 */
@Service
public class StudentServiceImpl implements StudentService{

    
    @Autowired
    private StudentRepo studentRepo;
    
    public Student save(Student student) {
        return studentRepo.save(student);
        
    }

    public List<Student> findAll() {
        return studentRepo.findAll();
        
    }

    public Student find(Long id) {
        return studentRepo.findOne(id);
        
        
    }

    public void delete(Student student) {
        studentRepo.delete(student);
    }

    
}
