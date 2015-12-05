package controller.libs;

import model.datatable.AbstractDataTable;
import view.PanelLibAnimals;

public class LibAnimalsController extends AbstractLibController {

	public LibAnimalsController(AbstractDataTable model) {
		super(model);
	}

	@Override
	protected void initView() {
		this.view = new PanelLibAnimals(model, this);
	}

}
