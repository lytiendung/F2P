package model.datatable;

import java.util.ArrayList;

import factory.FragmentDaoFactory;
import model.objs.AbstractModelObject;
import model.objs.ForestModel;

public class ForestDataTable extends AbstractDataTableFragment {
	private static final long serialVersionUID = -4651213693517146488L;

	public ForestDataTable() {
		super(new String[] { "Lo\u1EA1i CQL", "T\u00EAn ch\u1EE7 qu\u1EA3n", "Lo\u1EA1i r\u1EEBng",
				"R\u1EEBng tr\u1ED3ng (m2)", "R\u1EEBng t\u1EF1 nhi\u00EAn (m2)" });
	}

	@Override
	protected void initDao() {
		this.dao = FragmentDaoFactory.getInstanceForest();
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
	protected AbstractModelObject createEmptyObj() {
		return new ForestModel();
	}

	@Override
	public boolean updateBreachId(long idBreach) {
		return dao.updateAllBreachId(data, idBreach);
	}

	@Override
	public boolean deleteByBreachId(long idBreach) {
		return dao.deleteByBreachId(idBreach);
	}

}
