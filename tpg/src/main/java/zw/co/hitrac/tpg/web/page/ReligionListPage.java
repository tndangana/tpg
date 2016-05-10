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
import zw.co.hitrac.tpg.business.domain.Religion;
import zw.co.hitrac.tpg.web.model.ReligionListModel;


/**
 *
 * @author pchikumba
 */
public class ReligionListPage extends WebPage {

    public ReligionListPage(PageParameters parameters) {
        super(parameters);
        add(new BookmarkablePageLink("back", HomePage.class));
        add(new BookmarkablePageLink("new", ReligionEditPage.class));
        add(new PropertyListView<Religion>("religion", new ReligionListModel()) {

            @Override
            protected void populateItem(ListItem<Religion> item) {
                item.add(new Label("religiontype"));

                PageParameters pageParameters = new PageParameters();
                pageParameters.add(TpgPageParametersUtil.ID, item.getModelObject().getId());
                item.add(new BookmarkablePageLink("edit", ReligionEditPage.class, pageParameters));
            }

        });

    }

}
