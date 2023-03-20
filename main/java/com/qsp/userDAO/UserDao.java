package com.qsp.userDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.qsp.userDTO.UserDto;
import com.qsp.userutility.UserUtiliy;

public class UserDao {
	
	
	public boolean RegisterUserDetails(UserDto dto) throws SQLException {
		
		Connection con=null;
		con=UserUtiliy.getconnection();
		PreparedStatement pmt=con.prepareStatement("insert into usertable  value(?,?,?,?)");
		pmt.setString(1, dto.getEmail());
		pmt.setString(2, dto.getPassword());
		pmt.setString(3, dto.getContactno());
		pmt.setString(4, dto.getName());
		
		pmt.executeUpdate();
		int nro=pmt.getUpdateCount();
		
		if(nro==1) {
			
			return true;
		}
		else {
			return false;
		}
	}
		
		public boolean  passwordmatch(UserDto dto) throws SQLException {
			
			Connection con=null;
			con=UserUtiliy.getconnection();
			PreparedStatement pstm=con.prepareStatement("select email,password from usertable where email=? and password=?");
		pstm.setString(1, dto.getEmail());
		pstm.setString(2, dto.getPassword());
		ResultSet rs= pstm.executeQuery();
		
		
		if(rs.next()) {
			return true;
		}
		else {
			return false;
		}
		
	}
		
		
		
		
		
	public boolean  userpasswordmatch(UserDto dto) throws SQLException {
			
			Connection con=null;
			con=UserUtiliy.getconnection();
			PreparedStatement pstm=con.prepareStatement("select password from usertable where password=?");
		pstm.setString(1, dto.getPassword());
		ResultSet rs= pstm.executeQuery();
		
		
		if(rs.next()) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
	
public boolean  userpasswordUpdate(UserDto dto) throws SQLException {
		
		Connection con=null;
		con=UserUtiliy.getconnection();
		PreparedStatement pstm=con.prepareStatement("update usertable set  password=? where email=?");
	pstm.setString(1, dto.getPassword());
	pstm.setString(2, dto.getEmail());
	int rs= pstm.executeUpdate();
	
	
	if(rs==1) {
		return true;
	}
	else {
		return false;
	}
	
}
	
	
		
		
		
		

}
