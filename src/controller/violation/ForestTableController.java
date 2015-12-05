package controller.violation;

import model.datatable.AbstractDataTable;
import view.fragments.ForestTableFragment;

public class ForestTableController extends AbstractFragmentTableController {

	public ForestTableController(AbstractDataTable model) {
		super(model);
	}

	@Override
	protected void initView() {
		this.view = new ForestTableFragment(model, this);
	}

}
