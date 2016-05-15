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
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import zw.co.hitrac.tpg.TpgPageParametersUtil;
import zw.co.hitrac.tpg.business.domain.ResultSheet;
import zw.co.hitrac.tpg.business.domain.Student;
import zw.co.hitrac.tpg.web.model.StudentModel;

/**
 *
 * @author pchikumba
 */
public class StudentProfileViewPage extends WebPage {

    private StudentModel studentModel;

    public StudentProfileViewPage(final PageParameters parameters) {
        super(parameters);
        createStudentModel(parameters);

        setDefaultModel(createCompoundPropertyModel());

      
        add(createFirstNameLabel());
        add(createLastNameLabel());
        add(createResidentialAddressLabel());
        add(createResultSheetListView());

    }
     private Label createFirstNameLabel() {
        Label firstNameLabel = new Label("studentname");
        return firstNameLabel;
    }

      private Label createLastNameLabel() {
        Label firstNameLabel = new Label("surname");
        return firstNameLabel;
    }

       private Label createResidentialAddressLabel() {
        Label firstNameLabel = new Label("residentialaddress");
        return firstNameLabel;
    }


    

    private ListView<ResultSheet> createResultSheetListView() {
        ListView<ResultSheet> listView = new ListView<ResultSheet>("studentresultSheet") {

            @Override
            protected void populateItem(ListItem<ResultSheet> li) {
                li.setModel(new CompoundPropertyModel<ResultSheet>(li.getModel()));
                li.add(new Label("Teacher"));
                
                li.add(new Label("level"));
                li.add(new Label(" period"));
//                li.add(new Label("student"));
              
                li.add(new Label("Subject"));
                li.add(new Label("Actualmark"));
                li.add(new Label(" PossibleMark"));
                
//                   li.add(new Label("Teacher.lname"));
//                 li.add(new Label("level.leveltype"));
//                 li.add(new Label("period.term"));
//                 li.add(new Label("student.studentname"));
//                 li.add(new Label("Subject.subjectname"));
//                 li.add(new Label("Actualmark"));
//                  li.add(new Label("PossibleMark"));
                
                PageParameters pageParameters = new PageParameters();
                pageParameters.add(TpgPageParametersUtil.ID, li.getModelObject().getId());
                li.add(new BookmarkablePageLink("view", StudentViewPage.class, pageParameters));

            }

        };
          return listView;
    }
    


    private void createStudentModel(PageParameters parameters) {
        Long id = TpgPageParametersUtil.extractId(parameters, TpgPageParametersUtil.ID);
        studentModel = new StudentModel(id);
    }

    private IModel<?> createCompoundPropertyModel() {
    CompoundPropertyModel<Student> model = new CompoundPropertyModel<Student>(studentModel);
        return model;
    }

}
