package view.fragments;

import java.awt.event.MouseEvent;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import org.jdesktop.swingx.JXTable;

import controller.fragments.AbstractFragmentTableController;
import factory.CommandFactory;
import factory.ImageFactory;
import model.datatable.AbstractDataTable;

public abstract class TableFragment {
	protected JXTable table;
	protected JPopupMenu popupMenu;

	public TableFragment(AbstractDataTable model, AbstractFragmentTableController controller) {
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

}
