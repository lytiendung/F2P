package model.objs;

public class SolutionModel extends AbstracModelObject {
	private long id;
	private String violation;
	private String remedies;
	private String placesBreach;

	public SolutionModel() {
		this.id = -1;
		this.violation = "";
		this.remedies = "";
		this.placesBreach = "";
	}

	public SolutionModel(long id, String violation, String remedies, String placesBreach) {
		super();
		this.id = id;
		this.violation = violation;
		this.remedies = remedies;
		this.placesBreach = placesBreach;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getViolation() {
		return violation;
	}

	public void setViolation(String violation) {
		this.violation = violation;
	}

	public String getRemedies() {
		return remedies;
	}

	public void setRemedies(String remedies) {
		this.remedies = remedies;
	}

	public String getPlacesBreach() {
		return placesBreach;
	}

	public void setPlacesBreach(String placesBreach) {
		this.placesBreach = placesBreach;
	}

	@Override
	public boolean isEmptyObj() {
		// only check properties required
		return (this.violation.isEmpty() && this.remedies.isEmpty() && this.placesBreach.isEmpty());
	}

}
