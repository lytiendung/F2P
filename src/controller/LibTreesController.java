package controller;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import factory.CommandFactory;
import factory.MessageFactory;
import model.LibTreesModel;
import model.TreeModel;
import view.PanelLibTrees;

public class LibTreesController implements ActionListener, ViewController {
	private LibTreesModel model;
	private PanelLibTrees view;

	public LibTreesController(LibTreesModel model) {
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

}
