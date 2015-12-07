package controller.fragments;

import model.datatable.AbstractDataTable;
import view.fragments.WildAnimalTableFragment;

public class WildAnimalFragmentTableController extends AbstractFragmentTableController {

	public WildAnimalFragmentTableController(AbstractDataTable model) {
		super(model);
	}

	@Override
	protected void initView() {
		this.view = new WildAnimalTableFragment(model, this);
	}

}
