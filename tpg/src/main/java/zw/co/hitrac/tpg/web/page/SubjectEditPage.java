/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zw.co.hitrac.tpg.web.page;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.RequiredTextField;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.spring.injection.annot.SpringBean;
import zw.co.hitrac.tpg.TpgPageParametersUtil;
import zw.co.hitrac.tpg.business.domain.Subject;
import zw.co.hitrac.tpg.business.service.SubjectService;
import zw.co.hitrac.tpg.web.model.SubjectModel;

/**
 *
 * @author g-birds
 */
public class SubjectEditPage extends WebPage{
    
    
    private SubjectModel subjectmodel;
    @SpringBean
    private SubjectService subjectservice;

    public SubjectEditPage(PageParameters parameters) {
        super(parameters);
         createProgramModel(parameters);
        add(new FeedbackPanel("feedback"));
        add(new BookmarkablePageLink("back", HomePage.class));
          Form<Subject> form = new Form<Subject>("form", new CompoundPropertyModel<Subject>(subjectmodel));
          
          form.add(new RequiredTextField("leveltype"));
          
          form.add(new Button("submit"){
               @Override
            public void onSubmit() {
                Subject subject = subjectmodel.getObject();
                 subjectservice.save(subject);
                setResponsePage(SubjectListPage.class);
            }
        });
          add(form);
          
          }

    private void createProgramModel(PageParameters parameters) {
        
         Long id = TpgPageParametersUtil.extractId(parameters);
        subjectmodel = new SubjectModel(id);
        
        
        
      
    }
       
        
    }

    

