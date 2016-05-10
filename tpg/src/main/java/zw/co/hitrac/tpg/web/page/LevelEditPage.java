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
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.spring.injection.annot.SpringBean;
import zw.co.hitrac.support.TpgPageParametersUtil;
import zw.co.hitrac.tpg.business.domain.Level;
import zw.co.hitrac.tpg.business.service.LevelService;
import zw.co.hitrac.tpg.web.model.LevelModel;

/**
 *
 * @author hitrac
 */
public class LevelEditPage extends WebPage {
    
    private LevelModel levelmodel;
    @SpringBean
    private LevelService levelservice;

    public LevelEditPage(PageParameters parameters) {
        super(parameters);
         createProgramModel(parameters);
        add(new FeedbackPanel("feedback"));
          Form<Level> form = new Form<Level>("form", new CompoundPropertyModel<Level>(levelmodel));
          
          form.add(new RequiredTextField("leveltype"));
          
          form.add(new Button("submitt"){
               @Override
            public void onSubmit() {
                Level level = levelmodel.getObject();
                 levelservice.save(level);
                setResponsePage(LevelListPage.class);
            }
        });
          add(form);
          
          }

    private void createProgramModel(PageParameters parameters) {
        
         Long id = TpgPageParametersUtil.extractId(parameters);
        levelmodel = new LevelModel(id);
        
        
        
      
    }
       
        
    }


    
    
    
    

