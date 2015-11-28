package controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import org.jdesktop.swingx.JXTable;

import factory.CommandFactory;

public class TableHeaderControlPopup extends MouseAdapter implements ActionListener {
	private JXTable table;
	private JPopupMenu popupMenu;
	private JCheckBoxMenuItem check;
	private int columnIndex;

	public TableHeaderControlPopup(JXTable table) {
		this.table = table;
		createPopupMenu();
	}

	private void createPopupMenu() {
		popupMenu = new JPopupMenu();

		check = new JCheckBoxMenuItem("Mở rộng theo chiều ngang");
		check.setSelected(table.isHorizontalScrollEnabled());
		check.setActionCommand(CommandFactory.HOR_SCROLL_CMD);
		check.addActionListener(this);
		popupMenu.add(check);

		popupMenu.addSeparator();

		JMenuItem mntmngXut = new JMenuItem("Thu gọn cột đang chọn");
		mntmngXut.setActionCommand(CommandFactory.PACK_CURRENT_COL_CMD);
		mntmngXut.addActionListener(this);
		popupMenu.add(mntmngXut);

		JMenuItem mntmThot = new JMenuItem("Thu gọn tất cả các cột");
		mntmThot.setActionCommand(CommandFactory.PACK_ALL_COL_CMD);
		mntmThot.addActionListener(this);
		popupMenu.add(mntmThot);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		super.mouseReleased(e);
		if (e.isPopupTrigger()) {
			this.columnIndex = table.getColumnModel().getColumnIndexAtX(e.getX());
			popupMenu.show((Component) e.getSource(), e.getX(), e.getY());
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		switch (cmd) {
		case CommandFactory.HOR_SCROLL_CMD:
			table.setHorizontalScrollEnabled(check.isSelected());
			break;
		case CommandFactory.PACK_CURRENT_COL_CMD:
			table.packColumn(columnIndex, table.getColumnMargin());
			break;
		case CommandFactory.PACK_ALL_COL_CMD:
			table.packAll();
			break;
		}
	}

}
