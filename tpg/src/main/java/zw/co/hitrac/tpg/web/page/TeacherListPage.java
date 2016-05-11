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

import zw.co.hitrac.tpg.business.domain.Teacher;
import zw.co.hitrac.tpg.business.service.TeacherService;
import zw.co.hitrac.tpg.web.model.TeacherListModel;

/**
 *
 * @author hitrac
 */
public class TeacherListPage extends WebPage{
    
    @SpringBean
    private TeacherService teacherservice;

    public TeacherListPage(PageParameters parameters) {
        super(parameters);
           add(new BookmarkablePageLink("back", HomePage.class));
        add(new BookmarkablePageLink("new", TeacherEditPage.class));
        
         add(new PropertyListView<Teacher>("teacher", new TeacherListModel()){

            @Override
            protected void populateItem(ListItem<Teacher> li) {
                
                 li.add(new Label("subject"));
                 li.add(new Label("fname"));
                 li.add(new Label("lname"));
                  PageParameters pageParameters = new PageParameters();
                   pageParameters.add(TpgPageParametersUtil.ID, li.getModelObject().getId());
                  li.add(new BookmarkablePageLink("edit", TeacherEditPage.class, pageParameters));
                  
            }
         
         
         
         });
        
    }
}