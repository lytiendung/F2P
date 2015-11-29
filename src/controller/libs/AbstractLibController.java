package controller.libs;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import controller.IView;
import model.datatable.AbstractDataTable;
import view.AbstractPanelPopup;

public abstract class AbstractLibController implements ActionListener, MouseListener, IView {
	protected AbstractDataTable model;
	protected AbstractPanelPopup view;

	public AbstractLibController(AbstractDataTable model) {
		this.model = model;
		this.initView();
	}

	protected abstract void initView();

	protected abstract void doAction(ActionEvent e);

	@Override
	public void actionPerformed(ActionEvent e) {
		this.doAction(e);
	}

	@Override
	public Container getView() {
		return this.view;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO implement
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO implement
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO implement
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO implement
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO implement
	}

}
