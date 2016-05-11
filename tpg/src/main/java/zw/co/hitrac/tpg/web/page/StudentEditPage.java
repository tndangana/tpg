/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zw.co.hitrac.tpg.web.page;

import java.time.Period;
import java.util.Date;
import org.apache.wicket.datetime.PatternDateConverter;
import org.apache.wicket.datetime.markup.html.form.DateTextField;
import org.apache.wicket.extensions.yui.calendar.DatePicker;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.ChoiceRenderer;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.RequiredTextField;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.spring.injection.annot.SpringBean;
import zw.co.hitrac.tpg.TpgPageParametersUtil;
import zw.co.hitrac.tpg.business.domain.Gender;
import zw.co.hitrac.tpg.business.domain.Religion;
import zw.co.hitrac.tpg.business.domain.Student;
import zw.co.hitrac.tpg.business.service.StudentService;
import zw.co.hitrac.tpg.web.model.GenderListModel;
import zw.co.hitrac.tpg.web.model.PeriodListModel;
import zw.co.hitrac.tpg.web.model.ReligionListModel;
import zw.co.hitrac.tpg.web.model.StudentModel;

/**
 *
 * @author pchikumba
 */
public class StudentEditPage extends WebPage {

    private StudentModel studentModel;
    @SpringBean
    private StudentService studentService;
    private Date dob;

    public StudentEditPage(PageParameters parameters) {
        super(parameters);
        this.dob = new Date();
        final PropertyModel<Date> dobModel = new PropertyModel<Date>(this, "dob");
        add(new BookmarkablePageLink("back", HomePage.class));
        createProgramModel(parameters);
        add(new FeedbackPanel("feedback"));
        

        Form<Student> form = new Form<Student>("form", new CompoundPropertyModel<Student>(studentModel));
       
        PeriodListModel periodlistmodel=new PeriodListModel();
        ChoiceRenderer<Period> periodChoice = new ChoiceRenderer<Period> ("term","id");
        
        ReligionListModel religionListModel = new ReligionListModel();
        ChoiceRenderer<Religion> relchoiceRenderer = new ChoiceRenderer<Religion>("religiontype","id");
        
        
        GenderListModel genderListModel = new GenderListModel();
       ChoiceRenderer<Gender> choiceRenderer = new ChoiceRenderer<Gender>("gendertype", "id");

        form.add(new RequiredTextField("studentname"));
        form.add(new RequiredTextField("surname"));
     
        
        form.add(new DropDownChoice<Gender>("gender", genderListModel, choiceRenderer));
      
        form.add(new DropDownChoice<Religion>("religion", religionListModel, relchoiceRenderer));
        form.add(new RequiredTextField("residentialaddress"));
        form.add(new RequiredTextField("nextofkin"));
        form.add(new RequiredTextField("relation"));
    
        
        

        form.add(new org.apache.wicket.markup.html.form.Button("submit") {
            @Override
            public void onSubmit() {
                Student student = studentModel.getObject();
                studentService.save(student);
                setResponsePage(StudentListPage.class);
            }
        });

        add(form);

    }

    private void createProgramModel(PageParameters parameters) {
        Long id = TpgPageParametersUtil.extractId(parameters);
        studentModel = new StudentModel(id);
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }
}
