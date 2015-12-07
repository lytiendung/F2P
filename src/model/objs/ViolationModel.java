package model.objs;

import java.util.Calendar;
import java.util.Date;

public class ViolationModel extends AbstractModelObject {
	private String unit;
	private boolean ower;
	private boolean handling;
	private String numberReport;
	private Date dayReport;
	private String numberRule;
	private Date dayRule;
	private String location;
	private String object;
	private String majorPenalty;
	private String handlingAgency;
	private double fines;
	private double alreadySubmmited;

	public ViolationModel() {
		this.id = -1;
		this.unit = "";
		this.ower = false;
		this.handling = false;
		this.numberReport = "";
		this.dayReport = Calendar.getInstance().getTime();
		this.numberRule = "";
		this.dayRule = this.dayReport;
		this.location = "";
		this.object = "";
		this.majorPenalty = "";
		this.handlingAgency = "";
		this.fines = 0;
		this.alreadySubmmited = 0;
	}

	public ViolationModel(long id, String unit, boolean ower, boolean handling, String numberReport, Date dayReport,
			String numberRule, Date dayRule, String location, String object, String majorPenalty, String handlingAgency,
			double fines, double alreadySubmmited) {
		this.id = id;
		this.unit = unit;
		this.ower = ower;
		this.handling = handling;
		this.numberReport = numberReport;
		this.dayReport = dayReport;
		this.numberRule = numberRule;
		this.dayRule = dayRule;
		this.location = location;
		this.object = object;
		this.majorPenalty = majorPenalty;
		this.handlingAgency = handlingAgency;
		this.fines = fines;
		this.alreadySubmmited = alreadySubmmited;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public boolean isOwer() {
		return ower;
	}

	public void setOwer(boolean ower) {
		this.ower = ower;
	}

	public boolean isHandling() {
		return handling;
	}

	public void setHandling(boolean handling) {
		this.handling = handling;
	}

	public String getNumberReport() {
		return numberReport;
	}

	public void setNumberReport(String numberReport) {
		this.numberReport = numberReport;
	}

	public Date getDayReport() {
		return dayReport;
	}

	public void setDayReport(Date dayReport) {
		this.dayReport = dayReport;
	}

	public String getNumberRule() {
		return numberRule;
	}

	public void setNumberRule(String numberRule) {
		this.numberRule = numberRule;
	}

	public Date getDayRule() {
		return dayRule;
	}

	public void setDayRule(Date dayRule) {
		this.dayRule = dayRule;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getObject() {
		return object;
	}

	public void setObject(String object) {
		this.object = object;
	}

	public String getMajorPenalty() {
		return majorPenalty;
	}

	public void setMajorPenalty(String majorPenalty) {
		this.majorPenalty = majorPenalty;
	}

	public String getHandlingAgency() {
		return handlingAgency;
	}

	public void setHandlingAgency(String handlingAgency) {
		this.handlingAgency = handlingAgency;
	}

	public double getFines() {
		return fines;
	}

	public void setFines(double fines) {
		this.fines = fines;
	}

	public double getAlreadySubmmited() {
		return alreadySubmmited;
	}

	public void setAlreadySubmmited(double alreadySubmmited) {
		this.alreadySubmmited = alreadySubmmited;
	}

	@Override
	public boolean isEmptyObj() {
		return false;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof ViolationModel) {
			ViolationModel that = (ViolationModel) obj;
			return (this.unit.equals(that.getUnit()) && this.ower == that.ower && this.handling == that.handling
					&& this.numberReport.equals(that.numberReport) && this.dayReport.equals(that.dayReport)
					&& this.numberRule.equals(that.numberRule) && this.dayRule.equals(that.dayRule)
					&& this.location.equals(that.location) && this.object.equals(that.object)
					&& this.majorPenalty.equals(that.majorPenalty) && this.handlingAgency.equals(that.handlingAgency)
					&& this.fines == that.fines && this.alreadySubmmited == that.alreadySubmmited);
		}
		return false;
	}

	public ViolationModel clone() {
		return new ViolationModel(getId(), getUnit(), isOwer(), isHandling(), getNumberReport(), getDayReport(),
				getNumberRule(), getDayRule(), getLocation(), getObject(), getMajorPenalty(), getHandlingAgency(),
				getFines(), getAlreadySubmmited());
	}

}
