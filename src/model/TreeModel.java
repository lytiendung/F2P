package model;

public class TreeModel {
	private long id;
	private String nameVi;
	private String nameEn;
	private String nameLatinh;
	private String lastname;
	private String rare;

	public TreeModel() {
		this.id = -1;
		this.nameVi = "";
		this.nameEn = "";
		this.nameLatinh = "";
		this.lastname = "";
		this.rare = "";
	}

	public TreeModel(long id, String nameVi, String nameEn, String nameLatinh, String lastname, String rare) {
		this.id = id;
		this.nameVi = nameVi;
		this.nameEn = nameEn;
		this.nameLatinh = nameLatinh;
		this.lastname = lastname;
		this.rare = rare;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNameVi() {
		return nameVi;
	}

	public void setNameVi(String nameVi) {
		this.nameVi = nameVi;
	}

	public String getNameEn() {
		return nameEn;
	}

	public void setNameEn(String nameEn) {
		this.nameEn = nameEn;
	}

	public String getNameLatinh() {
		return nameLatinh;
	}

	public void setNameLatinh(String nameLatinh) {
		this.nameLatinh = nameLatinh;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getRare() {
		return rare;
	}

	public void setRare(String rare) {
		this.rare = rare;
	}

	public boolean isEmptyObj() {
		// only check properties required
		return (this.nameVi.isEmpty() && this.nameEn.isEmpty() && this.rare.isEmpty());
	}

}
