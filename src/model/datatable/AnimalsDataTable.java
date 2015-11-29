package model.datatable;

import java.util.ArrayList;

public class AnimalsDataTable extends AbstractDataTable {
	private static final long serialVersionUID = -8390593248116451236L;

	public AnimalsDataTable() {
		super(new String[] { "Tên (vi)", "Tên (en)", "Tên (Latinh)", "Họ", "Quý hiếm" });
	}

	@Override
	protected void loadData() {
		this.data = new ArrayList<>();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub

	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean clearData() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addRow() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteRow(int[] rows) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean saveOrUpdateRow(int row) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void autoSave(int row) {
		// TODO Auto-generated method stub

	}

}
