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
import zw.co.hitrac.tpg.business.domain.Period;
import zw.co.hitrac.tpg.business.service.PeriodService;
import zw.co.hitrac.tpg.web.model.PeriodModel;

/**
 *
 * @author g-birds
 */
public class PeriodEditPage extends WebPage{
    
    
    private PeriodModel periodmodel;
    @SpringBean
    private PeriodService periodservice;

    public PeriodEditPage(PageParameters parameters) {
        super(parameters);
         createProgramModel(parameters);
        add(new FeedbackPanel("feedback"));
          Form<Period> form = new Form<Period>("form", new CompoundPropertyModel<Period>(periodmodel));
          
          form.add(new RequiredTextField("term"));
          
          form.add(new Button("submit"){
               @Override
            public void onSubmit() {
                Period period = periodmodel.getObject();
                 periodservice.save(period);
                setResponsePage(PeriodListPage.class);
            }
        });
          add(form);
          
          }

    private void createProgramModel(PageParameters parameters) {
        
         Long id = TpgPageParametersUtil.extractId(parameters);
        periodmodel = new PeriodModel(id);
        
        
        
      
    }
       
        
    }


