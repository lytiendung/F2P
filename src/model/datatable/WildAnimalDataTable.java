package model.datatable;

import java.util.ArrayList;

import factory.FragmentDaoFactory;
import model.objs.AbstractModelObject;
import model.objs.WildAnimalModel;

public class WildAnimalDataTable extends AbstractDataTableFragment {
	private static final long serialVersionUID = 7438692087490996796L;

	public WildAnimalDataTable() {
		super(new String[] { "T\u00EAn", "S\u1ED1 l\u01B0\u1EE3ng", "Tr\u1ECDng l\u01B0\u1EE3ng (Kg)", "Hi\u1EBFm",
				"Thu" });
	}

	@Override
	protected void initDao() {
		this.dao = FragmentDaoFactory.getInstanceWildAnimal();
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
		case 2:
			return Double.class;
		case 4:
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
		return new WildAnimalModel();
	}

}
