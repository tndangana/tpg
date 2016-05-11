
package zw.co.hitrac.tpg.web.page;

import java.util.Arrays;
import java.util.List;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.CheckBoxMultipleChoice;
import org.apache.wicket.markup.html.form.ChoiceRenderer;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.RequiredTextField;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.spring.injection.annot.SpringBean;
import zw.co.hitrac.tpg.TpgPageParametersUtil;
import zw.co.hitrac.tpg.business.domain.Role;
import zw.co.hitrac.tpg.business.domain.User;
import zw.co.hitrac.tpg.business.service.UserService;
import zw.co.hitrac.tpg.web.model.UserModel;

/**
 *
 * @author tonderai ndangana
 * 03/05/2016
 */
public class UserEditPage extends WebPage{
    
    
    private UserModel userModel;
    
    @SpringBean
    private UserService userService;

    public UserEditPage(PageParameters parameters) {
        super(parameters);
        createUserModel(parameters);
        add(new FeedbackPanel("feedback"));
        add(new BookmarkablePageLink("back", HomePage.class));
        Form<User> form = new Form<User>("form", new CompoundPropertyModel<User>(userModel));;
        
        form.add(new RequiredTextField("firstname"));
        form.add(new RequiredTextField("lastname"));
        form.add(new RequiredTextField("username"));
        form.add(new RequiredTextField("password"));
        form.add(roleCheckBox());
        
        form.add(new org.apache.wicket.markup.html.form.Button("submit") {
            @Override
            public void onSubmit() {
                User user = userModel.getObject();
                userService.save(user);
                setResponsePage(UserListPage.class);
            }
        });
        add(form);
        
    }

     private CheckBoxMultipleChoice<Role> roleCheckBox() {
        List<Role> roleList = Arrays.asList(Role.values());
        ChoiceRenderer<Role> choiceRenderer = new ChoiceRenderer<Role>("roleName");
        CheckBoxMultipleChoice<Role> roleChoice = new CheckBoxMultipleChoice("roles",
                roleList, choiceRenderer);

        return roleChoice;
     }
        
    private void createUserModel(PageParameters parameters) {
        Long id = TpgPageParametersUtil.extractId(parameters);
        userModel = new UserModel(id);
    }
    
    
    
}
