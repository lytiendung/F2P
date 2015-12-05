package controller.libs;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import controller.IView;
import factory.CommandFactory;
import factory.MessageFactory;
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

	protected void doAction(ActionEvent e) {
		String cmd = e.getActionCommand();
		switch (cmd) {
		case CommandFactory.ADD_CMD:
			if (!model.addRow()) {
				// show notify
				MessageFactory.showMessageDialog(MessageFactory.windowForComponent(view),
						"Nhập thiếu trường dữ liệu, vui lòng nhập đầy đủ thông tin", "Cảnh báo lỗi",
						MessageFactory.ERROR_MESSAGE);
			} else
				view.changeSelection(model.getRowCount() - 1);
			break;
		case CommandFactory.DELETE_CMD:
			int[] rows = view.getSelectedRows();
			System.out.println("number of row selected: " + rows.length);

			if (rows.length == 0) {
				MessageFactory.showMessageDialog(MessageFactory.windowForComponent(view),
						"Vui lòng chọn một (hoặc nhiều dòng) cần xóa", "Cảnh báo lỗi", MessageFactory.ERROR_MESSAGE);
				return;
			} else if (rows.length == model.getRowCount()) {
				if ((MessageFactory.showQuestionDialog(MessageFactory.windowForComponent(view),
						"Bạn có chắc muốn xóa dữ liệu này (Không thể hoàn tác)?", "Cảnh báo",
						MessageFactory.WARNING_MESSAGE)) == MessageFactory.OK_OPTION) {
					System.out.println("result of clear action: " + model.clearData());
				}
			} else {
				if ((MessageFactory.showQuestionDialog(MessageFactory.windowForComponent(view),
						"Bạn có chắc muốn xóa dữ liệu này (Không thể hoàn tác)?", "Cảnh báo",
						MessageFactory.WARNING_MESSAGE)) == MessageFactory.OK_OPTION) {
					System.out.println("result of delete action: " + model.deleteRow(rows));
				}
			}
			break;
		case CommandFactory.RELOAD_CMD:
			model.refreshData();
			view.refreshTable();
			break;
		}
	}

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
		if (e.isPopupTrigger()) {
			view.showPopup(e.getComponent(), e.getX(), e.getY());
		}
	}

}
