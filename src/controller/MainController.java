package controller;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import factory.CommandFactory;
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
		switch (cmd) {
		case CommandFactory.TREE_LIB_CMD:
			view.doShowWorkspace(CommandFactory.PANEL_LIB_TREE);
			break;
		case CommandFactory.ANIMAL_LIB_CMD:
			view.doShowWorkspace(CommandFactory.PANEL_LIB_ANIMAL);
			break;
		case CommandFactory.SOLUTION_LIB_CMD:
			view.doShowWorkspace(CommandFactory.PANEL_LIB_SOLUTION);
			break;
		}
	}

}
