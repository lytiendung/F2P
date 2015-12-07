package model.datatable;

import java.util.ArrayList;

import com.alee.laf.table.editors.WebDateEditor;

import factory.FragmentDaoFactory;
import model.objs.AbstractModelObject;
import model.objs.ViolationModel;

public class ViolatorDataTable extends AbstractDataTableFragment {
	private static final long serialVersionUID = 2161268305280386384L;

	public ViolatorDataTable() {
		super(new String[] { "H\u1ECD t\u00EAn", "N\u0103m sinh", "Gi\u1EDBi t\u00EDnh", "D\u00E2n t\u1ED9c",
				"Ch\u1EE9ng minh th\u01B0 | Gi\u1EA5y ph\u00E9p l\u00E1i xe", "T\u00EAn \u1EA3nh",
				"\u0110\u1ECBa ch\u1EC9", "S\u1ED1 Q\u0110XP/Q\u0110-XPHC", "S\u1ED1 bi\u00EAn b\u1EA3n",
				"Ng\u00E0y quy\u1EBFt \u0111\u1ECBnh", "Ng\u00E0y l\u1EADp bi\u00EAn b\u1EA3n",
				"H\u00E0nh vi vi ph\u1EA1m", "Ph\u1EA1t b\u1ED5 sung", "Bi\u1EC7n ph\u00E1p kh\u1EAFc ph\u1EE5c",
				"Ti\u1EC1n ph\u1EA1t", "\u0110\u00E3 n\u1ED9p" });
	}

	@Override
	protected void initDao() {
		this.dao = FragmentDaoFactory.getInstanceViolatorDao();
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
		case 9:
		case 10:
			return WebDateEditor.class;
		case 14:
		case 15:
			return Double.class;
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
		return new ViolationModel();
	}

}
