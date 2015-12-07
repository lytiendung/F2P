package model.objs;

public class SolutionModel extends AbstractModelObject {
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
		this.id = id;
		this.violation = violation;
		this.remedies = remedies;
		this.placesBreach = placesBreach;
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
