package view.fragments;

import controller.fragments.AbstractFragmentTableController;
import factory.TableFactory;
import model.datatable.AbstractDataTable;

public class WoodTableFragment extends AbstractTableFragment {

	public WoodTableFragment(AbstractDataTable model, AbstractFragmentTableController controller) {
		super(model, controller);
	}

	@Override
	public void initTable(AbstractDataTable model, AbstractFragmentTableController controller) {
		this.table = TableFactory.createCustomTable(model, controller);
	}

}
