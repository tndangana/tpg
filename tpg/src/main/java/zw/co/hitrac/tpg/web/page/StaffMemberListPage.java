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
import zw.co.hitrac.tpg.TpgPageParametersUtil;
import zw.co.hitrac.tpg.business.domain.StaffMember;
import zw.co.hitrac.tpg.web.model.StaffMemberListModel;

/**
 *
 * @author g-birds
 */
public class StaffMemberListPage extends WebPage{
    
     public StaffMemberListPage(PageParameters parameters) {
        super(parameters);
       

        add(new BookmarkablePageLink("back", HomePage.class));
        add(new BookmarkablePageLink("new", StaffMemberEditPage.class));
        add(new PropertyListView<StaffMember>("staffmember", new StaffMemberListModel()) {

            @Override
            protected void populateItem(ListItem<StaffMember> item) {
                item.add(new Label("fname"));
                item.add(new Label("lname"));
                item.add(new Label("dob"));
                item.add(new Label("gender"));
               
                item.add(new Label("address"));
                PageParameters pageParameters = new PageParameters();
                pageParameters.add(TpgPageParametersUtil.ID, item.getModelObject().getId());
                item.add(new BookmarkablePageLink("edit", StaffMemberEditPage.class, pageParameters));
            }

        });

    }

}

    

