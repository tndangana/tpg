/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zw.co.hitrac.tpg.business.repository;

import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import zw.co.hitrac.tpg.business.domain.User;


/**
 *
 * @author tonderai ndangana 
 * created on 3/5/2016
 */
public interface UserRepo extends JpaRepository<User, Serializable> {
    
}
