/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zw.co.hitrac.tpg.web.page;

import org.apache.wicket.authroles.authentication.AuthenticatedWebSession;
import org.apache.wicket.authroles.authorization.strategies.role.Roles;
import org.apache.wicket.request.Request;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import zw.co.hitrac.support.business.config.PersistenceConfig;
import zw.co.hitrac.tpg.business.domain.User;
import zw.co.hitrac.tpg.business.service.UserService;

/**
 *
 * @author 
 */
public class BasicAuthenticationSession extends AuthenticatedWebSession {
    ApplicationContext ac = new AnnotationConfigApplicationContext(PersistenceConfig.class);
    private final UserService userService = ac.getBean(UserService.class);
    
    
    
	public BasicAuthenticationSession(Request request) {
		super(request);		
	}
        
	@Override
	public boolean authenticate(String username, String password) {
		User u =userService.get(username, password);
                if(u != null){
                    return Boolean.TRUE;
                }
                
                return Boolean.FALSE;
	}

	@Override
	public Roles getRoles() {
		return null;
	}
}
