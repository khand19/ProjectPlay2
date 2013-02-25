package com.excilys.bean;

import java.util.Date;

public class Computer {
	private int idComputer;
	private String nameComputer;
	private Date introducedDate;
	private Date dscountedDate;
	private Company company;
	
	public int getIdComputer() {
		return idComputer;
	}
	public void setIdComputer(int idComputer) {
		this.idComputer = idComputer;
	}
	public String getNameComputer() {
		return nameComputer;
	}
	public void setNameComputer(String nameComputer) {
		this.nameComputer = nameComputer;
	}
	public Date getIntroducedDate() {
		return introducedDate;
	}
	public void setIntroducedDate(Date introducedDate) {
		this.introducedDate = introducedDate;
	}
	public Date getDscountedDate() {
		return dscountedDate;
	}
	public void setDscountedDate(Date dscountedDate) {
		this.dscountedDate = dscountedDate;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	

	@Override
	public String toString() {
		return "Computer [idComputer=" + idComputer + ", nameComputer="
				+ nameComputer + ", introducedDate=" + introducedDate
				+ ", dscountedDate=" + dscountedDate + ", company=" + company
				+ "]";
	}
}
