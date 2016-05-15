package zw.co.hitrac.tpg.web.config;

import java.util.Locale;
import java.util.Set;
import org.apache.wicket.Session;
import org.apache.wicket.authroles.authentication.AuthenticatedWebSession;
import org.apache.wicket.authroles.authorization.strategies.role.Roles;
import org.apache.wicket.injection.Injector;
import org.apache.wicket.request.Request;
import org.apache.wicket.spring.injection.annot.SpringBean;
import zw.co.hitrac.tpg.business.domain.Role;
import zw.co.hitrac.tpg.business.domain.User;
import zw.co.hitrac.tpg.business.service.UserService;


public class TpgSession extends AuthenticatedWebSession {

    public static Object getLoggedResultSheet() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @SpringBean
    private transient UserService userService;
    private User user;

    public TpgSession(Request request) {
        super(request);
        this.setLocale(Locale.UK);
        Injector.get().inject(this);
    }

    @Override
    public boolean authenticate(String username, String password) {
        try {

            User $user = this.userService.get(username, password);
            setUser($user);
            return user != null;

        } catch (NullPointerException ex) {
            return false;
        }
    }

    @Override
    public Roles getRoles() {
        Set<Role> userRoles = user.getRoles();

        String userRolesString[] = new String[userRoles.size()];
        int i = 0;

        for (Role role : user.getRoles()) {
            userRolesString[i++] = role.getRoleName();
        }

        Roles roles = new Roles(userRolesString);
        return roles;
    }

    public boolean hasAnyRole(Roles roles) {
        if (getUser() == null) {
            return false;
        }
        return this.getRoles().hasAnyRole(roles);
    }

    public boolean hasRole(String role) {
        if (getUser() == null) {
            return false;
        }
        return this.getRoles().hasRole(role);
    }

    public boolean hasAllRoles(Roles roles) {
        if (getUser() == null) {
            return false;
        }
        return this.getRoles().hasAllRoles(roles);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public static TpgSession get() {
        return (TpgSession)Session.get();
    }
}
