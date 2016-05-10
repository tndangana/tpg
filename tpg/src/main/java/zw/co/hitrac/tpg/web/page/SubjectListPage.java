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
import zw.co.hitrac.tpg.business.domain.Subject;
import zw.co.hitrac.tpg.web.model.SubjectListModel;

/**
 *
 * @author g-birds
 */
public class SubjectListPage extends WebPage{
    
          public SubjectListPage(PageParameters parameters) {
        super(parameters);
        add(new BookmarkablePageLink("back", HomePage.class));
        add(new BookmarkablePageLink("new", SubjectEditPage.class));
        add(new PropertyListView<Subject>("subject", new SubjectListModel()) {

            @Override
            protected void populateItem(ListItem<Subject> item) {
                item.add(new Label("subjectname"));

                PageParameters pageParameters = new PageParameters();
                pageParameters.add(TpgPageParametersUtil.ID, item.getModelObject().getId());
                item.add(new BookmarkablePageLink("edit", SubjectEditPage.class, pageParameters));

            }

        });

    }

}
    

