package model.datatable;

import java.util.Arrays;

import dao.LibDao;
import model.objs.AnimalModel;

public class AnimalsDataTable extends AbstractDataTable {
	private static final long serialVersionUID = -8390593248116451236L;

	public AnimalsDataTable() {
		super(new String[] { "Tên (vi)", "Tên (en)", "Tên (Latinh)", "Họ", "Quý hiếm" });
	}

	@Override
	protected void loadData() {
		this.data = LibDao.loadLibAnimals();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Object val = null;
		AnimalModel tree = (AnimalModel) data.get(rowIndex);
		switch (columnIndex) {
		case 0: // name vi
			val = tree.getNameVi();
			break;
		case 1: // name en
			val = tree.getNameEn();
			break;
		case 2: // name latinh
			val = tree.getNameLatinh();
			break;
		case 3: // last name
			val = tree.getLastname();
			break;
		default: // rare
			val = tree.getRare();
			break;
		}

		return val;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		String str = (String) aValue;
		AnimalModel tree = (AnimalModel) data.get(rowIndex);
		boolean modified = false;
		boolean propNull = false;

		switch (columnIndex) {
		case 0:
			propNull = (tree.getNameVi() == null);
			if (!propNull || (propNull && !str.isEmpty()))
				modified = !str.equals(tree.getNameVi());
			tree.setNameVi(str);
			break;
		case 1:
			propNull = (tree.getNameEn() == null);
			if (!propNull || (propNull && !str.isEmpty()))
				modified = !str.equals(tree.getNameEn());
			tree.setNameEn(str);
			break;
		case 2:
			propNull = (tree.getNameLatinh() == null);
			if (!propNull || (propNull && !str.isEmpty()))
				modified = !str.equals(tree.getNameLatinh());
			tree.setNameLatinh(str);
			break;
		case 3:
			propNull = (tree.getLastname() == null);
			if (!propNull || (propNull && !str.isEmpty()))
				modified = !str.equals(tree.getLastname());
			tree.setLastname(str);
			break;
		default:
			propNull = (tree.getRare() == null);
			if (!propNull || (propNull && !str.isEmpty()))
				modified = !str.equals(tree.getRare());
			tree.setRare(str);
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

	@Override
	public boolean clearData() {
		if (!isEmpty())
			// clear database
			if (LibDao.clearTableAnimals())
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
			data.add(new AnimalModel());
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
			if (LibDao.deleteRecordAnimalsTable(rowListToIdList(rows))) {
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

	@Override
	public boolean saveOrUpdateRow(int row) {
		return LibDao.saveOrUpdateAnimal((AnimalModel) data.get(row));
	}

	@Override
	public void autoSave(int row) {
		AnimalModel ani = (AnimalModel) data.get(row);
		if (!ani.isEmptyObj())
			LibDao.saveOrUpdateAnimal(ani);
	}

	@Override
	protected int[] rowListToIdList(int[] rows) {
		int[] ids = new int[rows.length];
		for (int i = 0; i < rows.length; i++) {
			ids[i] = (int) ((AnimalModel) data.get(rows[i])).getId();
		}
		return ids;
	}

}
