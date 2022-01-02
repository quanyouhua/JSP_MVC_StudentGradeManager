package com.dqpi.UserDao.Imp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.print.DocFlavor.STRING;

import com.dqpi.Model.*;
import com.dqpi.UserDao.UserDAOI;
import com.dqpi.Util.DBManager;

public class UserDaoimp implements UserDAOI{
	public List<User> Sselect(String name,String password,String usertype) {
		DBManager db =  new DBManager();
		List<User> list = new ArrayList<User>();
		String sql = "select * from Userperson where Susername='"+name+"' and Spassword='"+password+"' and Sno='"+usertype+"'";
		System.out.println(sql);
		ResultSet rs = db.executeQuery(sql);
		try {
			while (rs.next()) {
				System.out.println(sql);
				User user = new User();
				user.setSusername(rs.getString("Susername").trim());
				user.setSpassword(rs.getString("Spassword").trim());
				user.setSno(rs.getString("Sno").trim());
				user.setSID(rs.getString("SID").trim());
				System.out.println(user.getSusername()+user.getSpassword()+user.getSno()+user.getSID());
				list.add(user);
			}
		} 
		catch (SQLException e) {
			System.out.println("失败");
		}
		db.Close();
		return list;
	}
	public List<Student> Studentinformation(String name){
		DBManager db =  new DBManager();
		List<Student> list = new ArrayList<Student>();
		String sql ="select Student.Sno,Sname ,Ssex,Sage,Sdept,Clno from Userperson,Student where Userperson.SID=Student.Sno and Susername='"+name+"'";
		System.out.println(sql);
		ResultSet rs = db.executeQuery(sql);
		try {
			while (rs.next()){
				Student user = new Student();
				user.setSno(rs.getString("Sno").trim());
				System.out.println(user.getSno());
				user.setSname(rs.getString("Sname").trim());
				System.out.println(user.getSname());
				user.setSsex(rs.getString("Ssex"));
				System.out.println(user.getSsex());
				user.setSage(rs.getInt("Sage"));
				System.out.println(user.getSage());
				user.setSdept(rs.getString("Sdept"));
				user.setClno(rs.getString("Clno"));
				System.out.println(user.getSno()+"\t"+user.getSage()+"t"+user.getClno()+"\t"+user.getSdept()+"\t"+user.getSname()+user.getSsex());
				list.add(user);
			}
		} 
		catch (SQLException e) {
			System.out.println("失败");
		}
		db.Close();
		return list;
	}
	public List<Student> StudentinformationManager(String name){
		DBManager db =  new DBManager();
		List<Student> list = new ArrayList<Student>();
		String sql ="select Sno,Sname ,Ssex,Sage,Sdept,Clno from Student where Sno='"+name+"'";
		System.out.println(sql);
		ResultSet rs = db.executeQuery(sql);
		try {
			while (rs.next()){
				Student user = new Student();
				user.setSno(rs.getString("Sno").trim());
				System.out.println(user.getSno());
				user.setSname(rs.getString("Sname").trim());
				System.out.println(user.getSname());
				user.setSsex(rs.getString("Ssex"));
				System.out.println(user.getSsex());
				user.setSage(rs.getInt("Sage"));
				System.out.println(user.getSage());
				user.setSdept(rs.getString("Sdept"));
				user.setClno(rs.getString("Clno"));
				System.out.println(user.getSno()+"\t"+user.getSage()+"t"+user.getClno()+"\t"+user.getSdept()+"\t"+user.getSname()+user.getSsex());
				list.add(user);
			}
		} 
		catch (SQLException e) {
			System.out.println("失败");
		}
		db.Close();
		return list;
	}
	public List<StudentCourse> Studentcourse(String name){
		DBManager db =  new DBManager();
		List<StudentCourse> list = new ArrayList<StudentCourse>();
		String sql ="select Student.Sno,Sname ,Course.Cno,Cname,Stname,Scg "+
					"from Userperson,Student,SC,Course,TC,Teacher "+ 
				    "where Userperson.SID=Student.Sno and Student.Sno=SC.Sno and SC.Cno=Course.Cno and Course.Cno=TC.Cno and TC.Stno=Teacher.Stno "
					+"and Susername='"+name+"'";
		System.out.println(sql);
		ResultSet rs = db.executeQuery(sql);
		try {
			while (rs.next()){
				StudentCourse user = new StudentCourse();
				user.setSno(rs.getString("Sno").trim());
				System.out.println(user.getSno());
				user.setSname(rs.getString("Sname").trim());
				System.out.println(user.getSname());
				user.setCno(rs.getString("Cno"));
				System.out.println(user.getCno());
				user.setCname(rs.getString("Cname"));
				System.out.println(user.getCname());
				user.setTeacher(rs.getString("Stname"));
				user.setCgrade(rs.getInt("Scg"));
				list.add(user);
			}
		} 
		catch (SQLException e) {
			System.out.println("失败");
		}
		db.Close();
		return list;
	}
	public List<StudentCourse> Studentcourse1(String name){
		DBManager db =  new DBManager();
		List<StudentCourse> list = new ArrayList<StudentCourse>();
		String sql ="select Student.Sno,Sname ,Course.Cno,Cname,Stname,Scg "+
					"from Student,SC,Course,TC,Teacher "+ 
				    "where Student.Sno=SC.Sno and SC.Cno=Course.Cno and Course.Cno=TC.Cno and TC.Stno=Teacher.Stno "
					+"and Student.Sno='"+name+"'";
		System.out.println(sql);
		ResultSet rs = db.executeQuery(sql);
		try {
			while (rs.next()){
				StudentCourse user = new StudentCourse();
				user.setSno(rs.getString("Sno").trim());
				System.out.println(user.getSno());
				user.setSname(rs.getString("Sname").trim());
				System.out.println(user.getSname());
				user.setCno(rs.getString("Cno"));
				System.out.println(user.getCno());
				user.setCname(rs.getString("Cname"));
				System.out.println(user.getCname());
				user.setTeacher(rs.getString("Stname"));
				user.setCgrade(rs.getInt("Scg"));
				list.add(user);
			}
		} 
		catch (SQLException e) {
			System.out.println("失败");
		}
		db.Close();
		return list;
	}
	public List<TeacherCourse> IndexTeacherSelectCourse1(String name,String b){
		DBManager db =  new DBManager();
		List<TeacherCourse> list = new ArrayList<TeacherCourse>();
		String sql ="select Teacher.Stno,Stname,Course.Cno,Cname,Clno "+
					"from Course,TC,Teacher "+ 
				    "where Teacher.Stno=TC.Stno and TC.Cno=Course.Cno and Teacher.Stno='"+name+"'and Course.Cno='"+b+"'" ;
		System.out.println(sql);
		ResultSet rs = db.executeQuery(sql);
		try {
			while (rs.next()){
				TeacherCourse user = new TeacherCourse();
				user.setStno(rs.getString("Stno").trim());
				System.out.println(user.getStno());
				user.setStname(rs.getString("Stname").trim());
				System.out.println(user.getStname());
				user.setCno(rs.getString("Cno"));
				System.out.println(user.getCno());
				user.setCname(rs.getString("Cname"));
				System.out.println(user.getCname());
				user.setClno(rs.getString("Clno"));
				list.add(user);
			}
		} 
		catch (SQLException e) {
			System.out.println("失败");
		}
		db.Close();
		return list;
	}
	public List<StudentCourse> Studentcourse( ){
		DBManager db =  new DBManager();
		List<StudentCourse> list = new ArrayList<StudentCourse>();
		String sql ="select Student.sno,sum(Scg)as Allgrade from Student,Sc where Student.Sno=Sc.Sno group by Student.sno";
		System.out.println(sql);
		ResultSet rs = db.executeQuery(sql);
		try {
			while (rs.next()){
				StudentCourse user = new StudentCourse();
				user.setSno(rs.getString("Sno").trim());
				System.out.println(user.getSno());
				user.setCgrade(rs.getInt("Allgrade"));
				list.add(user);
			}
		} 
		catch (SQLException e) {
			System.out.println("失败");
		}
		db.Close();
		return list;
	}
	public List<TeacherCourse> IndexTeacherSelectCourse1(String name){
		DBManager db =  new DBManager();
		List<TeacherCourse> list = new ArrayList<TeacherCourse>();
		String sql ="select Teacher.Stno,Stname,Course.Cno,Cname,Clno "+
					"from Course,TC,Teacher "+ 
				    "where Teacher.Stno=TC.Stno and TC.Cno=Course.Cno and Teacher.Stno='"+name+"'" ;
		System.out.println(sql);
		ResultSet rs = db.executeQuery(sql);
		try {
			while (rs.next()){
				TeacherCourse user = new TeacherCourse();
				user.setStno(rs.getString("Stno").trim());
				System.out.println(user.getStno());
				user.setStname(rs.getString("Stname").trim());
				System.out.println(user.getStname());
				user.setCno(rs.getString("Cno"));
				System.out.println(user.getCno());
				user.setCname(rs.getString("Cname"));
				System.out.println(user.getCname());
				user.setClno(rs.getString("Clno"));
				list.add(user);
			}
		} 
		catch (SQLException e) {
			System.out.println("失败");
		}
		db.Close();
		return list;
	}
	public List<TeacherCourse> IndexTeacherSelectCourse(String name){
		DBManager db =  new DBManager();
		List<TeacherCourse> list = new ArrayList<TeacherCourse>();
		String sql ="select Teacher.Stno,Stname,Course.Cno,Cname,Clno "+
					"from Course,TC,Teacher,Userperson "+ 
				    "where Userperson.SID=Teacher.Stno and Teacher.Stno=TC.Stno and TC.Cno=Course.Cno "
					+"and Susername='"+name+"'";
		System.out.println(sql);
		ResultSet rs = db.executeQuery(sql);
		try {
			while (rs.next()){
				TeacherCourse user = new TeacherCourse();
				user.setStno(rs.getString("Stno").trim());
				System.out.println(user.getStno());
				user.setStname(rs.getString("Stname").trim());
				System.out.println(user.getStname());
				user.setCno(rs.getString("Cno"));
				System.out.println(user.getCno());
				user.setCname(rs.getString("Cname"));
				System.out.println(user.getCname());
				user.setClno(rs.getString("Clno"));
				list.add(user);
			}
		} 
		catch (SQLException e) {
			System.out.println("失败");
		}
		db.Close();
		return list;
	}
	public List<TeacherCourse> Teacher_SelectCourse(){
		DBManager db =  new DBManager();
		List<TeacherCourse> list = new ArrayList<TeacherCourse>();
		String sql ="select Teacher.Stno,Stname,Course.Cno,Cname,Clno "+
					"from Course,TC,Teacher,Userperson "+ 
				    "where Userperson.SID=Teacher.Stno and Teacher.Stno=TC.Stno and TC.Cno=Course.Cno ";
				    System.out.println(sql);
		ResultSet rs = db.executeQuery(sql);
		try {
			while (rs.next()){
				TeacherCourse user = new TeacherCourse();
				user.setStno(rs.getString("Stno").trim());
				System.out.println(user.getStno());
				user.setStname(rs.getString("Stname").trim());
				System.out.println(user.getStname());
				user.setCno(rs.getString("Cno"));
				System.out.println(user.getCno());
				user.setCname(rs.getString("Cname"));
				System.out.println(user.getCname());
				user.setClno(rs.getString("Clno"));
				list.add(user);
			}
		} 
		catch (SQLException e) {
			System.out.println("失败");
		}
		db.Close();
		return list;
	}
	public List<StudentCourse> StudentcourseSelect(String name){
		DBManager db =  new DBManager();
		List<StudentCourse> list = new ArrayList<StudentCourse>();
		String sql ="select Student.sno,sum(Scg)as Allgrade from Student,Sc where Student.sno='"+name+"'and Student.Sno=Sc.Sno group by Student.sno";
		System.out.println(sql);
		ResultSet rs = db.executeQuery(sql);
		try {
			while (rs.next()){
				StudentCourse user = new StudentCourse();
				user.setSno(rs.getString("Sno").trim());
				System.out.println(user.getSno());
				user.setCgrade(rs.getInt("Allgrade"));
				list.add(user);
			}
		} 
		catch (SQLException e) {
			System.out.println("失败");
		}
		db.Close();
		return list;
	}
	public List<Course> StudentSelectCourse(){
		DBManager db =  new DBManager();
		List<Course> list = new ArrayList<Course>();
		String sql ="select * from Course";
		System.out.println(sql);
		ResultSet rs = db.executeQuery(sql);
		try {
			while (rs.next()){
				Course user = new Course();
				user.setCno(rs.getString("Cno").trim());
				System.out.println(user.getCno());
				user.setCname(rs.getString("Cname").trim());
				System.out.println(user.getCname());
				user.setCgrade(rs.getInt("Cgrade"));
				user.setCtime(rs.getInt("Ctime"));
				System.out.println(user.getCname());
				user.setType(rs.getString("Ctype"));
				list.add(user);
			}
		} 
		catch (SQLException e) {
			System.out.println("失败");
		}
		db.Close();
		return list;
	}
	public List<Teacher> TeacherInformation(){
		DBManager db =  new DBManager();
		List<Teacher> list = new ArrayList<Teacher>();
		String sql ="select * from Teacher";
		System.out.println(sql);
		ResultSet rs = db.executeQuery(sql);
		try {
			while (rs.next()){
				Teacher user = new Teacher();
				user.setStno(rs.getString("Stno").trim());
				System.out.println(user.getStno());
				user.setStname(rs.getString("Stname").trim());
				System.out.println(user.getStname());
				user.setStsex(rs.getString("Stsex"));
				System.out.println(user.getStsex());
				user.setStage(rs.getInt("Stage"));
				System.out.println(user.getStage());
				user.setSto(rs.getString("Sto"));
				list.add(user);
			}
		} 
		catch (SQLException e) {
			System.out.println("失败");
		}
		db.Close();
		return list;
	}
	public List<Teacher> index_teacher_user(String name){
		DBManager db =  new DBManager();
		List<Teacher> list = new ArrayList<Teacher>();
		String sql ="select Teacher.Stno,Stname,Stsex,Stage,Sto from Userperson,Teacher where Userperson.SID=Teacher.Stno and Susername='"+name+"'";
		System.out.println(sql);
		ResultSet rs = db.executeQuery(sql);
		try {
			while (rs.next()){
				Teacher user = new Teacher();
				user.setStno(rs.getString("Stno").trim());
				System.out.println(user.getStno());
				user.setStname(rs.getString("Stname").trim());
				System.out.println(user.getStname());
				user.setStsex(rs.getString("Stsex"));
				System.out.println(user.getStsex());
				user.setStage(rs.getInt("Stage"));
				System.out.println(user.getStage());
				user.setSto(rs.getString("Sto"));
				list.add(user);
			}
		} 
		catch (SQLException e) {
			System.out.println("失败");
		}
		db.Close();
		return list;
	}
	public List<Teacher> index_teacher_user2(String name){
		DBManager db =  new DBManager();
		List<Teacher> list = new ArrayList<Teacher>();
		String sql ="select * from Teacher where Stno='"+name+"'";
		System.out.println(sql);
		ResultSet rs = db.executeQuery(sql);
		try {
			while (rs.next()){
				Teacher user = new Teacher();
				user.setStno(rs.getString("Stno").trim());
				System.out.println(user.getStno());
				user.setStname(rs.getString("Stname").trim());
				System.out.println(user.getStname());
				user.setStsex(rs.getString("Stsex"));
				System.out.println(user.getStsex());
				user.setStage(rs.getInt("Stage"));
				System.out.println(user.getStage());
				user.setSto(rs.getString("Sto"));
				list.add(user);
			}
		} 
		catch (SQLException e) {
			System.out.println("失败");
		}
		db.Close();
		return list;
	}
	public List<Student> index_teacher_StudentInformation(){
		DBManager db =  new DBManager();
		List<Student> list = new ArrayList<Student>();
		String sql ="select * from Student";
		System.out.println(sql);
		ResultSet rs = db.executeQuery(sql);
		try {
			while (rs.next()){
				Student user = new Student();
				user.setSno(rs.getString("Sno").trim());
				System.out.println(user.getSno());
				user.setSname(rs.getString("Sname").trim());
				System.out.println(user.getSname());
				user.setSsex(rs.getString("Ssex"));
				System.out.println(user.getSsex());
				user.setSage(rs.getInt("Sage"));
				System.out.println(user.getSage());
				user.setSdept(rs.getString("Sdept"));
				user.setClno(rs.getString("Clno"));
				list.add(user);
			}
		} 
		catch (SQLException e) {
			System.out.println("失败");
		}
		db.Close();
		return list;
	}
	public List<Course> Course(String name){
		DBManager db =  new DBManager();
		List<Course> list = new ArrayList<Course>();
		String sql ="select * from Course where Cno='"+name+"'";
		System.out.println(sql);
		ResultSet rs = db.executeQuery(sql);
		try {
			while (rs.next()){
				Course user = new Course();
				user.setCno(rs.getString("Cno").trim());
				System.out.println(user.getCno());
				user.setCname(rs.getString("Cname").trim());
				System.out.println(user.getCname());
				user.setCgrade(rs.getInt("Cgrade"));
				user.setCtime(rs.getInt("Ctime"));
				System.out.println(user.getCname());
				user.setType(rs.getString("Ctype"));
				list.add(user);
			}
		} 
		catch (SQLException e) {
			System.out.println("失败");
		}
		db.Close();
		return list;
	}
	public void delete(String id) {
		DBManager db =  new DBManager();
		String sql = "delete from Student where Sno='"+id+"'";
		System.out.println(sql);
		db.executeUpdate(sql);
	}
	public void deleteAll(String string,String x){
		DBManager db =  new DBManager();
		String sql = "delete from SC where Sno='"+string+"' and Cno='"+x+"'";
		System.out.println(sql);
		db.executeUpdate(sql);
	}
	public void deleteAn(String string){
		DBManager db =  new DBManager();
		String sql = "delete from SC where Sno='"+string+"'";
		System.out.println(sql);
		db.executeUpdate(sql);
	}
	public void deleteTeacherInformation(String string){
		DBManager db =  new DBManager();
		String sql = "delete from Teacher where Stno='"+string+"'";
		System.out.println(sql);
		db.executeUpdate(sql);
	}
	public void deleteTeacherCoures(String string){
		DBManager db =  new DBManager();
		String sql = "delete from Course where Cno='"+string+"'";
		System.out.println(sql);
		db.executeUpdate(sql);
	}
	public void deleteSelectCourse(String string,String Cno){
		DBManager db =  new DBManager();
		String sql = "delete from TC where Stno='"+string+"' and Cno='"+Cno+"'";
		System.out.println(sql);
		db.executeUpdate(sql);
	}
	public String insertTeacherManager(String Stno,String Stname,String Stsex,String Ssage,String Sto){
		String message=null;
			DBManager db=new DBManager();
			String sql="insert into Teacher(Stno,Stname,Stsex,Stage,Sto) values('"+Stno+"','"+Stname+"','"+Stsex+"','"+Ssage+"','"+Sto+"')";
			System.out.println(sql);
			int d=db.executeUpdate(sql);
			if(d==0){
			message="插入失败，请检查数据是否正确";}
		return message;
	}
	public String updateStudentInformation(String Sno,String Sname,String Ssex,String Sage,String Sdept,String Clno){
		String message=null;
		DBManager db=new DBManager();
		String sql="update Student set Sname='"+Sname+"', Ssex='"+Ssex+"', Sage='"+Sage+"', Sdept='"+Sdept+"', Clno='"+Clno+"' where Sno='"+Sno+"'";
		System.out.println(sql);
		int d=db.executeUpdate(sql);
		if(d==0){
		message="修改失败，请检查数据是否正确";}
		return message;
	}
	public String updateTeacher(String Stno,String Stname,String Stsex,String Stage,String Sto){
		String message=null;
		DBManager db=new DBManager();
		String sql="update Teacher set Stname='"+Stname+"', Stsex='"+Stsex+"', Stage='"+Stage+"', Sto='"+Sto+"' where Stno='"+Stno+"'";
		System.out.println(sql);
		int d=db.executeUpdate(sql);
		if(d==0){
		message="修改失败，请检查数据是否正确";}
		return message;
	}
	@Override
	public void resetInfo(String username,String password,String mpass) {
		DBManager db =  new DBManager();
		String sql = "update Userperson set Spassword='"+mpass+"' where Susername='"+username+"'and Spassword='"+password+"'";
		System.out.println(sql);
		db.executeUpdate(sql);
		db.Close1();
	}
	public String updateCourse(String Cno,String Cname,String Cgrade,String Ctime,String Ctype){
		DBManager db =  new DBManager();
		String sql = "update Course set Cname='"+Cname+"', Cgrade='"+Cgrade+"', Ctime='"+Ctime+"', Ctype='"+Ctype+"' where Cno='"+Cno+"'";
		System.out.println(sql);
		int d=db.executeUpdate(sql);
		String message=null;
		if(d==0){
		message="修改失败，请检查数据是否正确";}
		return message;
	}
	public String updateSelect(String Stno,String OCno,String Cno,String Clo){
		DBManager db =  new DBManager();
		String sql = "update TC set Cno='"+Cno+"', Clno='"+Clo+"' where Cno='"+OCno+"' and Stno='"+Stno+"'";
		System.out.println(sql);
		int d=db.executeUpdate(sql);
		String message=null;
		if(d==0){
		message="修改失败，请检查数据是否正确";}
		return message;
	}
	public void updateGradeAll(String Sno,String Cno,String Sname,String Cname,String Scg){
		DBManager db =  new DBManager();
		String sql = "update Student set Sname='"+Sname+"'where Sno='"+Sno+"'";
		String sql2="update Course set Cname='"+Cname+"'where Cno='"+Cno+"'";
		String sql3="update SC set Scg='"+Scg+"' where Sno='"+Sno+"' and Cno='"+Cno+"'";
		System.out.println(sql);System.out.println(sql2);System.out.println(sql3);
		db.executeUpdate(sql);
		db.executeUpdate(sql2);
		db.executeUpdate(sql3);
	}
	public String AddStudentInformation(String Sno,String Sname,String Ssex,String Sage,String Sdept,String Clno){
		String message=null;
		DBManager db=new DBManager();
		String sql="insert into Student(Sno,Sname,Ssex,Sage,Sdept,Clno) values('"+Sno+"','"+Sname+"','"+Ssex+"','"+Sage+"','"+Sdept+"','"+Clno+"')";
		System.out.println(sql);
		int d=db.executeUpdate(sql);
		if(d==0){
		message="插入失败，请检查数据是否正确";}
		return message;
	}
	public String AddCourse(String Cno,String Cname,String Cgrade,String Ctime,String Ctype){
		String message=null;
		DBManager db=new DBManager();
		String sql="insert into Course(Cno,Cname,Cgrade,Ctime,Ctype) values('"+Cno+"','"+Cname+"','"+Cgrade+"','"+Ctime+"','"+Ctype+"')";
		System.out.println(sql);
		int d=db.executeUpdate(sql);
		if(d==0){
		message="插入失败，请检查数据是否正确";}
		return message;
	}
	public String AddSelect(String Stno,String Cno,String Clno){
		String message=null;
		DBManager db=new DBManager();
		String sql="insert into TC(Stno,Cno,Clno) values('"+Stno+"','"+Cno+"','"+Clno+"')";
		System.out.println(sql);
		int d=db.executeUpdate(sql);
		if(d==0){
		message="插入失败，请检查数据是否正确";}
		return message;
	}
	public void  AddGradeAll(String Sno,String Cno,String Sname,String Cname,String Scg){
		DBManager db =  new DBManager();
		String sql="insert into Student(Sno,Sname)values('"+Sno+"','"+Sname+"')";
		String sql2="insert into Course(Cno,Cname)values('"+Cno+"','"+Cname+"')";
		String sql3="insert into SC(Sno,Cno,Scg)values('"+Sno+"','"+Cno+"','"+Scg+"')";
		System.out.println(sql);System.out.println(sql2);System.out.println(sql3);
		db.executeUpdate(sql);
		db.executeUpdate(sql2);
		db.executeUpdate(sql3);
	}
}
