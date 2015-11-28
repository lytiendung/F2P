package model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public abstract class AbstractDataTable extends AbstractTableModel {
	private static final long serialVersionUID = 1L;
	protected List<Object> data;
	protected ArrayList<String> columnIdentifiers;

	public AbstractDataTable() {
		this.data = new ArrayList<>();
		this.columnIdentifiers = new ArrayList<>();
		loadData();
	}

	@Override
	public abstract Object getValueAt(int rowIndex, int columnIndex);

	@Override
	public abstract void setValueAt(Object aValue, int rowIndex, int columnIndex);

	@Override
	public abstract Class<?> getColumnClass(int columnIndex);

	@Override
	public abstract boolean isCellEditable(int rowIndex, int columnIndex);

	@Override
	public int getColumnCount() {
		return columnIdentifiers.size();
	}

	@Override
	public String getColumnName(int column) {
		return columnIdentifiers.get(column);
	}

	@Override
	public int getRowCount() {
		return data.size();
	}

	public boolean isEmpty() {
		return getRowCount() == 0;
	}

	public abstract void loadData();

	public abstract boolean clearData();

	public void refreshData() {
		loadData();
		fireTableDataChanged();
	}

	public boolean hasNullRow() {
		return (!isEmpty()) ? ((AbstracModelObject) data.get(this.getRowCount() - 1)).isEmptyObj() : false;
	}

	public abstract boolean addRow();

	public abstract boolean deleteRow(int[] rows);

	public abstract boolean saveOrUpdateRow(int row);

	public abstract void autoSave(int row);

	public Object getObjAtRow(int row) {
		return data.get(row);
	}

}
