/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zw.co.hitrac.tpg.web.page;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.CheckBox;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.RequiredTextField;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.spring.injection.annot.SpringBean;
import zw.co.hitrac.tpg.TpgPageParametersUtil;
import zw.co.hitrac.tpg.business.domain.Gender;
import zw.co.hitrac.tpg.business.service.GenderService;
import zw.co.hitrac.tpg.web.model.GenderModel;

/**
 *
 * @author pchikumba
 */
public class GenderEditPage extends WebPage{
    
    private GenderModel genderModel;

    @SpringBean
    private GenderService genderService;

    public GenderEditPage(PageParameters parameters) {
        super(parameters);
        createGenderModel(parameters);
        add(new FeedbackPanel("feedback"));
       add(new BookmarkablePageLink("back", GenderListPage.class));

        Form<Gender> form = new Form<Gender>("form", new CompoundPropertyModel<Gender>(genderModel));;
        form.add(new RequiredTextField("gendertype"));
        form.add(new CheckBox("retired"));
        
       
        
        
        

        form.add(new org.apache.wicket.markup.html.form.Button("submit") {
            @Override
            public void onSubmit() {
                Gender gender = genderModel.getObject();
                genderService.save(gender);
                setResponsePage(GenderListPage.class);
            }
        });
        add(form);

    }

    private void createGenderModel(PageParameters parameters) {
        Long id = TpgPageParametersUtil.extractId(parameters);
        genderModel = new GenderModel(id);

    }

    
    
    
    
}
