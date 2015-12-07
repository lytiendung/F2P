package controller.fragments;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.SwingUtilities;

import controller.IView;
import factory.CommandFactory;
import factory.MessageFactory;
import model.datatable.AbstractDataTable;
import view.fragments.AbstractTableFragment;

public abstract class AbstractFragmentTableController implements ActionListener, MouseListener, IView {
	protected AbstractTableFragment view;
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
			if (model.hasNullRow()) {
				MessageFactory.showMessageDialog(SwingUtilities.getWindowAncestor(getView()),
						"Nhập hoàn tất dữ liệu trên dòng hiện tại để thêm dòng mới", "Thông báo",
						MessageFactory.WARNING_MESSAGE);
			} else {
				model.addRow();
			}
			break;
		case CommandFactory.DELETE_CMD:
			System.out.println("action delete");
			int[] rows = view.getSelectedRows();
			System.out.println("number of row selected: " + rows.length);

			if (rows.length == 0) {
				MessageFactory.showMessageDialog(MessageFactory.windowForComponent(getView()),
						"Vui lòng chọn một (hoặc nhiều dòng) cần xóa", "Thông báo", MessageFactory.ERROR_MESSAGE);
				return;
			} else {
				if ((MessageFactory.showQuestionDialog(MessageFactory.windowForComponent(getView()),
						"Bạn có chắc muốn xóa dữ liệu này (Không thể hoàn tác)?", "Cảnh báo",
						MessageFactory.WARNING_MESSAGE)) == MessageFactory.OK_OPTION) {
					System.out.println("result of delete action: " + model.deleteRow(rows));
					model.addRow();
				}
			}
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
