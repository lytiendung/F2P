package controller.fragments;

import model.datatable.AbstractDataTable;
import view.fragments.WoodTableFragment;

public class WoodFragmentTableController extends AbstractFragmentTableController {

	public WoodFragmentTableController(AbstractDataTable model) {
		super(model);
	}

	@Override
	protected void initView() {
		this.view = new WoodTableFragment(model, this);
	}

}
