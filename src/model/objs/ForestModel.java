package model.objs;

public class ForestModel extends AbstracModelObject {
	private long id;
	private String kindCQL;
	private String nameManger;
	private String forestType;
	private double plantation;
	private double naturalForest;

	public ForestModel() {
		this.id = -1;
		this.kindCQL = "";
		this.nameManger = "";
		this.forestType = "";
		this.plantation = 0;
		this.naturalForest = 0;
	}

	public ForestModel(long id, String kindCQL, String nameManger, String forestType, double plantation,
			double naturalForest) {
		this.id = id;
		this.kindCQL = kindCQL;
		this.nameManger = nameManger;
		this.forestType = forestType;
		this.plantation = plantation;
		this.naturalForest = naturalForest;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getKindCQL() {
		return kindCQL;
	}

	public void setKindCQL(String kindCQL) {
		this.kindCQL = kindCQL;
	}

	public String getNameManger() {
		return nameManger;
	}

	public void setNameManger(String nameManger) {
		this.nameManger = nameManger;
	}

	public String getForestType() {
		return forestType;
	}

	public void setForestType(String forestType) {
		this.forestType = forestType;
	}

	public double getPlantation() {
		return plantation;
	}

	public void setPlantation(double plantation) {
		this.plantation = plantation;
	}

	public double getNaturalForest() {
		return naturalForest;
	}

	public void setNaturalForest(double naturalForest) {
		this.naturalForest = naturalForest;
	}

	@Override
	public boolean isEmptyObj() {
		return !((!kindCQL.isEmpty() && !nameManger.isEmpty() && !forestType.isEmpty())
				&& (naturalForest > 0 || plantation > 0));
	}

}
