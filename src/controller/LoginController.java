package controller;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.SwingUtilities;

import org.busydialog.ui.BusyDialog;

import factory.CommandFactory;
import model.LoginModel;
import view.LoginPanel;
import view.MainFrame;

public class LoginController implements ActionListener, FocusListener, ViewController {
	private LoginModel model;
	private LoginPanel view;

	public LoginController(LoginModel model) {
		this.model = model;
		this.view = new LoginPanel(this);
	}

	@Override
	public void focusGained(FocusEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void focusLost(FocusEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		switch (cmd) {
		case CommandFactory.LOGIN_CMD:
			ActionListener action = new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						Thread.sleep(1500);
						((MainFrame) SwingUtilities.getWindowAncestor(view))
								.doChangeDisplay(CommandFactory.PANEL_WORKSPACE);
						;
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
				}
			};
			BusyDialog.showBusyDialog(view, "Ket noi database", 450, 225, action, "");
			break;
		case CommandFactory.EXIT_CMD:
			model.doExit(getView());
			break;
		}
	}

	@Override
	public Container getView() {
		return this.view;
	}

}