package com.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.bean.Student;

public class StudentDao {

	public static Connection getConnection() {
		Connection con = null;
		try {
			 // driver registration
			Class.forName("com.mysql.jdbc.Driver");
			
			// open connection with database named <test>,
			// Studentname =root
			// password = ""
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_crud", "root", ""); // open connection
		} catch (Exception e) {
			System.out.println(e);
		}
		return con;
	}
	
	
	public static List<Student> getAllRecords() {
		List<Student> list = new ArrayList<Student>();
		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement("select * from register");
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				Student u = new Student();
				u.setId(rs.getInt("id"));
				u.setName(rs.getString("name"));
				u.setPassword(rs.getString("password"));
				u.setEmail(rs.getString("email"));
				u.setSex(rs.getString("sex"));
				u.setCountry(rs.getString("country"));
				list.add(u);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}
	
	public static int save(Student u) {
		int status = 0;
		try {
			Connection con = getConnection();
			PreparedStatement ps = con
					.prepareStatement("insert into register(name,password,email,sex,country) values(?,?,?,?,?)");
			ps.setString(1, u.getName());
			ps.setString(2, u.getPassword());
			ps.setString(3, u.getEmail());
			ps.setString(4, u.getSex());
			ps.setString(5, u.getCountry());
			status = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}

	public static int update(Student u) {
		int status = 0;
		try {
			Connection con = getConnection();
			PreparedStatement ps = con
					.prepareStatement("update register set name=?,password=?,email=?,country=? where id=?");
			ps.setString(1, u.getName());
			ps.setString(2, u.getPassword());
			ps.setString(3, u.getEmail());
			ps.setString(4, u.getCountry());
			ps.setInt(5, u.getId());
			status = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}

	public static int delete(Student u) {
		int status = 0;
		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement("delete from register where id=?");
			ps.setInt(1, u.getId());
			status = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}

		return status;
	}



public static Student getRecordById(int id) {
	Student u = null;
	try {
		Connection con = getConnection();
		PreparedStatement ps = 
		con.prepareStatement("select * from register where id=?");
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			u = new Student();
			u.setId(rs.getInt("id"));
			u.setName(rs.getString("name"));
			u.setPassword(rs.getString("password"));
			u.setEmail(rs.getString("email"));
			u.setSex(rs.getString("sex"));
			u.setCountry(rs.getString("country"));
		}
	} catch (Exception e) {
		System.out.println(e);
	}
	return u;
}

}
