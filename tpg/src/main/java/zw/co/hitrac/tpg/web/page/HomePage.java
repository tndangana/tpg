/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zw.co.hitrac.tpg.web.page;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import zw.co.hitrac.tpg.web.chart.PerformanceChart;
import zw.co.hitrac.tpg.web.chart.GeneralChart;
import zw.co.hitrac.tpg.web.config.TpgSession;

/**
 *
 * @author hitrac
 */
public class HomePage extends WebPage {

    public HomePage(PageParameters parameters) {
        super(parameters);
          add(new BookmarkablePageLink("searchStudent", StudentListPage.class));
          
        String resultSheet = "";

        if (TpgSession.getLoggedResultSheet() != null && (TpgSSession.getLoggedResultSheet().getStudent() != null)) {
            resultSheet = TpgSession.getLoggedResultSheet().getStudent();
        } else {
            resultSheet = "----------------Set Student--------------------";
        } 
        
        add(new BookmarkablePageLink("level", LevelListPage.class));
        add(new BookmarkablePageLink("period", PeriodListPage.class));
        add(new BookmarkablePageLink("subject", SubjectListPage.class));
        add(new BookmarkablePageLink("resultsheet", ResultSheetListPage.class));
        add(new BookmarkablePageLink("teacher", TeacherListPage.class));
        add(new BookmarkablePageLink("student", StudentListPage.class));
        add(new BookmarkablePageLink("religion", ReligionListPage.class));
        add(new BookmarkablePageLink("user", UserListPage.class));
        add(new BookmarkablePageLink("gender", GenderListPage.class));
        add(new BookmarkablePageLink("logout", LoginPage.class));
     
    }

}
