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
import zw.co.hitrac.tpg.business.domain.ResultSheet;
import zw.co.hitrac.tpg.business.service.ResultSheetService;
import zw.co.hitrac.tpg.web.model.ResultSheetListModel;

/**
 *
 * @author hitrac
 */
public class ResultSheetListPage extends WebPage {
    @SpringBean
    private ResultSheetService resultservice;

    public ResultSheetListPage(PageParameters parameters) {
        super(parameters);
        add(new BookmarkablePageLink("new", ResultSheetEditPage.class));
         add(new PropertyListView<ResultSheet>("resultsheet", new ResultSheetListModel()){

          

            @Override
            protected void populateItem(ListItem<ResultSheet> li) {
                
                 li.add(new Label("level"));
                 li.add(new Label("period"));
                 li.add(new Label("studentname"));
                 li.add(new Label("Subject"));
                 li.add(new Label("Actualmark"));
                  li.add(new Label("PossibleMark"));
                 PageParameters pageParameters = new PageParameters();
                 pageParameters.add(TpgPageParametersUtil.ID, li.getModelObject().getId());
                  li.add(new BookmarkablePageLink("edit", ResultSheetEditPage.class, pageParameters));
                
            }
         
         
         
         });
        
    }
    
    
    
}