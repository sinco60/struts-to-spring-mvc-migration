package io.levvel.example.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import io.levvel.example.struts.form.LoginForm;

public class LoginAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		LoginForm loginForm = (LoginForm)form;
        
		if(loginForm.getUsername() == null || loginForm.getPassword() == null ||
        !loginForm.getUsername().equalsIgnoreCase("msinclair") || !loginForm.getPassword().equals("password")){
            return mapping.findForward("failure");
        }
        else {
            return mapping.findForward("success");
        }
	}

}
