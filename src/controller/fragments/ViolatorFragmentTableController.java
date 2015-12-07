package controller.fragments;

import model.datatable.AbstractDataTable;
import view.fragments.ViolatorTableFragment;

public class ViolatorFragmentTableController extends AbstractFragmentTableController {

	public ViolatorFragmentTableController(AbstractDataTable model) {
		super(model);
	}

	@Override
	protected void initView() {
		this.view = new ViolatorTableFragment(model, this);
	}

}
