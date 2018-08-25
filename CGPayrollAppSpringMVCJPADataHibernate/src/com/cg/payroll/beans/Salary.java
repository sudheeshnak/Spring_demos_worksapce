package com.cg.payroll.beans;

import javax.persistence.Embeddable;

@Embeddable
public class Salary {
	private int basicSalary, hra, epf,
	companyPf;

	public int getBasicSalary() {
		return basicSalary;
	}

	public void setBasicSalary(int basicSalary) {
		this.basicSalary = basicSalary;
	}

	public int getHra() {
		return hra;
	}

	public void setHra(int hra) {
		this.hra = hra;
	}

	public int getEpf() {
		return epf;
	}

	public void setEpf(int epf) {
		this.epf = epf;
	}

	public int getCompanyPf() {
		return companyPf;
	}

	public void setCompanyPf(int companyPf) {
		this.companyPf = companyPf;
	}
	
	

	public Salary() {
		super();
	}

	public Salary(int basicSalary, int hra, int epf, int companyPf) {
		super();
		this.basicSalary = basicSalary;
		this.hra = hra;
		this.epf = epf;
		this.companyPf = companyPf;
	}	
	
	
}