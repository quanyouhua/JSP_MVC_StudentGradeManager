package com.dqpi.Model;

public class Course {
	private String Cno;
	private String Cname;
	private int Cgrade;
	private int Ctime;
	private String type;
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
	public int getCtime() {
		return Ctime;
	}
	public void setCtime(int ctime) {
		Ctime = ctime;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}
