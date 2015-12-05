package model.datatable;

import java.util.Arrays;

import dao.LibDao;
import model.objs.SolutionModel;

public class SolutionsDataTable extends AbstractDataTable {
	private static final long serialVersionUID = -544973261178591348L;

	public SolutionsDataTable() {
		super(new String[] { "Hành vi vi phạm", "Biện pháp khắc phục", "Địa điểm vi phạm" });
	}

	@Override
	protected void loadData() {
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
		if (!isEmpty())
			// clear database
			if (LibDao.clearTableSolutions())
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
		boolean result = false;
		if (rows.length == getRowCount()) {
			result = clearData();
			System.out.println("result of clear action: " + result);
		} else {
			if (LibDao.deleteRecordSolutionsTable(rowListToIdList(rows))) {
				Arrays.sort(rows);
				for (int i = rows.length - 1; i > -1; i--)
					data.remove(rows[i]);

				result = true;
			} else {
				refreshData();
				result = false;
			}
		}
		fireTableDataChanged();
		return result;
	}

	protected int[] rowListToIdList(int[] rows) {
		int[] ids = new int[rows.length];
		for (int i = 0; i < rows.length; i++) {
			ids[i] = (int) ((SolutionModel) data.get(rows[i])).getId();
		}
		return ids;
	}

	@Override
	public boolean saveOrUpdateRow(int row) {
		return LibDao.saveOrUpdateSolution((SolutionModel) data.get(row));
	}

	@Override
	public void autoSave(int row) {
		SolutionModel sol = (SolutionModel) data.get(row);
		if (!sol.isEmptyObj())
			LibDao.saveOrUpdateSolution(sol);
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		String str = (String) aValue;
		SolutionModel sol = (SolutionModel) data.get(rowIndex);
		boolean modified = false;
		boolean propNull = false;

		switch (columnIndex) {
		case 0:
			propNull = (sol.getViolation() == null);
			if (!propNull || (propNull && !str.isEmpty()))
				modified = !str.equals(sol.getViolation());
			sol.setViolation(str);
			break;
		case 1:
			propNull = (sol.getRemedies() == null);
			if (!propNull || (propNull && !str.isEmpty()))
				modified = !str.equals(sol.getRemedies());
			sol.setRemedies(str);
			break;
		default:
			propNull = (sol.getPlacesBreach() == null);
			if (!propNull || (propNull && !str.isEmpty()))
				modified = !str.equals(sol.getPlacesBreach());
			sol.setPlacesBreach(str);
			break;
		}

		if (modified)
			autoSave(rowIndex);
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return String.class;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return true;
	}

}
