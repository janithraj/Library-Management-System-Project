package com.qsp.usertest;

import java.sql.Connection;
import java.sql.SQLException;

import com.qsp.userDAO.BOOKdao;
import com.qsp.userDTO.BOOKDto;
import com.qsp.userutility.UserUtiliy;

public class testjdbac {
	
	public static void main(String[] args) throws SQLException {
		
		
//	System.out.println(UserUtiliy.getconnection());
		
//		Connection con=UserUtiliy.getconnection();
		
		BOOKDto dto=new BOOKDto();
		BOOKdao dao=new BOOKdao();
		System.out.println(dao.displayall());
		
		
	
		
	
	
		
		
		
		
		
	}
	


}
