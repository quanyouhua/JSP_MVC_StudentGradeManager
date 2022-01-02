package com.dqpi.Service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspApplicationContext;
import javax.websocket.Session;

import org.apache.jasper.tagplugins.jstl.core.If;
import org.omg.CORBA.PUBLIC_MEMBER;

import com.dqpi.Model.*;
import com.dqpi.UserDao.UserDAOI;
import com.dqpi.UserDao.Imp.UserDaoimp;

public class Userservlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	public static HttpSession session1=null;
	public static HttpSession session2=null;
	public  List<StudentCourse> TimeStudent=new ArrayList<StudentCourse>();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String jsp=req.getParameter("jsp");
		session1 = req.getSession();
		if(jsp.equals("login")){
	        String rand =session1.getAttribute("code").toString();  
	        String input = req.getParameter("code"); 
	        String message=null;
	        if(rand.equals(input)){  
	        	String usertype = req.getParameter("usertype");
				session1.setAttribute("usertype", usertype);
				String name=req.getParameter("name");
				session1.setAttribute("name", name);
				name=new String(name.getBytes("iso-8859-1"),"utf-8");
				String password=req.getParameter("password");
				session1.setAttribute("password", password);
				System.out.println(name+"\t"+password+"\t"+usertype);
				UserDAOI userDAOI = new UserDaoimp();
				List<User> list = new ArrayList<>();
				list = userDAOI.Sselect(name,password,usertype);
				System.out.println("1");
				if(list.size()!=0){
					System.out.println(3);
					System.out.println(usertype);
					session1.setAttribute("userList", list);
					if(usertype.equals("student")){
						resp.sendRedirect("main/index.jsp");
					}
					if(usertype.equals("teacher")){
						resp.sendRedirect("main/index(teacher).jsp");
					}
					if(usertype.equals("manager")){
						resp.sendRedirect("main/index(manager).jsp");
					}
				}
				else{
					message="用户名或密码输入错误";
					session1.setAttribute("message",message);
					resp.sendRedirect("login.jsp");
				}	
				System.out.println("2");
	        }else{  
	              message="验证码出错";
	              System.out.println("验证码出错");
	              session1.setAttribute("message",message);
	              resp.sendRedirect("login.jsp");
	        }  	
		}
		
		
		if(jsp.equals("updatepassword")){
			String crudper=null;
			String password=(String)session1.getAttribute("password");
			String username=(String)session1.getAttribute("name");
			String mpass=req.getParameter("mpass");
			if(password.equals(mpass)){
				crudper="修改成功";
				session1.setAttribute("crudper", crudper);				
				String newpass=req.getParameter("newpass");
				session1.setAttribute("password",newpass);
				UserDAOI user=new UserDaoimp();
				user.resetInfo(username,password,newpass);
				resp.sendRedirect("personnew.jsp");
			}
			else{
				crudper="原始密码不同";
				session1.setAttribute("crudper", crudper);
				resp.sendRedirect("personnew.jsp");
			}
		}
		System.out.println(jsp);
		if(jsp.equals("TeacherManagerUpdate")){
			String Stno=req.getParameter("mTeacherStno");
			String Stname=req.getParameter("mTeacherStname");
			Stname=new String(Stname.getBytes("iso-8859-1"),"utf-8");
			String Stsex=req.getParameter("mTeacherSsex");
			Stsex=new String(Stsex.getBytes("iso-8859-1"),"utf-8");
			String Ssage=req.getParameter("mTeacherSage");
			String Sto=req.getParameter("mTeacherSto");
			Sto=new String(Sto.getBytes("iso-8859-1"),"utf-8");
			UserDAOI user=new UserDaoimp();
			String message=user.insertTeacherManager(Stno,Stname,Stsex,Ssage,Sto);
			System.out.println(message);
			session1.setAttribute("TeacherManagerUpdate.message", message);
			UserDAOI user2=new UserDaoimp();
			List<Teacher> StudentCourse = new ArrayList<>();
			StudentCourse =user2.TeacherInformation();
			session2.setAttribute("TeacherInformation",StudentCourse);
			resp.sendRedirect("TeacherInformation.jsp");
		}
		if(jsp.equals("Student_update_Information")){
			String Sno=req.getParameter("Sno");
			String Sname=req.getParameter("mTeacherStno");
			String Ssex=req.getParameter("mTeacherStname");
			Sname=new String(Sname.getBytes("iso-8859-1"),"utf-8");
			String Sage=req.getParameter("mTeacherSsex");
			Ssex=new String(Ssex.getBytes("iso-8859-1"),"utf-8");
			String Sdept=req.getParameter("mTeacherSage");
			String Clno=req.getParameter("mTeacherSto");
			Sdept=new String(Sdept.getBytes("iso-8859-1"),"utf-8");
			UserDAOI user=new UserDaoimp();
			String message=user.updateStudentInformation(Sno,Sname,Ssex,Sage,Sdept,Clno);
			System.out.println(message);
			session1.setAttribute("updateStudentInformatio", message);
			UserDAOI user2=new UserDaoimp();
			System.out.println(1);
			List<Student> StudentCourse = new ArrayList<>();
			StudentCourse =user2.index_teacher_StudentInformation();
			session2.setAttribute("index_teacher_StudentInformation",StudentCourse);
			resp.sendRedirect("CrudStudent.jsp");
		}
		if(jsp.equals("Student_update_Course")){
			String Cno=req.getParameter("Stno");
			String Cname=req.getParameter("mTeacherStno");
			String Ctime=req.getParameter("mTeacherStname");
			Cname=new String(Cname.getBytes("iso-8859-1"),"utf-8");
			String Cgrade=req.getParameter("mTeacherSsex");
			String Ctype=req.getParameter("mTeacherSage");
			Ctype=new String(Ctype.getBytes("iso-8859-1"),"utf-8");
			UserDAOI user=new UserDaoimp();
			String message=user.updateCourse(Cno,Cname,Cgrade,Ctime,Ctype);
			System.out.println(message);
			session1.setAttribute("updateCourse", message);
			UserDAOI user2=new UserDaoimp();
			List<Course> StudentCourse = new ArrayList<>();
			StudentCourse =user2.StudentSelectCourse();
			session2.setAttribute("Teacher.Course",StudentCourse);
			resp.sendRedirect("Course.jsp");
		}
		if(jsp.equals("Teacher_update_Teacher")){
			String Stno=req.getParameter("Sno");
			String Stname=req.getParameter("mTeacherStno");
			String Stsex=req.getParameter("mTeacherStname");
			Stname=new String(Stname.getBytes("iso-8859-1"),"utf-8");
			String Stage=req.getParameter("mTeacherSsex");
			Stsex=new String(Stsex.getBytes("iso-8859-1"),"utf-8");
			String Sto=req.getParameter("mTeacherSage");
			Sto=new String(Sto.getBytes("iso-8859-1"),"utf-8");
			UserDAOI user=new UserDaoimp();
			String message=user.updateTeacher(Stno,Stname,Stsex,Stage,Sto);
			System.out.println(message);
			session1.setAttribute("updateStudentInformatio", message);
			UserDAOI user2=new UserDaoimp();
			List<Teacher> StudentCourse = new ArrayList<>();
			StudentCourse =user2.TeacherInformation();
			session2.setAttribute("TeacherInformation",StudentCourse);
			resp.sendRedirect("TeacherInformation.jsp");
		}
		if(jsp.equals("Teacher_update_Teacher1")){
			String Stno=req.getParameter("Sno");
			System.out.println(Stno);
			String Stname=req.getParameter("mTeacherStno");
			String Stsex=req.getParameter("mTeacherStname");
			Stname=new String(Stname.getBytes("iso-8859-1"),"utf-8");
			String Stage=req.getParameter("mTeacherSsex");
			Stsex=new String(Stsex.getBytes("iso-8859-1"),"utf-8");
			String Sto=req.getParameter("mTeacherSage");
			Sto=new String(Sto.getBytes("iso-8859-1"),"utf-8");
			UserDAOI user=new UserDaoimp();
			String message=user.updateTeacher(Stno,Stname,Stsex,Stage,Sto);
			System.out.println(message);
			session1.setAttribute("updateStudentInformatio1", message);
			UserDAOI user2=new UserDaoimp();
			List<Teacher> index_teacher_user=new ArrayList<>();
			index_teacher_user=user2.index_teacher_user2(Stno);
			session2.setAttribute("index_teacher_user",index_teacher_user);
			resp.sendRedirect("TeacherSelect.jsp");
			
		}
		if(jsp.equals("Student_update_Select")){
			String Stno=req.getParameter("Sno");
			String OCno=req.getParameter("Stname");
			String Cno=req.getParameter("mTeacherStno");
			String Clo=req.getParameter("mTeacherStname");
			UserDAOI user=new UserDaoimp();
			String message=user.updateSelect(Stno,OCno,Cno,Clo);
			UserDAOI user2=new UserDaoimp();
			List<TeacherCourse> StudentCourse = new ArrayList<>();
			StudentCourse =user2.Teacher_SelectCourse();
			session2.setAttribute("Teacher_SelectCourse",StudentCourse);
			resp.sendRedirect("SelectCourse.jsp");
		}
		if(jsp.equals("Student_update_Grade")){
			String Sno=req.getParameter("Sno");
			String Cno=req.getParameter("Cno");
			String Sname=req.getParameter("mTeacherStno");
			String Cname=req.getParameter("mTeacherStname");
			Sname=new String(Sname.getBytes("iso-8859-1"),"utf-8");
			Cname=new String(Cname.getBytes("iso-8859-1"),"utf-8");
			String Scg=req.getParameter("mTeacherSage");
			UserDAOI user=new UserDaoimp();
			user.updateGradeAll(Sno,Cno,Sname,Cname,Scg);
			resp.sendRedirect("Grade.jsp");
		}
		if(jsp.equals("AddStudentInformation")){
			String Sno=req.getParameter("mTeacherStno");
			String Sname=req.getParameter("mTeacherStname");
			Sname=new String(Sname.getBytes("iso-8859-1"),"utf-8");
			String Ssex=req.getParameter("mTeacherSsex");
			Ssex=new String(Ssex.getBytes("iso-8859-1"),"utf-8");
			String Sage=req.getParameter("mTeacherSage");
			String Sdept=req.getParameter("mTeacherSto");
			Sdept=new String(Sdept.getBytes("iso-8859-1"),"utf-8");	
			String Clno=req.getParameter("mClo");
			UserDAOI user=new UserDaoimp();
			String message=user.AddStudentInformation(Sno,Sname,Ssex,Sage,Sdept,Clno);
			System.out.println(message);
			session1.setAttribute("updateStudentInformatio", message);
			UserDAOI user2=new UserDaoimp();
			System.out.println(1);
			List<Student> StudentCourse = new ArrayList<>();
			StudentCourse =user2.index_teacher_StudentInformation();
			session2.setAttribute("index_teacher_StudentInformation",StudentCourse);
			resp.sendRedirect("CrudStudent.jsp");
		}
		if(jsp.equals("AddCourse")){
			String Cno=req.getParameter("mTeacherStno");
			String Cname=req.getParameter("mTeacherStname");
			String Ctime=req.getParameter("mTeacherSsex");
			Cname=new String(Cname.getBytes("iso-8859-1"),"utf-8");
			String Cgrade=req.getParameter("mTeacherSage");
			String Ctype=req.getParameter("mTeacherSto");
			Ctype=new String(Ctype.getBytes("iso-8859-1"),"utf-8");
			UserDAOI user=new UserDaoimp();
			String message=user.AddCourse(Cno,Cname,Cgrade,Ctime,Ctype);
			System.out.println(message);
			session1.setAttribute("updateCourse", message);
			UserDAOI user2=new UserDaoimp();
			List<Course> StudentCourse = new ArrayList<>();
			StudentCourse =user2.StudentSelectCourse();
			session2.setAttribute("Teacher.Course",StudentCourse);
			resp.sendRedirect("Course.jsp");
		}
		if(jsp.equals("AddSelect")){
			String Cname=req.getParameter("mTeacherStno");
			String Ctime=req.getParameter("mTeacherStname");
			String Cgrade=req.getParameter("mTeacherSsex");
			UserDAOI user=new UserDaoimp();
			String message=user.AddSelect(Cname,Ctime,Cgrade);
			resp.sendRedirect("AddSelect.jsp");
		}
		if(jsp.equals("Student_Add_Grade")){
			String Sno=req.getParameter("mSo");
			String Cno=req.getParameter("mCno");
			String Sname=req.getParameter("mTeacherStno");
			String Cname=req.getParameter("mTeacherStname");
			Sname=new String(Sname.getBytes("iso-8859-1"),"utf-8");
			Cname=new String(Cname.getBytes("iso-8859-1"),"utf-8");
			String Scg=req.getParameter("mTeacherSage");
			UserDAOI user=new UserDaoimp();
			user.AddGradeAll(Sno,Cno,Sname,Cname,Scg);
			resp.sendRedirect("Grade.jsp");
		}
		if(jsp.equals("TimeAddGrade")){
			StudentCourse Student=new StudentCourse();
			String Sno=req.getParameter("mSno");
			String Cno=req.getParameter("mCno");
			String Sname=req.getParameter("mTeacherStno");
			String Cname=req.getParameter("mTeacherStname");
			Sname=new String(Sname.getBytes("iso-8859-1"),"utf-8");
			Cname=new String(Cname.getBytes("iso-8859-1"),"utf-8");
			int Scg=Integer.getInteger(req.getParameter("mTeacherSage"));
			Student.setSno(Sno);Student.setCno(Sno);Student.setSname(Sname);
			Student.setCname(Cname);Student.setCgrade(Scg);
			TimeStudent.add(Student);
			this.getServletContext().setAttribute("TimeStudentGrade",TimeStudent);
			resp.sendRedirect("Time.jsp");
		}
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("jdsfadj");
		String Ajsp=req.getParameter("Ajsp");
		session2=req.getSession();
		System.out.println(Ajsp);
		if(Ajsp.equals("main.index")){
			String name=(String)session1.getAttribute("name");
			UserDAOI user=new UserDaoimp();
			List<Student> StudentSelect = new ArrayList<>();
			StudentSelect =user.Studentinformation(name);
			session2.setAttribute("StudentSelect",StudentSelect);
			resp.sendRedirect("../common/StudentSelect.jsp");
			System.out.println("1");	
		}
		if(Ajsp.equals("main.index.course")){
			String name=(String)session1.getAttribute("name");
			UserDAOI user=new UserDaoimp();
			List<StudentCourse> StudentCourse = new ArrayList<>();
			StudentCourse =user.Studentcourse(name);
			String main_Index_message=null;
			String type=req.getParameter("type");
			session2.setAttribute("StudentCourse",StudentCourse);
			if(type.equals("course")){
				main_Index_message="课程";
			}
			if(type.equals("grade")){
				main_Index_message="选课";
			}
			session2.setAttribute("main_Index_message",main_Index_message);
			resp.sendRedirect("../course/Studentcourse.jsp");
			System.out.println("1");	
		}
		if(Ajsp.equals("main.index.select")){
			UserDAOI user=new UserDaoimp();
			List<Course> StudentSelectCourse = new ArrayList<>();
			StudentSelectCourse=user.StudentSelectCourse();
			session2.setAttribute("StudentSelectCourse",StudentSelectCourse);
			resp.sendRedirect("../course/Course_Information.jsp");
			System.out.println("1");	
		}
		if(Ajsp.equals("index(teacher).user")){
			String name=(String)session1.getAttribute("name");
			UserDAOI user=new UserDaoimp();
			List<Teacher> index_teacher_user=new ArrayList<>();
			index_teacher_user=user.index_teacher_user(name);
			session2.setAttribute("index_teacher_user",index_teacher_user);
			resp.sendRedirect("../Teacher/TeacherSelect.jsp");		
		}
		if(Ajsp.equals("index(teacher).StudentInformation")){
			this.Student(req, resp);		
		}
		if(Ajsp.equals("index(teacher).selectCourse")){
			String name=(String)session1.getAttribute("name");
			UserDAOI user=new UserDaoimp();
			List<TeacherCourse> IndexTeacherSelectCourse = new ArrayList<>();
			IndexTeacherSelectCourse =user.IndexTeacherSelectCourse(name);
			session2.setAttribute("IndexTeacherSelectCourse",IndexTeacherSelectCourse);
			resp.sendRedirect("../SelectCourse/Teacher.jsp");
			System.out.println("1");	
		}
		if(Ajsp.equals("CrudStudent")){
			String idall = req.getParameter("idAll");
			System.out.println(idall);
			System.out.println(1);
			String[] idone = idall.split(",");
			for(String string:idone){
				UserDAOI userDAOI = new UserDaoimp();
				userDAOI.delete(string);
			}
			UserDAOI user=new UserDaoimp();
			List<Student> StudentCourse = new ArrayList<>();
			StudentCourse =user.index_teacher_StudentInformation();
			session2.setAttribute("index_teacher_StudentInformation",StudentCourse);
			resp.sendRedirect("CrudStudent.jsp");
			
		}
		if(Ajsp.equals("index(teacher).Student.Grade")){
			this.StudentCourse(req, resp);	
		}
		if(Ajsp.equals("Student.Grade")){
			System.out.println("1");
			String Sno=req.getParameter("sno");
			System.out.println(Sno);
			UserDAOI user=new UserDaoimp();
			List<StudentCourse> StudentCourse = new ArrayList<>();
			StudentCourse =user.Studentcourse1(Sno);
			session2.setAttribute("Student.GradeAll",StudentCourse);	
			resp.sendRedirect("../Student/GradeAll.jsp");
		}
		if(Ajsp.equals("Student.Grade.delete")){
			String idall = req.getParameter("idAll");
			System.out.println(idall);
			System.out.println(1);
			String[] idone = idall.split(",");
			for(String string:idone){
				UserDAOI userDAOI = new UserDaoimp();
				userDAOI.deleteAn(string);
			}
			UserDAOI user=new UserDaoimp();
			List<StudentCourse> StudentCourse = new ArrayList<>();
			StudentCourse =user.Studentcourse();
			session2.setAttribute("IndexTeacherStudentGrade",StudentCourse);
			resp.sendRedirect("../Student/Grade.jsp");
		}
		if(Ajsp.equals("GradeAlldelete")){
			String idall = req.getParameter("idAll");
			System.out.println(idall);
			String[] idone =idall.split(",");
			String[] Sno=new String[idone.length];
			String[] Cno=new String[idone.length];
			System.out.println(idone.length);
			for(int i=0;i<idone.length;i++){
				int leng=idone[i].indexOf(" ");
				Sno[i]=idone[i].substring(0,leng);
				Cno[i]=idone[i].substring(leng+1);
				System.out.println(Sno[i]);
				System.out.println(Cno[i]);
			}
			for(int i=0;i<idone.length;i++){
				UserDAOI user=new UserDaoimp();
				user.deleteAll(Sno[i],Cno[i]);
			}
		}
		if(Ajsp.equals("TeacherInformation")){
			UserDAOI user=new UserDaoimp();
			List<Teacher> TeacherInformation = new ArrayList<>();
			TeacherInformation=user.TeacherInformation();
			session2.setAttribute("TeacherInformation",TeacherInformation);
			resp.sendRedirect("../Teacher/TeacherInformation.jsp");
		}
		if(Ajsp.equals("Teacher.TeacherInformation")){
			String idall = req.getParameter("idAll");
			System.out.println(idall);
			System.out.println(1);
			String[] idone = idall.split(",");
			for(String string:idone){
				UserDAOI userDAOI = new UserDaoimp();
				userDAOI.deleteTeacherInformation(string);
			}
			UserDAOI user=new UserDaoimp();
			List<Teacher> StudentCourse = new ArrayList<>();
			StudentCourse =user.TeacherInformation();
			session2.setAttribute("TeacherInformation",StudentCourse);
			resp.sendRedirect("TeacherInformation.jsp");

		}
		if(Ajsp.equals("index(manager).Course")){
			UserDAOI user=new UserDaoimp();
			List<Course> Teacher_Course = new ArrayList<>();
			Teacher_Course=user.StudentSelectCourse();
			session2.setAttribute("Teacher.Course",Teacher_Course);
			resp.sendRedirect("../Teacher/Course.jsp");
		}
		if(Ajsp.equals("Teacher.Course")){
			String idall = req.getParameter("idAll");
			System.out.println(idall);
			System.out.println(1);
			String[] idone = idall.split(",");
			for(String string:idone){
				UserDAOI userDAOI = new UserDaoimp();
				userDAOI.deleteTeacherCoures(string);
			}
			UserDAOI user=new UserDaoimp();
			List<Course> StudentCourse = new ArrayList<>();
			StudentCourse =user.StudentSelectCourse();
			session2.setAttribute("Teacher.Course",StudentCourse);
			resp.sendRedirect("Course.jsp");
			
		}
		if(Ajsp.equals("index(manager).SelectCourse")){
			UserDAOI user=new UserDaoimp();
			List<TeacherCourse> Teacher_SelectCourse = new ArrayList<>();
			Teacher_SelectCourse=user.Teacher_SelectCourse();
			session2.setAttribute("Teacher_SelectCourse",Teacher_SelectCourse);
			resp.sendRedirect("../Teacher/SelectCourse.jsp");
		}
		if(Ajsp.equals("Teacher_Teacher_SelectCourse")){
			String idall = req.getParameter("idAll");
			System.out.println(idall);
			String[] idone =idall.split(",");
			String[] Sno=new String[idone.length];
			String[] Cno=new String[idone.length];
			System.out.println(idone.length);
			for(int i=0;i<idone.length;i++){
				int leng=idone[i].indexOf(" ");
				Sno[i]=idone[i].substring(0,leng);
				Cno[i]=idone[i].substring(leng+1);
				System.out.println(Sno[i]);
				System.out.println(Cno[i]);
			}
			for(int i=0;i<idone.length;i++){
				UserDAOI user=new UserDaoimp();
				user.deleteSelectCourse(Sno[i],Cno[i]);
			}
			UserDAOI user=new UserDaoimp();
			List<TeacherCourse> StudentCourse = new ArrayList<>();
			StudentCourse =user.Teacher_SelectCourse();
			session2.setAttribute("Teacher_SelectCourse",StudentCourse);
			resp.sendRedirect("SelectCourse.jsp");
		}
		if(Ajsp.equals("ManagerUpdateAjsp")){
			String Stno=req.getParameter("mTeacherStno");
			String Stname=req.getParameter("mTeacherStname");
			Stname=new String(Stname.getBytes("iso-8859-1"),"utf-8");
			String Stsex=req.getParameter("mTeacherSsex");
			Stsex=new String(Stsex.getBytes("iso-8859-1"),"utf-8");
			int Ssage=Integer.getInteger(req.getParameter("mTeacherSage"));
			String Sto=req.getParameter("mTeacherSto");
			Sto=new String(Sto.getBytes("iso-8859-1"),"utf-8");
			Teacher user=new Teacher();
			user.setStno(Stno);
			user.setStno(Stname);
			user.setStsex(Stsex);
			user.setStage(Ssage);
			user.setSto(Sto);
		}
		if(Ajsp.equals("Student.CrudStudent.Select")){
			String Sno=req.getParameter("keywords");
			UserDAOI user=new UserDaoimp();
			List<Student> Student_CrudStudent_Select = new ArrayList<>();
			Student_CrudStudent_Select =user.StudentinformationManager(Sno);
			session2.setAttribute("index_teacher_StudentInformation",Student_CrudStudent_Select);
			resp.sendRedirect("CrudStudent.jsp");
			System.out.println("1");
		}
		if(Ajsp.equals("Teacher_SelectCourse_SelectAll")){
			UserDAOI user=new UserDaoimp();
			List<TeacherCourse> StudentCourse = new ArrayList<>();
			StudentCourse =user.Teacher_SelectCourse();
			session2.setAttribute("Teacher_SelectCourse",StudentCourse);
			resp.sendRedirect("SelectCourse.jsp");
		}
		if(Ajsp.equals("Teacher_Course_SelectAll")){
			UserDAOI user=new UserDaoimp();
			List<Course> StudentCourse = new ArrayList<>();
			StudentCourse =user.StudentSelectCourse();
			session2.setAttribute("Teacher.Course",StudentCourse);
			resp.sendRedirect("Course.jsp");
		}
		if(Ajsp.equals("Teacher_TeacherInformation_SelectAll")){
			UserDAOI user=new UserDaoimp();
			List<Teacher> StudentCourse = new ArrayList<>();
			StudentCourse =user.TeacherInformation();
			session2.setAttribute("TeacherInformation",StudentCourse);
			resp.sendRedirect("TeacherInformation.jsp");
		}
		if(Ajsp.equals("Student_CrudStudent_SelectAll")){
			UserDAOI user=new UserDaoimp();
			System.out.println(1);
			List<Student> StudentCourse = new ArrayList<>();
			StudentCourse =user.index_teacher_StudentInformation();
			session2.setAttribute("index_teacher_StudentInformation",StudentCourse);
			resp.sendRedirect("CrudStudent.jsp");
		}
		if(Ajsp.equals("Teacher_TeacherInformation_Select")){
			String Sno=req.getParameter("keywords"); 
			UserDAOI user=new UserDaoimp();
			List<Teacher> StudentCourse = new ArrayList<>();
			StudentCourse =user.index_teacher_user2(Sno);
			session2.setAttribute("TeacherInformation",StudentCourse);
			resp.sendRedirect("TeacherInformation.jsp");
		}
		if(Ajsp.equals("Teacher_Course_Select")){
			String Sno=req.getParameter("keywords"); 
			UserDAOI user=new UserDaoimp();
			System.out.println(Sno);
			List<Course> StudentCourse = new ArrayList<>();
			StudentCourse =user.Course(Sno);
			session2.setAttribute("Teacher.Course",StudentCourse);
			resp.sendRedirect("Course.jsp");
		}
		if(Ajsp.equals("Student_Grade_Select")){
			String Sno=req.getParameter("keywords"); 
			UserDAOI user=new UserDaoimp();
			List<StudentCourse> StudentCourse = new ArrayList<>();
			StudentCourse =user.StudentcourseSelect(Sno);
			session2.setAttribute("IndexTeacherStudentGrade",StudentCourse);
			resp.sendRedirect("Grade.jsp");
		}
		if(Ajsp.equals("Teacher_SelectCourse_Select")){
			String Stno=req.getParameter("keywords");
			String Cno=req.getParameter("keyword");
			System.out.println(Stno);
			UserDAOI user=new UserDaoimp();
			List<TeacherCourse> StudentCourse = new ArrayList<>();
			StudentCourse =user.IndexTeacherSelectCourse1(Stno,Cno);
			session2.setAttribute("Teacher_SelectCourse",StudentCourse);
			resp.sendRedirect("SelectCourse.jsp");
		}
		if(Ajsp.equals("TimeAddGrade")){
			StudentCourse Student=new StudentCourse();
			String Sno=req.getParameter("mSno");
			String Cno=req.getParameter("mCno");
			String Sname=req.getParameter("Sname");
			String Cname=req.getParameter("Cname");
			Sname=new String(Sname.getBytes("iso-8859-1"),"utf-8");
			Cname=new String(Cname.getBytes("iso-8859-1"),"utf-8");	
			//int Scg=Integer.getInteger(req.getParameter("Scg"));
			String Scg=req.getParameter("Scg");
			System.out.println(Sno+Cno+Sname+Cname+Scg);
			int Sscg=Integer.parseInt(Scg);
			Student.setSno(Sno);Student.setCno(Cno);Student.setSname(Sname);
			Student.setCname(Cname);Student.setCgrade(Sscg);
			TimeStudent.add(Student);
			System.out.println(TimeStudent.size());
			for(int i=0;i<TimeStudent.size();i++){
				System.out.println(((StudentCourse)TimeStudent.get(i)).getCno()+"\t"+((StudentCourse)TimeStudent.get(i)).getSno());
			}
			session2.setAttribute("TimeStudentGrade",TimeStudent);
			resp.sendRedirect("GradeAll.jsp");
		}
	}
	
	public void StudentCourse(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserDAOI user=new UserDaoimp();
		List<StudentCourse> StudentCourse = new ArrayList<>();
		StudentCourse =user.Studentcourse();
		session2.setAttribute("IndexTeacherStudentGrade",StudentCourse);
		resp.sendRedirect("../Student/Grade.jsp");
	}
	public void Student(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
		UserDAOI user=new UserDaoimp();
		List<Student> index_teacher_StudentInformation = new ArrayList<>();
		index_teacher_StudentInformation=user.index_teacher_StudentInformation();
		session2.setAttribute("index_teacher_StudentInformation",index_teacher_StudentInformation);
		resp.sendRedirect("../Student/CrudStudent.jsp");
	}
}

