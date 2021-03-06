
package zw.co.hitrac.tpg.web.page;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.request.mapper.parameter.PageParameters;

/**
 *
 * @author hitrac
 */
public class HomePage extends WebPage {

    public HomePage(PageParameters parameters) {
        super(parameters);
        add(new BookmarkablePageLink("level", LevelListPage.class));
        add(new BookmarkablePageLink("period", PeriodListPage.class));
        add(new BookmarkablePageLink("subject", SubjectListPage.class));
        add(new BookmarkablePageLink("resultsheet", ResultSheetListPage.class));
        add(new BookmarkablePageLink("teacher", TeacherListPage.class));
        add(new BookmarkablePageLink("student", StudentListPage.class));
        add(new BookmarkablePageLink("religion", ReligionListPage.class));
        add(new BookmarkablePageLink("gender", GenderListPage.class));
        
        add(new BookmarkablePageLink("user", UserListPage.class));
        add(new BookmarkablePageLink("logout", LoginPage.class));
//        add(new BookmarkablePageLink("studentprofile", StudentProfileViewPage.class));
     
    }

}
