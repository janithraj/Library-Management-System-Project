package com.qsp.userDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.qsp.userDTO.AdminDTO;
import com.qsp.userutility.UserUtiliy;

public class AdminDao {
	
	 public boolean adminPasswordMatch(AdminDTO adto) throws Exception {
		   boolean res=true;
		   
		   Connection con=UserUtiliy.getconnection();
		     PreparedStatement pstm=con.prepareStatement("select aid,password from admin where aid=? and password=?");
		     pstm.setInt(1, adto.getAid());
		     pstm.setString(2, adto.getPassword());
		     ResultSet res1=pstm.executeQuery();
		     
		   if(res1.next()) {
			   
			   res=true;
			   
		   }
		   else {
			   res=false;
		   }   
		return res;
		 
	 }



}
