package controller.libs;

import model.datatable.TreesDataTable;
import view.PanelLibTrees;

public class LibTreesController extends AbstractLibController {

	public LibTreesController(TreesDataTable model) {
		super(model);
	}

	@Override
	protected void initView() {
		this.view = new PanelLibTrees((TreesDataTable) model, this);
	}

}
