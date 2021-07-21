package com.adp.practice;

import java.math.BigDecimal;

public class FileData {
 
	private String workerId;
	private String firstName;
	private String lastName;
	private String ssn;
	private BigDecimal taxable;
	private BigDecimal tax;
	public String getWorkerId() {
		return workerId;
	}
	public void setWorkerId(String workerId) {
		this.workerId = workerId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public BigDecimal getTaxable() {
		return taxable;
	}
	public void setTaxable(BigDecimal taxable) {
		this.taxable = taxable;
	}
	public BigDecimal getTax() {
		return tax;
	}
	public void setTax(BigDecimal tax) {
		this.tax = tax;
	}
	
	
	
}
