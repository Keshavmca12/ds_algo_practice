package com.adp.practice;

import java.math.BigDecimal;

public class FileOutputData {
	private String fileName;
	private BigDecimal taxable = BigDecimal.ZERO;
	private BigDecimal tax = BigDecimal.ZERO;
	private Long noOfSsn = 0l;
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
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
	public Long getNoOfSsn() {
		return noOfSsn;
	}
	public void setNoOfSsn(Long noOfSsn) {
		this.noOfSsn = noOfSsn;
	}
	
	
}
