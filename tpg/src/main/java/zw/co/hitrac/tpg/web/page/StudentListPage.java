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
import static sun.misc.ClassFileTransformer.add;
import zw.co.hitrac.tpg.TpgPageParametersUtil;
import zw.co.hitrac.tpg.business.domain.Student;
import zw.co.hitrac.tpg.web.model.StudentListModel;

/**
 *
 * @author pchikumba
 */
public class StudentListPage extends WebPage {

    public StudentListPage(PageParameters parameters) {
        super(parameters);
       

        add(new BookmarkablePageLink("back", HomePage.class));
        add(new BookmarkablePageLink("new", StudentEditPage.class));
        add(new PropertyListView<Student>("student", new StudentListModel()) {

            @Override
            protected void populateItem(ListItem<Student> item) {
                item.add(new Label("studentname"));
                item.add(new Label("surname"));
                item.add(new Label("dob"));
                item.add(new Label("gender.gendertype"));
                item.add(new Label("relation"));
                item.add(new Label("residentialaddress"));
                item.add(new Label("religion.religiontype"));
               item.add(new Label("nextofkin"));

                PageParameters pageParameters = new PageParameters();
                pageParameters.add(TpgPageParametersUtil.ID, item.getModelObject().getId());
                item.add(new BookmarkablePageLink("edit", StudentEditPage.class, pageParameters));
            }

        });

    }

}
