package controller.violation;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import controller.IView;
import factory.CommandFactory;
import model.datatable.AbstractDataTable;
import view.fragments.TableFragment;

public abstract class AbstractFragmentTableController implements ActionListener, MouseListener, IView {
	protected TableFragment view;
	protected AbstractDataTable model;

	public AbstractFragmentTableController(AbstractDataTable model) {
		this.model = model;
		initView();
	}

	protected abstract void initView();

	protected void doAction(ActionEvent e) {
		String cmd = e.getActionCommand();
		switch (cmd) {
		case CommandFactory.ADD_CMD:
			System.out.println("action add");
			break;
		case CommandFactory.DELETE_CMD:
			System.out.println("action delete");
			break;
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		view.showPopup(e);
	}

	@Override
	public Container getView() {
		return view.getTableView();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		doAction(e);
	}

}
