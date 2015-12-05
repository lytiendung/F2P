package view.fragments;

import controller.violation.AbstractFragmentTableController;
import factory.TableFactory;
import model.datatable.AbstractDataTable;

public class ForestTableFragment extends TableFragment {

	public ForestTableFragment(AbstractDataTable model, AbstractFragmentTableController controller) {
		super(model, controller);
	}

	@Override
	public void initTable(AbstractDataTable model, AbstractFragmentTableController controller) {
		this.table = TableFactory.createCustomTable(model, controller);

		this.table.getColumnModel().getColumn(0).setCellEditor(TableFactory
				.createDefaultComboboxCellEditor(new Object[] { "Doanh nghiệp", "Nhà nước", "Hộ gia đình" }));
		this.table.getColumnModel().getColumn(2).setCellEditor(
				TableFactory.createDefaultComboboxCellEditor(new Object[] { "Đặc dụng", "Phòng hộ", "Sản xuất" }));
	}

}
