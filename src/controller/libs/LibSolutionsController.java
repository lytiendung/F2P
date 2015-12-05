package controller.libs;

import model.datatable.AbstractDataTable;
import view.PanelLibSolutions;

public class LibSolutionsController extends AbstractLibController {

	public LibSolutionsController(AbstractDataTable model) {
		super(model);
	}

	@Override
	protected void initView() {
		this.view = new PanelLibSolutions(model, this);
	}

}
