package zw.co.hitrac.tpg.web.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import org.apache.wicket.protocol.http.WicketFilter;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import zw.co.hitrac.support.business.config.PersistenceConfig;



/**
 *
 * @author hitrac
 */
@WebFilter(value = "/*", initParams = {
    @WebInitParam(name = "applicationClassName", value = "zw.co.hitrac.tpg.web.config.TpgApplication"),
    @WebInitParam(name = "filterMappingUrlPattern", value = "/*")})
public class TpgWebInitializer extends WicketFilter implements WebApplicationInitializer {

    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        servletContext.addListener(new ContextLoaderListener(ctx));
        ctx.register(PersistenceConfig.class);

    }

}
