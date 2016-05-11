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
import zw.co.hitrac.tpg.business.domain.Level;
import zw.co.hitrac.tpg.business.service.LevelService;
import zw.co.hitrac.tpg.web.model.LevelListModel;

/**
 *
 * @author hitrac
 */
public class LevelListPage extends WebPage{
    
    @SpringBean
    private LevelService levelservice;

    public LevelListPage(PageParameters parameters) {
        super(parameters);
        add(new BookmarkablePageLink("back", HomePage.class ));
        add(new BookmarkablePageLink("new", LevelEditPage.class));
         add(new PropertyListView<Level>("level", new LevelListModel()){

            @Override
            protected void populateItem(ListItem<Level> li) {
                
                 li.add(new Label("leveltype"));
                 PageParameters pageParameters = new PageParameters();
                 pageParameters.add(TpgPageParametersUtil.ID, li.getModelObject().getId());
                  li.add(new BookmarkablePageLink("edit", LevelEditPage.class, pageParameters));
                  
            }
         
         
         
         });
        
    }
    
    
    
}
