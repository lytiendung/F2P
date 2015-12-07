package model.datatable;

import java.util.ArrayList;

import factory.FragmentDaoFactory;
import model.objs.AbstractModelObject;
import model.objs.VehicleModel;

public class VehicleDataTable extends AbstractDataTableFragment {
	private static final long serialVersionUID = 9155775023727452321L;

	public VehicleDataTable() {
		super(new String[] { "T\u00EAn ph\u01B0\u01A1ng ti\u1EC7n", "S\u1ED1 l\u01B0\u1EE3ng",
				"Bi\u1EC3n ki\u1EC3m so\u00E1t", "Thu", "Ghi ch\u00FA" });
	}

	@Override
	protected void initDao() {
		this.dao = FragmentDaoFactory.getInstanceVehicle();
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
		case 1:
			return Integer.class;
		case 3:
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
		return new VehicleModel();
	}

}
