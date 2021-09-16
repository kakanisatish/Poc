package com.Neosoft.Employee.controller;

public class Error {
	private Integer id;
	private String name;
	private Throwable excep;
	private String ecode;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Throwable getExcep() {
		return excep;
	}
	public void setExcep(Throwable excep) {
		this.excep = excep;
	}
	public String getEcode() {
		return ecode;
	}
	public void setEcode(String ecode) {
		this.ecode = ecode;
	}

}
