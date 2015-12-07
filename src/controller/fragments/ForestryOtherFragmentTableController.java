package controller.fragments;

import model.datatable.AbstractDataTable;
import view.fragments.ForestryOtherTableFragment;

public class ForestryOtherFragmentTableController extends AbstractFragmentTableController {

	public ForestryOtherFragmentTableController(AbstractDataTable model) {
		super(model);
	}

	@Override
	protected void initView() {
		this.view = new ForestryOtherTableFragment(model, this);
	}

}
