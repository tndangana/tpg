/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zw.co.hitrac.tpg.web.page;

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
import zw.co.hitrac.tpg.business.domain.StaffMember;
import zw.co.hitrac.tpg.business.service.StaffMemberService;
import zw.co.hitrac.tpg.web.model.GenderListModel;
import zw.co.hitrac.tpg.web.model.StaffMemberModel;
import zw.co.hitrac.tpg.web.model.StudentModel;

/**
 *
 * @author g-birds
 */
public class StaffMemberEditPage extends WebPage{
    
    
    
    private StaffMemberModel staffMemberModel;
    @SpringBean
    private StaffMemberService staffMemberService;
    private Date dob;

    public StaffMemberEditPage(PageParameters parameters) {
        super(parameters);
        this.dob = new Date();
        final PropertyModel<Date> dobModel = new PropertyModel<Date>(this, "dob");
        add(new BookmarkablePageLink("back", HomePage.class));
        createProgramModel(parameters);
        add(new FeedbackPanel("feedback"));
        

        Form<StaffMember> form = new Form<StaffMember>("form", new CompoundPropertyModel<StaffMember>(staffMemberModel));
      
        GenderListModel genderListModel = new GenderListModel();
       ChoiceRenderer<Gender> choiceRenderer = new ChoiceRenderer<Gender>("gendertype", "id");

        form.add(new RequiredTextField("fname"));
        form.add(new RequiredTextField("lname"));
        form.add(new DateTextField("dob", dobModel, new PatternDateConverter("dd/MM/yy", true)).add(new DatePicker()));
        
        form.add(new DropDownChoice<Gender>("gender", genderListModel, choiceRenderer));
        form.add(new RequiredTextField("address"));
       
    
        
        

        form.add(new org.apache.wicket.markup.html.form.Button("submit") {
            @Override
            public void onSubmit() {
                StaffMember staffMember = staffMemberModel.getObject();
                staffMemberService.save(staffMember);
                setResponsePage(StaffMemberListPage.class);
            }
        });

        add(form);

    }

    private void createProgramModel(PageParameters parameters) {
        Long id = TpgPageParametersUtil.extractId(parameters);
        staffMemberModel = new StaffMemberModel(id);
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }
}


    

