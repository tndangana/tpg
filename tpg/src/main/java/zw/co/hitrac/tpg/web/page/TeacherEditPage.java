/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zw.co.hitrac.tpg.web.page;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.ChoiceRenderer;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.RequiredTextField;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.spring.injection.annot.SpringBean;
import zw.co.hitrac.tpg.TpgPageParametersUtil;
import zw.co.hitrac.tpg.business.domain.Level;
import zw.co.hitrac.tpg.business.domain.Period;
import zw.co.hitrac.tpg.business.domain.Subject;

import zw.co.hitrac.tpg.business.domain.Teacher;
import zw.co.hitrac.tpg.business.service.TeacherService;
import zw.co.hitrac.tpg.web.model.PeriodListModel;
import zw.co.hitrac.tpg.web.model.SubjectListModel;
import zw.co.hitrac.tpg.web.model.TeacherModel;

/**
 *
 * @author hitrac
 */
public class TeacherEditPage extends WebPage {

    private TeacherModel teachermodel;

    @SpringBean
    private TeacherService teacherservice;

    public TeacherEditPage(PageParameters parameters) {
        super(parameters);
        createProgramModel(parameters);
        add(new FeedbackPanel("feedback"));
        

        Form<Teacher> form = new Form<Teacher>("form", new CompoundPropertyModel<Teacher>(teachermodel));

        SubjectListModel subjectlistmodel = new SubjectListModel();
        ChoiceRenderer<Subject> subjectChoice = new ChoiceRenderer<Subject>("subjectname", "id");

        form.add(new DropDownChoice<Subject>("subject", subjectlistmodel, subjectChoice));
//         form.add(new RequiredTextField("subject"));
        form.add(new RequiredTextField("fname"));
        form.add(new RequiredTextField("lname"));
        form.add(new BookmarkablePageLink("back", TeacherListPage.class));

        form.add(new Button("submit") {
            @Override
            public void onSubmit() {
                Teacher teacher = teachermodel.getObject();
                teacherservice.save(teacher);
                setResponsePage(TeacherListPage.class);
            }
        });
        add(form);
    }

    private void createProgramModel(PageParameters parameters) {
        Long id = TpgPageParametersUtil.extractId(parameters);
        teachermodel = new TeacherModel(id);
    }

}
