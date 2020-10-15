package com.nls.security.app.controller;

import org.springframework.util.StringUtils;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zkplus.spring.DelegatingVariableResolver;
import org.zkoss.zul.Button;
import org.zkoss.zul.Textbox;

import com.nls.security.app.model.User;
import com.nls.security.app.service.UserService;

@VariableResolver(DelegatingVariableResolver.class)
public class LoginController extends SelectorComposer<Component> {
	
	@WireVariable
	UserService userService;
	@Wire
	private Textbox txtUsername;
	@Wire
	private Textbox txtPassword;
	@Wire
	private Button btnLogin;

	@Override
	public void doAfterCompose(Component comp) throws Exception {
		// TODO Auto-generated method stub
		super.doAfterCompose(comp);
	}

	@Listen("onClick=#btnSubmit")
	public void OkClick() {
		if (!validate())
			return;
		

		userService = new UserService();
		String username = txtUsername.getValue();
		String password = txtPassword.getValue();
		User user = userService.login(username, password);

		if (user == null) {
			Clients.showNotification("User not found", "error", null, null, 0);
			return;
		}
		
		
		Clients.showNotification("Hello World : "+user.getFullname(), "info", null, null, 0);

		Sessions.getCurrent().setAttribute("user", user);
//		Executions.sendRedirect("/listmenuPage");

	}

	private void bindModel() {
		// TODO Auto-generated method stub
		txtPassword.setText("");
		txtUsername.setText("");
	}

	private boolean validate() {

		if (StringUtils.isEmpty(txtUsername.getValue())) {
			Clients.showNotification("username is require", "error", null, null, 0);
			return false;

		}
		if (StringUtils.isEmpty(txtPassword.getValue())) {
			Clients.showNotification("Password is require", "error", null, null, 0);
			return false;
		}

		return true;
	}

}