
package zw.co.hitrac.tpg.web.page;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.request.mapper.parameter.PageParameters;

/**
 *
 * @author pchikumba
 */
public class SitePage extends WebPage {

    public SitePage(PageParameters parameters) {
        super(parameters);
       
        add(new BookmarkablePageLink("directtosasys", LoginPage.class));

     
    }

}
