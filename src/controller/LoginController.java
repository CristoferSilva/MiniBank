package controller;

import javax.swing.JFrame;

import view.LoginView;

public class LoginController {

	public static void showLoginWindow(JFrame jFrame) {
		jFrame.setVisible(false);
		LoginView lv = new LoginView();
		lv.getFrame().setVisible(true);
	}
}
