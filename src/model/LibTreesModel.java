package model;

import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.table.AbstractTableModel;

import dao.LibDao;

public class LibTreesModel extends AbstractTableModel {
	private static final long serialVersionUID = -1841929008517561740L;
	private ArrayList<TreeModel> data;
	private ArrayList<String> columnIdentifiers;

	public LibTreesModel() {
		this.data = LibDao.loadLibTrees();
		this.columnIdentifiers = new ArrayList<String>(
				Arrays.asList("Tên (vi)", "Tên (en)", "Tên (Latinh)", "Họ", "Quý hiếm"));
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

}
