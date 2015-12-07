package model.objs;

import java.util.Calendar;
import java.util.Date;

public class ViolatorModel extends AbstractModelObject {
	private String fullName;
	private String serial;
	private Date birthday;
	private String sex;
	private String nation;
	private String cardIdentify;
	private String imageName;
	private String address;
	private String numberRule;
	private String numberReport;
	private Date dateRule;
	private Date dateReport;
	private String behavior;
	private String penalty;
	private String solution;
	private double fine;
	private double submitted;

	public ViolatorModel() {
		this.id = -1;
		this.fullName = "";
		this.serial = "";
		this.birthday = Calendar.getInstance().getTime();
		this.sex = "";
		this.nation = "";
		this.cardIdentify = "";
		this.imageName = "";
		this.address = "";
		this.numberRule = "";
		this.numberReport = "";
		this.dateRule = Calendar.getInstance().getTime();
		this.dateReport = Calendar.getInstance().getTime();
		this.behavior = "";
		this.penalty = "";
		this.solution = "";
		this.fine = 0;
		this.submitted = 0;
	}

	public ViolatorModel(long id, String fullName, String serial, Date birthday, String sex, String nation,
			String cardIdentify, String imageName, String address, String numberRule, String numberReport,
			Date dateRule, Date dateReport, String behavior, String penalty, String solution, double fine,
			double submitted) {
		this.id = id;
		this.fullName = fullName;
		this.serial = serial;
		this.birthday = birthday;
		this.sex = sex;
		this.nation = nation;
		this.cardIdentify = cardIdentify;
		this.imageName = imageName;
		this.address = address;
		this.numberRule = numberRule;
		this.numberReport = numberReport;
		this.dateRule = dateRule;
		this.dateReport = dateReport;
		this.behavior = behavior;
		this.penalty = penalty;
		this.solution = solution;
		this.fine = fine;
		this.submitted = submitted;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public String getCardIdentify() {
		return cardIdentify;
	}

	public void setCardIdentify(String cardIdentify) {
		this.cardIdentify = cardIdentify;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getNumberRule() {
		return numberRule;
	}

	public void setNumberRule(String numberRule) {
		this.numberRule = numberRule;
	}

	public String getNumberReport() {
		return numberReport;
	}

	public void setNumberReport(String numberReport) {
		this.numberReport = numberReport;
	}

	public Date getDateRule() {
		return dateRule;
	}

	public void setDateRule(Date dateRule) {
		this.dateRule = dateRule;
	}

	public Date getDateReport() {
		return dateReport;
	}

	public void setDateReport(Date dateReport) {
		this.dateReport = dateReport;
	}

	public String getBehavior() {
		return behavior;
	}

	public void setBehavior(String behavior) {
		this.behavior = behavior;
	}

	public String getPenalty() {
		return penalty;
	}

	public void setPenalty(String penalty) {
		this.penalty = penalty;
	}

	public String getSolution() {
		return solution;
	}

	public void setSolution(String solution) {
		this.solution = solution;
	}

	public double getFine() {
		return fine;
	}

	public void setFine(double fine) {
		this.fine = fine;
	}

	public double getSubmitted() {
		return submitted;
	}

	public void setSubmitted(double submitted) {
		this.submitted = submitted;
	}

	@Override
	public boolean isEmptyObj() {
		return true;
	}

}
