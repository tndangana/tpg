package zw.co.hitrac.tpg.web.config;

import org.apache.wicket.Page;
import org.apache.wicket.Session;
import org.apache.wicket.authroles.authentication.AbstractAuthenticatedWebSession;
import org.apache.wicket.authroles.authentication.AuthenticatedWebApplication;
import org.apache.wicket.authroles.authorization.strategies.role.IRoleCheckingStrategy;
import org.apache.wicket.authroles.authorization.strategies.role.RoleAuthorizationStrategy;
import org.apache.wicket.authroles.authorization.strategies.role.Roles;
import org.apache.wicket.authroles.authorization.strategies.role.metadata.MetaDataRoleAuthorizationStrategy;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.spring.injection.annot.SpringComponentInjector;
import zw.co.hitrac.tpg.business.domain.Role;
import zw.co.hitrac.tpg.web.page.HomePage;
import zw.co.hitrac.tpg.web.page.LoginPage;
import zw.co.hitrac.tpg.web.page.SitePage;

/**
 *
 * @author tonderai ndangana 21/04/2016
 */
public class TpgApplication extends AuthenticatedWebApplication {

    @Override
    public Class<? extends Page> getHomePage() {
        
        return HomePage.class;
    }

    @Override
    protected Class<? extends AbstractAuthenticatedWebSession> getWebSessionClass() {
        return TpgSession.class;
    }

    @Override
    protected Class<? extends WebPage> getSignInPageClass() {
        return SitePage.class;
        //return LoginPage.class;
        
    }

    @Override
    protected void init() {
        super.init();
        getComponentInstantiationListeners().add(new SpringComponentInjector(this));
        getSecuritySettings().setAuthorizationStrategy(new RoleAuthorizationStrategy(new IRoleCheckingStrategy() {

            public boolean hasAnyRole(Roles roles) {
                TpgSession session = (TpgSession) Session.get();
                return session.hasAnyRole(roles);
            }
        }));
        MetaDataRoleAuthorizationStrategy.authorize(HomePage.class, getRoles(Role.values()));
        this.getMarkupSettings().setStripWicketTags(true);
    }
    
    private static String SEPARATOR = ",";
    public static String getRoles(Role... roles){
        StringBuilder str = new StringBuilder();
        for(Role r: roles){
            str.append(r.getRoleName()).append(SEPARATOR);
        }
        return str.substring(0, str.lastIndexOf(SEPARATOR));
    }

}
