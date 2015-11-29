package controller.libs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import factory.CommandFactory;
import factory.MessageFactory;
import model.datatable.SolutionsDataTable;
import view.PanelLibSolutions;

public class LibSolutionsController implements ActionListener {
	private SolutionsDataTable model;
	private PanelLibSolutions view;

	public LibSolutionsController(SolutionsDataTable model) {
		this.model = model;
		this.view = new PanelLibSolutions(model, this);
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
			System.out.println("number of row selected: " + rows.length);

			if (rows.length == 0) {
				MessageFactory.showMessageDialog(MessageFactory.windowForComponent(view),
						"Vui lòng chọn một (hoặc nhiều dòng) cần xóa", "Cảnh báo lỗi", MessageFactory.ERROR_MESSAGE);
				return;
			} else if (rows.length == model.getRowCount()) {
				System.out.println("result of clear action: " + model.clearData());
			} else {
				System.out.println("result of delete action: " + model.deleteRow(rows));
			}
			break;
		}
	}

	public JPanel getView() {
		return view;
	}

}
