package controller;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Arrays;

import factory.CommandFactory;
import factory.MessageFactory;
import model.datatable.TreesDataTable;
import model.objs.TreeModel;
import view.PanelLibTrees;

public class LibTreesController implements ActionListener, MouseListener, IView {
	private TreesDataTable model;
	private PanelLibTrees view;

	public LibTreesController(TreesDataTable model) {
		this.model = model;
		this.view = new PanelLibTrees(model, this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		switch (cmd) {
		case CommandFactory.ADD_CMD:
			if (!model.addRow()) {
				// show notify
				MessageFactory.showMessageDialog(MessageFactory.windowForComponent(view),
						"Nhập thiếu trường dữ liệu, vui lòng nhập đầy đủ thông tin", "Cảnh báo lỗi",
						MessageFactory.ERROR_MESSAGE);
			}
			break;
		case CommandFactory.DELETE_CMD:
			int[] rows = view.getSelectedRows();
			testDeleteMethod(rows);

			if (rows.length == 0) {
				MessageFactory.showMessageDialog(MessageFactory.windowForComponent(view),
						"Vui lòng chọn một (hoặc nhiều dòng) cần xóa", "Cảnh báo lỗi", MessageFactory.ERROR_MESSAGE);
				return;
			} else if (MessageFactory.showQuestionDialog(MessageFactory.windowForComponent(view),
					"Bạn có chắc muốn xóa các dòng hiện tại", "Xác nhận",
					MessageFactory.WARNING_MESSAGE) == MessageFactory.OK_OPTION) {
				System.out.println("result of delete action: " + model.deleteRow(rows));
			}
			break;
		case CommandFactory.RELOAD_CMD:
			model.refreshData();
			model.fireTableDataChanged();
			break;
		}
	}

	private void testDeleteMethod(int[] rows) {
		System.out.println("====number of row selected: " + rows.length + "====");
		System.out.println("row index: " + Arrays.toString(rows));
		for (int i : rows) {
			System.out.println(((TreeModel) model.getObjAtRow(i)).getNameVi());
		}
	}

	@Override
	public Container getView() {
		return view;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		if (e.isPopupTrigger()) {
			view.showPopup(e.getComponent(), e.getX(), e.getY());
		}
	}

}
