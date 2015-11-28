package controller;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.SwingUtilities;

import org.busydialog.ui.BusyDialog;

import factory.CommandFactory;
import model.objs.LoginModel;
import view.PanelLogin;
import view.MainFrame;

public class LoginController implements ActionListener, FocusListener, IView {
	private LoginModel model;
	private PanelLogin view;

	public LoginController(LoginModel model) {
		this.model = model;
		this.view = new PanelLogin(this);
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
						MainFrame frame = (MainFrame) SwingUtilities.getWindowAncestor(view);
						frame.doChangeDisplay(CommandFactory.PANEL_WORKSPACE);
						frame.doVisibleMenuBar(true);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
				}
			};
			BusyDialog.showBusyDialog(view, "Connecting to database...", 450, 225, action, "");
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
