package com.dqpi.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

public class DBManager {
	Connection con;
	String driver = "com.mysql.jdbc.Driver";
	String uri = "jdbc:mysql://localhost:3306/studnetgrade?characterEncoding=utf8";
	String user = "root";
	String password = "";
	ResultSet rs = null;
	Statement st = null;
	
	public DBManager(){
		this.con = this.getConnection();
	}
	/*
	 * 作为连接数据库的类使用
	 * 
	 * */
	private Connection getConnection() {			
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(uri,user,password);
			if (!con.equals(null)) {
				System.out.println("数据库连接成功");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("你的驱动错误");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("你的连接错误");
		} 
		return con;
	}
	/*
	 * 查询操作
	 * 
	 * */
	public ResultSet executeQuery(String sql) {			
		try {
			st = (Statement) con.createStatement();
			rs = st.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("SQL语句执行错误");
		}
		return rs;
	}
	
	
	/*
	 * CUD操作
	 * 
	 * */
	public int executeUpdate(String sql) {	
		int cont = 0;
		try {
			st = (Statement) con.createStatement();
			cont = st.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("SQL语句执行CUD错误");
		}
		return cont;
	}
	/*
	 * 关闭资源
	 * 
	 * */
	//查询关闭
	public void Close(){
		try {
			rs.close();
			st.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("关闭失败");
		}		
	}
	//删除关闭
	public void Close1(){
		try {
			st.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("关闭失败");
		}	
	}
}
