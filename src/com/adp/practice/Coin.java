package com.adp.practice;

public class Coin implements Comparable<Coin>{
	private Long id;
	private String name;
	private Integer value;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	@Override
	public int compareTo(Coin o) {
		return value - o.getValue();
	}
}
