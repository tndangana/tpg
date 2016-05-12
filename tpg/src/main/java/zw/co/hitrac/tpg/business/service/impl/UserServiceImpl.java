
package zw.co.hitrac.tpg.business.service.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zw.co.hitrac.tpg.business.domain.User;
import zw.co.hitrac.tpg.business.repository.UserRepo;
import zw.co.hitrac.tpg.business.service.UserService;


/**
 *
 * @author tonderai ndangana
 * created on 03/04/2016
 */
@Service
public class UserServiceImpl implements UserService{
    
    @Autowired
    private UserRepo userRepo;
    @PersistenceContext
    private EntityManager entityManager;
 

    public User save(User user) {
       return userRepo.save(user);
    }

    public List<User> findAll() {
      
        List<User> user = userRepo.findAll();
        return user;
    }

    public User find(Long id) {
       User user = userRepo.findOne(id);
       return user;
    }

    public void delete(User user) {
        userRepo.delete(user);
        
    }

    public User get(String username, String password) {
        List<User> users = entityManager.createQuery("SELECT u from User u WHERE u.username=:uname AND u.password=:upass").setParameter("uname", username).setParameter("upass", password).getResultList();
        if(!users.isEmpty()){
            return users.get(0);
        } else {
            return null;
        }
    }
    
}
