package com.qsp.userDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.qsp.userDTO.BOOKDto;
import com.qsp.userDTO.UserDto;
import com.qsp.userutility.UserUtiliy;

public class BOOKdao {
	
	public List<BOOKDto>displayall() throws SQLException{
		
		List<BOOKDto> li=new ArrayList<>();
		
		Connection con=null;
	con=UserUtiliy.getconnection();
	PreparedStatement pstm=con.prepareStatement("select * from book");
	     ResultSet rst=pstm.executeQuery();
	     
	    
	     while(rst.next()) {
	    	 BOOKDto dto=new BOOKDto();
	    	  dto.setBid(rst.getInt(1));
	    	  dto.setBname(rst.getString(2));
	    	  dto.setAuthor(rst.getString(3));
	    	  dto.setPrice(rst.getDouble(4));
	    	  dto.setQuantity(rst.getInt(5));
	    	  li.add(dto);
	    	         
	}
	     return li;	

	}
	
	
//	  boolean checkquentity(BOOKDto dto) throws SQLException {
//		  
//		  Connection con=null;
//			con=UserUtiliy.getconnection();
//			PreparedStatement pstm=con.prepareStatement("select * from book where  Quanity>=1 and bid=?");
//			pstm.setInt(1,dto.getBid());
//		   ResultSet rst=pstm.executeQuery();
//		   
//			    
//		  
//	  }
	
	
	
	
	
	
	
	
	
	public boolean updatequentity(BOOKDto dto) throws SQLException {
		
		
		Connection con=null;
		con=UserUtiliy.getconnection();
		PreparedStatement pstm=con.prepareStatement("update book set Quanity=Quanity-1 where bid=?");
		pstm.setInt(1,dto.getBid());
		int nor=pstm.executeUpdate();
		if(nor==1) {
			return true;
		}
		else {
			return false;
		}
		
		
		
		
		
		
	}
	
	
	
	 
		
	}
	
	
	
	
	
	
	
	
	
	


