/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zw.co.hitrac.tpg.web.page;

import org.apache.wicket.authroles.authentication.AuthenticatedWebSession;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.RequiredTextField;
import org.apache.wicket.markup.html.form.StatelessForm;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.util.string.Strings;
import org.springframework.beans.factory.annotation.Required;
import zw.co.hitrac.tpg.web.config.TpgSession;

/**
 *
 * @author g-birds
 */
public class LoginPage extends WebPage {
    
      private String username;
   private String password;

   @Override
   protected void onInitialize() {
      super.onInitialize();

      StatelessForm form = new StatelessForm("form"){
         @Override
         protected void onSubmit() {
            if(Strings.isEmpty(username))
               return;
             System.out.println("authenticating ---------"+ username);
            boolean authResult = TpgSession.get().signIn(username, password);
            //if authentication succeeds redirect user to the requested page
            if(authResult)
               continueToOriginalDestination();
         }
      };

      form.setDefaultModel(new CompoundPropertyModel(this));

      form.add(new RequiredTextField("username"));
      form.add(new PasswordTextField("password"));

      add(form);
   }

}
