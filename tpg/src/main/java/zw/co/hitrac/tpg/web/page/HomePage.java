/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
        
        
       
    }
    
}
