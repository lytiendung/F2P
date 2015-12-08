package view.fragments;

import celleditor.DateCellEditor;
import controller.fragments.AbstractFragmentTableController;
import factory.TableFactory;
import model.datatable.AbstractDataTable;

public class ViolatorTableFragment extends AbstractTableFragment {

	public ViolatorTableFragment(AbstractDataTable model, AbstractFragmentTableController controller) {
		super(model, controller);
	}

	@Override
	public void initTable(AbstractDataTable model, AbstractFragmentTableController controller) {
		this.table = TableFactory.createCustomTable(model, controller);

		this.table.getColumnModel().getColumn(2)
				.setCellEditor(TableFactory.createDefaultComboboxCellEditor(new String[] { "Nam", "Nữ" }));
		this.table.setDefaultEditor(DateCellEditor.class, new DateCellEditor());
	}

}
