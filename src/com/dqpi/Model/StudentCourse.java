package com.dqpi.Model;

public class StudentCourse {
	
	public String getSno() {
		return Sno;
	}
	public void setSno(String sno) {
		Sno = sno;
	}
	public String getSname() {
		return Sname;
	}
	public void setSname(String sname) {
		Sname = sname;
	}
	public String getCno() {
		return Cno;
	}
	public void setCno(String cno) {
		Cno = cno;
	}
	public String getCname() {
		return Cname;
	}
	public void setCname(String cname) {
		Cname = cname;
	}
	public int getCgrade() {
		return Cgrade;
	}
	public void setCgrade(int cgrade) {
		Cgrade = cgrade;
	}
	public String getTeacher() {
		return Teacher;
	}
	public void setTeacher(String teacher) {
		Teacher = teacher;
	}
	private String Sno;
	private String Sname;
	private String Cno;
	private String Cname;
	private int Cgrade;
	private String Teacher;
}
