/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zw.co.hitrac.tpg.web.page;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.PropertyListView;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.spring.injection.annot.SpringBean;
import zw.co.hitrac.tpg.TpgPageParametersUtil;
import zw.co.hitrac.tpg.business.domain.Period;
import zw.co.hitrac.tpg.business.service.PeriodService;
import zw.co.hitrac.tpg.web.model.PeriodListModel;

/**
 *
 * @author g-birds
 */
public class PeriodListPage extends WebPage{
    
       
    @SpringBean
    private PeriodService periodservice;

    public PeriodListPage(PageParameters parameters) {
        super(parameters);
           add(new BookmarkablePageLink("back", HomePage.class));
        add(new BookmarkablePageLink("new", PeriodEditPage.class));
        add(new BookmarkablePageLink("back", HomePage.class));
         add(new PropertyListView<Period>("period", new PeriodListModel()){

            @Override
            protected void populateItem(ListItem<Period> item) {
                
                 item.add(new Label("term"));
                 PageParameters pageParameters = new PageParameters();
                 pageParameters.add(TpgPageParametersUtil.ID, item.getModelObject().getId());
                  item.add(new BookmarkablePageLink("edit", PeriodEditPage.class, pageParameters));
                  
            }
         
         
         
         });
        
    }
    
    
    
    
}
