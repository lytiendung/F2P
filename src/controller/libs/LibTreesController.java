package controller.libs;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.util.Arrays;

import factory.CommandFactory;
import factory.MessageFactory;
import model.datatable.TreesDataTable;
import model.objs.TreeModel;
import view.PanelLibTrees;

public class LibTreesController extends AbstractLibController {

	public LibTreesController(TreesDataTable model) {
		super(model);
	}

	@Override
	protected void doAction(ActionEvent e) {
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
	protected void initView() {
		this.view = new PanelLibTrees((TreesDataTable) model, this);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (e.isPopupTrigger()) {
			view.showPopup(e.getComponent(), e.getX(), e.getY());
		}
	}

}
