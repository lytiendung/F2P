package view;

import java.awt.Component;

import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

import org.jdesktop.swingx.JXTable;

import controller.libs.AbstractLibController;
import factory.CommandFactory;
import factory.ImageFactory;
import model.datatable.AbstractDataTable;

public abstract class AbstractPanelPopup extends JPanel {
	private static final long serialVersionUID = -2454673906132507773L;
	protected JXTable table;
	protected JPopupMenu popupMenu;

	public AbstractPanelPopup(AbstractDataTable model, AbstractLibController controller) {
		createPopupMenu(controller);
		init(model, controller);
	}

	protected abstract void init(AbstractDataTable model, AbstractLibController controller);

	protected void createPopupMenu(AbstractLibController controller) {
		popupMenu = new JPopupMenu();

		JMenuItem mntmThmTiKhon = new JMenuItem("Thêm dòng mới");
		mntmThmTiKhon.setIcon(ImageFactory.getIcon(ImageFactory.NEW_ICON));
		mntmThmTiKhon.setActionCommand(CommandFactory.ADD_CMD);
		mntmThmTiKhon.addActionListener(controller);
		popupMenu.add(mntmThmTiKhon);

		popupMenu.addSeparator();

		JMenuItem mnNotify = new JMenuItem("Xóa dòng đã chọn");
		mnNotify.setIcon(ImageFactory.getIcon(ImageFactory.DELETE_ICON));
		mnNotify.setActionCommand(CommandFactory.DELETE_CMD);
		mnNotify.addActionListener(controller);
		popupMenu.add(mnNotify);

		JMenuItem mnDel = new JMenuItem("Tải lại dữ liệu");
		mnDel.setIcon(ImageFactory.getIcon(ImageFactory.REFRESH_ICON));
		mnDel.setActionCommand(CommandFactory.RELOAD_CMD);
		mnDel.addActionListener(controller);
		popupMenu.add(mnDel);
	}

	public void showPopup(Component component, int x, int y) {
		popupMenu.show(component, x, y);
	}

	public int[] getSelectedRows() {
		int[] selectedRow = table.getSelectedRows();
		int[] realRow = new int[table.getSelectedRowCount()];
		for (int i = 0; i < realRow.length; i++) {
			realRow[i] = table.convertRowIndexToModel(selectedRow[i]);
		}
		return realRow;
	}

	public void changeSelection(int rowIndex) {
		rowIndex = table.convertRowIndexToView(rowIndex);
		table.changeSelection(rowIndex, 0, false, false);
	}

	public void refreshTable() {
		table.resetSortOrder();
		table.changeSelection(0, 0, false, false);
	}
}
