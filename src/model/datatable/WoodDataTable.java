package model.datatable;

import java.util.ArrayList;

import factory.FragmentDaoFactory;
import model.objs.AbstractModelObject;
import model.objs.WoodModel;

public class WoodDataTable extends AbstractDataTableFragment {
	private static final long serialVersionUID = -2201877776517195058L;

	public WoodDataTable() {
		super(new String[] { "Lo\u1EA1i", "Nh\u00F3m", "T\u00EAn",
				"\u0110\u01A1n v\u1ECB t\u00EDnh", "S\u1ED1 l\u01B0\u1EE3ng",
				"Kh\u1ED1i l\u01B0\u1EE3ng (m3)", "Hi\u1EBFm", "Thu" });
	}

	@Override
	protected void initDao() {
		this.dao = FragmentDaoFactory.getInstanceWoodDao();
	}

	@Override
	protected void loadData() {
		this.data = new ArrayList<>();
		this.data.add(createEmptyObj());
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Object val = null;
		WoodModel model = (WoodModel) data.get(rowIndex);
		switch (columnIndex) {
		case 0:
			val = model.getType();
			break;
		case 1:
			val = model.getGroup();
			break;
		case 2:
			val = model.getName();
			break;
		case 3:
			val = model.getUnit();
			break;
		case 4:
			val = model.getAmount();
			break;
		case 5:
			val = model.getWeight();
			break;
		case 6:
			val = model.getRate();
			break;
		case 7:
			val = model.isKeep();

		}
		return val;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		WoodModel model = (WoodModel) data.get(rowIndex);
		switch (columnIndex) {
		case 0:
			model.setType((String) aValue);
			break;
		case 1:
			model.setGroup((String) aValue);
			break;
		case 2:
			model.setName((String) aValue);
			break;
		case 3:
			model.setUnit((String) aValue);
			break;
		case 4:
			model.setAmount((Integer) aValue);
			break;
		case 5:
			model.setWeight((double) aValue);
			break;
		case 6:
			model.setRate((String) aValue);
			break;
		default:
			model.setKeep((boolean) aValue);
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
		case 4:
			return Integer.class;
		case 5:
			return Double.class;
		case 7:
			return Boolean.class;
		default:
			return String.class;
		}
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return true;
	}

	@Override
	protected AbstractModelObject createEmptyObj() {
		return new WoodModel();
	}

}
