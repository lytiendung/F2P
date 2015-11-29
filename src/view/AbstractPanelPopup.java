package view;

import java.awt.Component;

import javax.swing.JPanel;
import javax.swing.JPopupMenu;

import org.jdesktop.swingx.JXTable;

import controller.libs.AbstractLibController;
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

	protected abstract void createPopupMenu(AbstractLibController controller);

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
}
