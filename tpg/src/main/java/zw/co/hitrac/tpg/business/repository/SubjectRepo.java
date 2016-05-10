/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zw.co.hitrac.tpg.business.repository;

import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import zw.co.hitrac.tpg.business.domain.Subject;

/**
 *
 * @author g-birds
 */
public interface SubjectRepo extends JpaRepository<Subject, Serializable>{
    
}
