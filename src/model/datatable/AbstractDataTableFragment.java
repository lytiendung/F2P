package model.datatable;

import java.util.Arrays;

import dao.AbstractFragmentDao;
import dao.ViolationDao;
import model.main.Observer;
import model.objs.AbstractModelObject;

public abstract class AbstractDataTableFragment extends AbstractDataTable implements Observer {
	private static final long serialVersionUID = -8335393498718184694L;
	protected AbstractFragmentDao dao;

	public AbstractDataTableFragment(String[] colNames) {
		super(colNames);
	}

	protected abstract void initDao();

	@Override
	protected abstract void loadData();

	@Override
	public abstract Object getValueAt(int rowIndex, int columnIndex);

	@Override
	public abstract void setValueAt(Object aValue, int rowIndex, int columnIndex);

	@Override
	public abstract Class<?> getColumnClass(int columnIndex);

	@Override
	public abstract boolean isCellEditable(int rowIndex, int columnIndex);

	@Override
	public boolean clearData() {
		return this.dao.clearTable();
	}

	@Override
	public boolean addRow() {
		if (hasNullRow())
			return false;
		else {
			data.add(createEmptyObj());
			fireTableDataChanged();
			return true;
		}
	}

	@Override
	public boolean deleteRow(int[] rows) {
		boolean result = false;
		if (this.dao.deleteRecords(rowListToIdList(rows))) {
			Arrays.sort(rows);
			for (int i = rows.length - 1; i > -1; i--)
				data.remove(rows[i]);

			result = true;
		} else {
			refreshData();
			result = false;
		}
		fireTableDataChanged();
		return result;
	}

	@Override
	public void autoSave(int row) {
		AbstractModelObject model = data.get(row);
		if (!model.isEmptyObj())
			dao.saveOrUpdate(model, ViolationDao.getModel().getId());
	}

	protected abstract AbstractModelObject createEmptyObj();

	@Override
	public boolean updateBreachId(long idBreach) {
		boolean result = dao.updateAllBreachId(data, idBreach);
		loadData();

		return result;
	}

	@Override
	public boolean deleteByBreachId(long idBreach) {
		boolean result = dao.deleteByBreachId(idBreach);
		loadData();

		return result;
	}

}
