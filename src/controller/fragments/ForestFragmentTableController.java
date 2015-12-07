package controller.fragments;

import model.datatable.AbstractDataTable;
import view.fragments.ForestTableFragment;

public class ForestFragmentTableController extends AbstractFragmentTableController {

	public ForestFragmentTableController(AbstractDataTable model) {
		super(model);
	}

	@Override
	protected void initView() {
		this.view = new ForestTableFragment(model, this);
	}

}
