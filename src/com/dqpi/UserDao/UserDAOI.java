package com.dqpi.UserDao;

import java.util.List;

import com.dqpi.Model.*;

public interface UserDAOI {
	public List<User> Sselect(String name,String password,String usertype);
	public List<Student> Studentinformation(String name);
	public List<Student> StudentinformationManager(String name);
	public List<StudentCourse> Studentcourse(String name);
	public List<StudentCourse> Studentcourse1(String name);
	public List<StudentCourse> Studentcourse();
	public List<StudentCourse> StudentcourseSelect(String name);
	
	public List<TeacherCourse> IndexTeacherSelectCourse(String name);
	public List<TeacherCourse> Teacher_SelectCourse();
	public List<TeacherCourse> IndexTeacherSelectCourse1(String name);
	public List<TeacherCourse> IndexTeacherSelectCourse1(String name,String b);
	public List<Course> StudentSelectCourse();
	public List<Course> Course(String name);
	public List<Student> index_teacher_StudentInformation();
	public List<Teacher> TeacherInformation();
	public List<Teacher> index_teacher_user(String name);
	public List<Teacher> index_teacher_user2(String name);
	public void resetInfo(String username,String password,String mpass);
	
	public void delete(String string);
	public void deleteAll(String string,String x);
	public void deleteAn(String string);
	public void deleteTeacherInformation(String string);
	public void deleteTeacherCoures(String string);
	public void deleteSelectCourse(String string,String Cno)
	;
	public String insertTeacherManager(String a,String b,String c,String d,String f);
	
	public String updateStudentInformation(String a,String b,String c,String d,String e,String f);
	public String updateCourse(String Cno,String Cname,String Cgrade,String Ctime,String Ctype);
	public String updateTeacher(String a,String b,String c,String d,String e);
	public String updateSelect(String Stno,String OCno,String Cno,String Clo);
	public String AddStudentInformation(String a,String b,String c,String d,String e,String f);
	public void  updateGradeAll(String a,String b,String c,String e,String f);
	public String AddCourse(String Cno,String Cname,String Cgrade,String Ctime,String Ctype);
	public String AddSelect(String Stno,String Cno,String Clno);
	public void  AddGradeAll(String a,String b,String c,String e,String f);
}
