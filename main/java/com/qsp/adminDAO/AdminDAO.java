package com.qsp.adminDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.qsp.adminDTO.AdminDTO;
import com.qsp.userutility.UserUtiliy;

public class AdminDAO {
	
	public boolean addbookitems(AdminDTO dto) throws SQLException {
		boolean res=true;
		Connection con=UserUtiliy.getconnection();
		PreparedStatement pstm=con.prepareStatement("insert into book values(?,?,?,?,?)");
		pstm.setInt(1, dto.getBid());
		pstm.setString(2, dto.getBname());
		pstm.setString(3, dto.getAuthor());
		pstm.setDouble(4, dto.getPrice());
		pstm.setInt(5, dto.getQuanity());
		int nor=pstm.executeUpdate();
		
		if(nor==1) {
			
			res=true;
			
		}
		else {
			
			res=false;
		}
		return res;	
	}

	
	public AdminDTO searchbook(AdminDTO dto) throws SQLException {
		
		Connection con=UserUtiliy.getconnection();
		PreparedStatement pstm=con.prepareStatement("select* from book where bid=?");
		pstm.setInt(1, dto.getBid());
	
		ResultSet resl=pstm.executeQuery();
		
		if(resl.next()) {
			dto=new AdminDTO();
			dto.setBid(resl.getInt(1));
			dto.setBname(resl.getString(2));
			dto.setAuthor(resl.getString(3));
			dto.setPrice(resl.getDouble(4));
			dto.setQuanity(resl.getInt(5));
			
			
			
		}
		else
		{
			dto = null;
		}
		return dto;
		}
	public boolean deletebook(int id) throws SQLException {
		
		boolean res=true;
		Connection con=UserUtiliy.getconnection();
		PreparedStatement pstm=con.prepareStatement("delete from book where bid=?");
		pstm.setInt(1,id);
		int nor=pstm.executeUpdate();
		if(nor==1) {
			
			res=true;
		}
		else {
			
			res=false;
		}	
		return res;	
	}
	
	public List<AdminDTO> displayall() throws SQLException {
		List<AdminDTO>li=new ArrayList();
		AdminDTO dto=new AdminDTO();
		Connection con=UserUtiliy.getconnection();
		PreparedStatement pstm=con.prepareStatement("select* from book");
	
	
		ResultSet resl=pstm.executeQuery();
		
		
		while(resl.next()) {
			dto=new AdminDTO();
			dto.setBid(resl.getInt(1));
			dto.setBname(resl.getString(2));
			dto.setAuthor(resl.getString(3));
			dto.setPrice(resl.getDouble(4));
			dto.setQuanity(resl.getInt(5));
			li.add(dto);
			
			
		}
		return li;
		}
	
	public boolean update(AdminDTO dto) throws SQLException {
		
		boolean res=true;
		
		Connection con=UserUtiliy.getconnection();
		PreparedStatement pstm=con.prepareStatement("update book set bname=?,author=?,price=?,Quanity=? where bid=?");
		pstm.setInt(5, dto.getBid());
		pstm.setString(1, dto.getBname());
		pstm.setString(2, dto.getAuthor());
		pstm.setDouble(3, dto.getPrice());
		pstm.setInt(4, dto.getQuanity());
		int nor=pstm.executeUpdate();
		if(nor==1) {
			
			res=true;
		}
		else {
			
			res=false;
		}	
		return res;		
	}
		
		
		
		
		
		
		
		
		
		
		
		
		
	
		
		
		
		
		
	
	
	
	
	
}
