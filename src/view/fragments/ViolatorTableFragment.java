package view.fragments;

import java.util.ArrayList;
import java.util.List;

import celleditor.DateCellEditor;
import controller.PairComboboxController;
import controller.fragments.AbstractFragmentTableController;
import dao.LibDao;
import factory.TableFactory;
import model.datatable.AbstractDataTable;
import model.objs.AbstractModelObject;
import model.objs.SolutionModel;

public class ViolatorTableFragment extends AbstractTableFragment {

	public ViolatorTableFragment(AbstractDataTable model, AbstractFragmentTableController controller) {
		super(model, controller);
	}

	@Override
	public void initTable(AbstractDataTable model, AbstractFragmentTableController controller) {
		this.table = TableFactory.createCustomTable(model, controller);

		this.table.getColumnModel().getColumn(2)
				.setCellEditor(TableFactory.createDefaultComboboxCellEditor(new String[] { "Nam", "Nữ" }));
		this.table.setDefaultEditor(DateCellEditor.class, new DateCellEditor());

		List<AbstractModelObject> models = LibDao.loadLibSolutions();

		SolutionModel sol = null;
		ArrayList<String> behs = new ArrayList<>();
		ArrayList<String> sols = new ArrayList<>();

		for (AbstractModelObject aModel : models) {
			sol = (SolutionModel) aModel;
			behs.add(sol.getViolation());
			sols.add(sol.getRemedies());
		}

		PairComboboxController pairControll = new PairComboboxController(behs.toArray(), sols.toArray());

		this.table.getColumnModel().getColumn(12)
				.setCellEditor(TableFactory.createEditableComboboxCellEditor(pairControll.getCbx1()));
		this.table.getColumnModel().getColumn(13)
				.setCellEditor(TableFactory.createEditableComboboxCellEditor(pairControll.getCbx2()));
	}

}
