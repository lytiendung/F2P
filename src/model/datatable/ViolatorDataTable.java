package model.datatable;

import java.text.ParseException;

import celleditor.DateCellEditor;
import dao.RootDao;
import dao.ViolationDao;
import factory.FragmentDaoFactory;
import model.objs.AbstractModelObject;
import model.objs.ViolatorModel;

public class ViolatorDataTable extends AbstractDataTableFragment {
	private static final long serialVersionUID = 2161268305280386384L;

	public ViolatorDataTable() {
		super(new String[] { "H\u1ECD t\u00EAn", "N\u0103m sinh", "Gi\u1EDBi t\u00EDnh", "D\u00E2n t\u1ED9c",
				"Ch\u1EE9ng minh th\u01B0 | Gi\u1EA5y ph\u00E9p l\u00E1i xe", "T\u00EAn \u1EA3nh",
				"\u0110\u1ECBa ch\u1EC9", "S\u1ED1 Q\u0110XP/Q\u0110-XPHC", "S\u1ED1 bi\u00EAn b\u1EA3n",
				"Ng\u00E0y quy\u1EBFt \u0111\u1ECBnh", "Ng\u00E0y l\u1EADp bi\u00EAn b\u1EA3n",
				"Ph\u1EA1t b\u1ED5 sung", "H\u00E0nh vi vi ph\u1EA1m", "Bi\u1EC7n ph\u00E1p kh\u1EAFc ph\u1EE5c",
				"Ti\u1EC1n ph\u1EA1t", "\u0110\u00E3 n\u1ED9p" });
	}

	@Override
	protected void initDao() {
		this.dao = FragmentDaoFactory.getInstanceViolatorDao();
	}

	@Override
	protected void loadData() {
		if (this.dao == null)
			initDao();

		if (ViolationDao.isTmpModel()) {
			this.data = dao.loadTmpData();
			// add null row for user type data
			this.data.add(createEmptyObj());
		} else {
			this.data = dao.loadDataByBreachId(ViolationDao.getModel().getId());
		}

		fireTableDataChanged();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Object val = null;
		ViolatorModel model = (ViolatorModel) data.get(rowIndex);
		switch (columnIndex) {
		case 0:
			val = model.getFullName();
			break;
		case 1:
			val = RootDao.DATE_FORMAT_YEAR_ONLY.format(model.getBirthday());
			break;
		case 2:
			val = model.getSex();
			break;
		case 3:
			val = model.getNation();
			break;
		case 4:
			val = model.getCardIdentify();
			break;
		case 5:
			val = model.getImageName();
			break;
		case 6:
			val = model.getAddress();
			break;
		case 7:
			val = model.getNumberRule();
			break;
		case 8:
			val = model.getNumberReport();
			break;
		case 9:
			val = RootDao.DATE_FORMAT_USER.format(model.getDateRule());
			break;
		case 10:
			val = RootDao.DATE_FORMAT_USER.format(model.getDateReport());
			break;
		case 11:
			val = model.getSerial();
			break;
		case 12:
			val = model.getBehavior();
			break;
		case 13:
			val = model.getSolution();
			break;
		case 14:
			val = model.getFine();
			break;
		case 15:
			val = model.getSubmitted();
			break;
		}
		return val;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		ViolatorModel model = (ViolatorModel) data.get(rowIndex);
		switch (columnIndex) {
		case 0:
			model.setFullName((String) aValue);
			break;
		case 1:
			try {
				model.setBirthday(RootDao.DATE_FORMAT_USER.parse((String) aValue));
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
			break;
		case 2:
			model.setSex((String) aValue);
			break;
		case 3:
			model.setNation((String) aValue);
			break;
		case 4:
			model.setCardIdentify((String) aValue);
			break;
		case 5:
			model.setImageName((String) aValue);
			break;
		case 6:
			model.setAddress((String) aValue);
			break;
		case 7:
			model.setNumberRule((String) aValue);
			break;
		case 8:
			model.setNumberReport((String) aValue);
			break;
		case 9:
			try {
				model.setDateRule(RootDao.DATE_FORMAT_USER.parse((String) aValue));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			break;
		case 10:
			try {
				model.setDateReport(RootDao.DATE_FORMAT_USER.parse((String) aValue));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			break;
		case 11:
			model.setSerial((String) aValue);
			break;
		case 12:
			model.setBehavior((String) aValue);
			break;
		case 13:
			model.setSolution((String) aValue);
			break;
		case 14:
			model.setFine((double) aValue);
			break;
		case 15:
			model.setSubmitted((double) aValue);
			break;
		}
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex) {
		case 9:
		case 10:
			return DateCellEditor.class;
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
		return new ViolatorModel();
	}

}
