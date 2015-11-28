package controller;

import java.awt.Container;

import view.MainFrame;

public class MainController implements ViewController {
	private MainFrame view;

	public MainController() {
		this.view = new MainFrame(this);
		this.view.setVisible(true);
	}

	@Override
	public Container getView() {
		return view;
	}

}
