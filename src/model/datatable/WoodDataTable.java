package model.datatable;

import java.util.ArrayList;

import factory.FragmentDaoFactory;
import model.objs.AbstractModelObject;
import model.objs.WoodModel;

public class WoodDataTable extends AbstractDataTableFragment {
	private static final long serialVersionUID = -2201877776517195058L;

	public WoodDataTable() {
		super(new String[] { "Lo\u1EA1i", "Nh\u00F3m", "T\u00EAn", "\u0110\u01A1n v\u1ECB t\u00EDnh",
				"S\u1ED1 l\u01B0\u1EE3ng", "Kh\u1ED1i l\u01B0\u1EE3ng (m3)", "Hi\u1EBFm", "Thu" });
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
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
