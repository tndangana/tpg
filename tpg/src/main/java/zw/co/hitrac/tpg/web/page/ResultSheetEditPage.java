/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zw.co.hitrac.tpg.web.page;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.spring.injection.annot.SpringBean;
import zw.co.hitrac.tpg.business.service.ResultSheetService;
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
        
        
        
        
    }

    private void createProgramModel(PageParameters parameters) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
