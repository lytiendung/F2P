package model.objs;

public class VehicleModel extends AbstractModelObject {
	private String name;
	private int quantity;
	private String controlPlates;
	private boolean keep;
	private String note;

	public VehicleModel() {
		this.id = -1;
		this.name = "";
		this.quantity = 0;
		this.controlPlates = "";
		this.keep = false;
		this.note = "";
	}

	public VehicleModel(long id, String name, int quantity, String controlPlates, boolean keep, String note) {
		this.id = id;
		this.name = name;
		this.quantity = quantity;
		this.controlPlates = controlPlates;
		this.keep = keep;
		this.note = note;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getControlPlates() {
		return controlPlates;
	}

	public void setControlPlates(String controlPlates) {
		this.controlPlates = controlPlates;
	}

	public boolean isKeep() {
		return keep;
	}

	public void setKeep(boolean keep) {
		this.keep = keep;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Override
	public boolean isEmptyObj() {
		return true;
	}

}
