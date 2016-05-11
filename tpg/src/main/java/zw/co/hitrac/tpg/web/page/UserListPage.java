package zw.co.hitrac.tpg.web.page;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.PropertyListView;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import zw.co.hitrac.tpg.TpgPageParametersUtil;
import zw.co.hitrac.tpg.business.domain.User;
import zw.co.hitrac.tpg.web.model.UserListModel;

/**
 *
 * @author tonderai ndangana created on 03/05/2016
 * 
 */
public class UserListPage extends WebPage {

    public UserListPage(PageParameters parameters) {
        super(parameters);

        add(new BookmarkablePageLink("back", HomePage.class));
        add(new BookmarkablePageLink("new", UserEditPage.class));
        add(new PropertyListView<User>("user", new UserListModel()) {

            @Override
            protected void populateItem(ListItem<User> item) {
                item.add(new Label("firstname"));
                item.add(new Label("lastname"));
                item.add(new Label("username"));
//                item.add(new Label("password"));
                item.add(createRolesLabel());

                PageParameters pageParameters = new PageParameters();
                pageParameters.add(TpgPageParametersUtil.ID, item.getModelObject().getId());
                item.add(new BookmarkablePageLink("edit", UserEditPage.class, pageParameters));
            }

        });
    }

    private Label createRolesLabel() {
        Label nameLabel = new Label("roles");
        return nameLabel;
    }

}
