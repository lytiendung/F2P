package model.objs;

public class ForestryOther extends AbstractModelObject {
	private String name;
	private String unit;
	private int amount;
	private double weight;
	private String rate;
	private boolean keep;

	public ForestryOther() {
		this.id = -1;
		this.name = "";
		this.unit = "";
		this.amount = 0;
		this.weight = 0;
		this.rate = "";
		this.keep = false;
	}

	public ForestryOther(long id, String name, String unit, int amount, double weight, String rate, boolean keep) {
		this.id = id;
		this.name = name;
		this.unit = unit;
		this.amount = amount;
		this.weight = weight;
		this.rate = rate;
		this.keep = keep;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}

	public boolean isKeep() {
		return keep;
	}

	public void setKeep(boolean keep) {
		this.keep = keep;
	}

	@Override
	public boolean isEmptyObj() {
		return true;
	}

}
