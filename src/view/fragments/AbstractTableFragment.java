package view.fragments;

import java.awt.event.MouseEvent;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import org.jdesktop.swingx.JXTable;

import controller.fragments.AbstractFragmentTableController;
import factory.CommandFactory;
import factory.ImageFactory;
import model.datatable.AbstractDataTable;

public abstract class AbstractTableFragment {
	protected JXTable table;
	protected JPopupMenu popupMenu;

	public AbstractTableFragment(AbstractDataTable model, AbstractFragmentTableController controller) {
		initPopupMenu(controller);
		initTable(model, controller);
	}

	public abstract void initTable(AbstractDataTable model, AbstractFragmentTableController controller);

	public void initPopupMenu(AbstractFragmentTableController controller) {
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
	}

	public void showPopup(MouseEvent e) {
		if (e.isPopupTrigger()) {
			popupMenu.show(e.getComponent(), e.getX(), e.getY());
		}
	}

	public JXTable getTableView() {
		return this.table;
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
