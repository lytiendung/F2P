package view.fragments;

import com.alee.laf.table.editors.WebDateEditor;

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

		this.table.setDefaultEditor(WebDateEditor.class, new WebDateEditor());
	}

}
