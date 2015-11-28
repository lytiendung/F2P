package model;

import java.util.Arrays;

import dao.LibDao;

public class LibSolutionsModel extends AbstractDataTable {
	private static final long serialVersionUID = 1L;

	public LibSolutionsModel() {
		super();
		this.columnIdentifiers.addAll(Arrays.asList("Hành vi vi phạm", "Biện pháp khắc phục", "Địa điểm vi phạm"));
	}

	@Override
	public void loadData() {
		this.data = LibDao.loadLibSolutions();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Object val = null;
		SolutionModel store = (SolutionModel) data.get(rowIndex);

		switch (columnIndex) {
		case 0:
			val = store.getViolation();
			break;
		case 1:
			val = store.getRemedies();
			break;
		default:
			val = store.getPlacesBreach();
			break;
		}
		return val;
	}

	@Override
	public boolean clearData() {
		return false;
	}

	@Override
	public boolean addRow() {
		if (hasNullRow())
			return false;
		else {
			data.add(new SolutionModel());
			fireTableDataChanged();
			return true;
		}
	}

	@Override
	public boolean deleteRow(int[] rows) {
		return false;
	}

	@Override
	public boolean saveOrUpdateRow(int row) {
		return false;
	}

	@Override
	public void autoSave(int row) {
		// TODO Auto-generated method stub
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return null;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

}
