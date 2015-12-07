package controller;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.MainFrame;

public class MainController implements IView, ActionListener {
	private MainFrame view;

	public MainController() {
		this.view = new MainFrame(this);
		this.view.setVisible(true);
	}

	@Override
	public Container getView() {
		return view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		view.doShowWorkspace(cmd);
	}

}
