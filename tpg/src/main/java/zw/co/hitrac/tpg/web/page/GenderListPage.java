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
import zw.co.hitrac.support.TpgPageParametersUtil;
import zw.co.hitrac.tpg.business.domain.Gender;
import zw.co.hitrac.tpg.web.model.GenderListModel;

/**
 *
 * @author pchikumba
 */
public class GenderListPage extends WebPage{
    public GenderListPage(PageParameters parameters){
        super(parameters);
        
        add(new BookmarkablePageLink("back", HomePage.class));
        add(new BookmarkablePageLink("new", GenderEditPage.class));
        add(new PropertyListView<Gender>("gender", new GenderListModel()) {

            @Override
            protected void populateItem(ListItem<Gender> item) {
                item.add(new Label("gendertype"));

                PageParameters pageParameters = new PageParameters();
                pageParameters.add(TpgPageParametersUtil.ID, item.getModelObject().getId());
                item.add(new BookmarkablePageLink("edit", GenderEditPage.class, pageParameters));

            }

        });

        
        
        
        
    }
    
    
    
    
    
}
