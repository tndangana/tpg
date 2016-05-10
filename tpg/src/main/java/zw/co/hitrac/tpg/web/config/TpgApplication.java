package zw.co.hitrac.tpg.web.config;

import org.apache.wicket.Page;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.spring.injection.annot.SpringComponentInjector;
import zw.co.hitrac.tpg.web.page.HomePage;



/**
 *
 * @author tonderai ndangana
 * 21/04/2016
 */
public class TpgApplication extends WebApplication {

    @Override
    public Class<? extends Page> getHomePage() {
        return HomePage.class;
    }

    @Override
    protected void init() {
        super.init();
        getComponentInstantiationListeners().add(new SpringComponentInjector(this));
    }

}
