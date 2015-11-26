package model;

public interface DataTableInterface {

	public boolean isEmpty();

	public boolean clearData();

	public void refreshData();

	public boolean hasNullRow();

	public boolean addRow();

	public boolean deleteRow(int[] rows);

	public boolean saveOrUpdateRow(int row);

	public void autoSave(int row);

	public Object getObjAtRow(int row);

}
