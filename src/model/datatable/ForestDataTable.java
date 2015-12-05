package model.datatable;

import java.util.ArrayList;

import model.objs.ForestModel;

public class ForestDataTable extends AbstractDataTable {
	private static final long serialVersionUID = -4651213693517146488L;

	public ForestDataTable(String[] colNames) {
		super(colNames);
	}

	@Override
	protected void loadData() {
		this.data = new ArrayList<>();
		this.data.add(new ForestModel());
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Object val = null;
		ForestModel model = (ForestModel) data.get(rowIndex);
		switch (columnIndex) {
		case 0:
			val = model.getKindCQL();
			break;
		case 1:
			val = model.getNameManger();
			break;
		case 2:
			val = model.getForestType();
			break;
		case 3:
			val = model.getPlantation();
			break;
		default:
			val = model.getNaturalForest();
			break;
		}
		return val;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		ForestModel model = (ForestModel) data.get(rowIndex);
		switch (columnIndex) {
		case 0:
			model.setKindCQL((String) aValue);
			break;
		case 1:
			model.setNameManger((String) aValue);
			break;
		case 2:
			model.setForestType((String) aValue);
			break;
		case 3:
			model.setPlantation((double) aValue);
			break;
		default:
			model.setNaturalForest((double) aValue);
			break;
		}

		if (!model.isEmptyObj() && model.getId() == -1) {
			autoSave(rowIndex);
			addRow();
			fireTableDataChanged();
		} else {
			fireTableCellUpdated(rowIndex, columnIndex);
		}
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex) {
		case 0:
		case 1:
		case 2:
			return String.class;
		case 3:
		default:
			return Double.class;
		}
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return true;
	}

	@Override
	public boolean clearData() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addRow() {
		if (hasNullRow())
			return false;
		else {
			data.add(new ForestModel());
			fireTableDataChanged();
			return true;
		}
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

	@Override
	protected int[] rowListToIdList(int[] rows) {
		// TODO Auto-generated method stub
		return null;
	}

}
