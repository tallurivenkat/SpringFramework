package com.venkat.jdbc;

public class Emp {
	

	public String toString() {
		return "Emp [eno=" + eno + ", ename=" + ename + ", salary=" + salary
				+ "]";
	}
	public String eno;
	public String ename;
	public String salary;
	public Emp(String eno, String ename, String salary) {
		super();
		this.eno = eno;
		this.ename = ename;
		this.salary = salary;
	}
	public String getEno() {
		return eno;
	}
	public void setEno(String eno) {
		this.eno = eno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getEsalary() {
		return salary;
	}
	public void setEsalary(String esalary) {
		this.salary = esalary;
	}
	

}
