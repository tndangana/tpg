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
import zw.co.hitrac.tpg.business.domain.ResultSheet;
import zw.co.hitrac.tpg.business.service.ResultSheetService;
import zw.co.hitrac.tpg.web.model.LevelModel;
import zw.co.hitrac.tpg.web.model.ResultSheetModel;



/**
 *
 * @author hitrac
 */
public class ResultSheetEditPage extends WebPage {
    
    @SpringBean
    private ResultSheetService resultsheetservice;
    private ResultSheetModel resultmodel;

    public ResultSheetEditPage(PageParameters parameters) {
        super(parameters);
           createProgramModel(parameters);
        add(new FeedbackPanel("feedback"));
        add(new BookmarkablePageLink("back", HomePage.class));
        
        
        
         Form<ResultSheet> form = new Form<ResultSheet>("form", new CompoundPropertyModel<ResultSheet>(resultmodel));
          
       
form.add(new RequiredTextField("level"));
form.add(new RequiredTextField("period"));
form.add(new RequiredTextField("studentname"));
form.add(new RequiredTextField("Subject"));
form.add(new RequiredTextField("Actualmark"));
form.add(new RequiredTextField("PossibleMark"));
          
          form.add(new Button("submitt"){
               @Override
            public void onSubmit() {
                ResultSheet resultsheet = resultmodel.getObject();
                resultsheetservice.save(resultsheet);
                setResponsePage(ResultSheetListPage.class);
            }
        });
          add(form);
          
          }

    private void createProgramModel(PageParameters parameters) {
     Long id = TpgPageParametersUtil.extractId(parameters);
        resultmodel = new ResultSheetModel(id);
    }
        
        
    }

   
    
    

