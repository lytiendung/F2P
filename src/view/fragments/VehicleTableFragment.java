package view.fragments;

import controller.fragments.AbstractFragmentTableController;
import factory.TableFactory;
import model.datatable.AbstractDataTable;

public class VehicleTableFragment extends AbstractTableFragment {

	public VehicleTableFragment(AbstractDataTable model, AbstractFragmentTableController controller) {
		super(model, controller);
	}

	@Override
	public void initTable(AbstractDataTable model, AbstractFragmentTableController controller) {
		this.table = TableFactory.createCustomTable(model, controller);

		this.table.getColumnModel().getColumn(0).setCellEditor(
				TableFactory.createDefaultComboboxCellEditor(new Object[] { "Doanh sách tên phương tiện" }));
	}

}
