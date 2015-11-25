package model;

import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.table.AbstractTableModel;

import dao.LibDao;

public class LibTreesModel extends AbstractTableModel implements DataTableInterface {
	private static final long serialVersionUID = -1841929008517561740L;
	private ArrayList<TreeModel> data;
	private ArrayList<String> columnIdentifiers;

	public LibTreesModel() {
		this.columnIdentifiers = new ArrayList<String>(
				Arrays.asList("Tên (vi)", "Tên (en)", "Tên (Latinh)", "Họ", "Quý hiếm"));
		refreshData();
	}

	@Override
	public int getColumnCount() {
		return columnIdentifiers.size();
	}

	@Override
	public int getRowCount() {
		return data.size();
	}

	@Override
	public String getColumnName(int column) {
		return columnIdentifiers.get(column);
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Object val = null;
		switch (columnIndex) {
		case 0: // name vi
			val = data.get(rowIndex).getNameVi();
			break;
		case 1: // name en
			val = data.get(rowIndex).getNameEn();
			break;
		case 2: // name latinh
			val = data.get(rowIndex).getNameLatinh();
			break;
		case 3: // last name
			val = data.get(rowIndex).getLastname();
			break;
		default: // rare
			val = data.get(rowIndex).getRare();
			break;
		}

		return val;
	}

	@Override
	public boolean isEmpty() {
		return getRowCount() == 0;
	}

	@Override
	public boolean clearData() {
		if (!isEmpty())
			// clear database
			if (LibDao.clearTableTree())
				// clear table data
				data.clear();
			else {
				refreshData();
				return false;
			}

		fireTableDataChanged();
		return true;
	}

	@Override
	public void refreshData() {
		this.data = LibDao.loadLibTrees();
	}

	@Override
	public boolean hasNullRow() {
		return data.get(this.getRowCount() - 1).isEmptyObj();
	}

	@Override
	public boolean addRow() {
		if (hasNullRow())
			return false;
		else {
			data.add(new TreeModel());
			fireTableDataChanged();
			return true;
		}
	}

	@Override
	public boolean deleteRow(int[] rows) {
		boolean result = false;
		if (LibDao.deleteRecordTreeTable(rowListToIdList(rows))) {
			for (int i : rows)
				data.remove(i);

			result = true;
		} else {
			refreshData();
			result = false;
		}
		fireTableDataChanged();
		return result;
	}

	@Override
	public boolean saveOrUpdateRow(int row) {
		if (data.get(row).isEmptyObj())
			return false;
		else
			return LibDao.saveOrUpdateTree(data.get(row));
	}

	@Override
	public Object getObjAtRow(int row) {
		return data.get(row);
	}

	public int[] rowListToIdList(int[] rows) {
		int[] ids = new int[rows.length];
		for (int i = 0; i < rows.length; i++) {
			ids[i] = (int) data.get(rows[i]).getId();
		}
		return ids;
	}

}
