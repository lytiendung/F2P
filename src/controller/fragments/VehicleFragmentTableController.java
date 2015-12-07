package controller.fragments;

import model.datatable.AbstractDataTable;
import view.fragments.VehicleTableFragment;

public class VehicleFragmentTableController extends AbstractFragmentTableController {

	public VehicleFragmentTableController(AbstractDataTable model) {
		super(model);
	}

	@Override
	protected void initView() {
		this.view = new VehicleTableFragment(model, this);
	}

}
