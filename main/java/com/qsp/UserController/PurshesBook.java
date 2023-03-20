package com.qsp.UserController;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import com.qsp.userDAO.BOOKdao;
import com.qsp.userDAO.UserDao;
import com.qsp.userDTO.BOOKDto;
import com.qsp.userDTO.UserDto;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/PurshesBook")
public class PurshesBook extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		String Bid=req.getParameter("id");
		
		int id1=Integer.parseInt(Bid);
		

		UserDto dto = new UserDto();
		UserDao dao = new UserDao();

		BOOKdao bdo = new BOOKdao();
		BOOKDto bdto=new BOOKDto();
		
		bdto.setBid(id1);
		
		
		
		
		
		try
		{
			bdo.updatequentity(bdto);
			pw.print("<script>"
					+ "    alert('Successfully you added the book to the cart....!!!!!')"
					+ "</script>");
			   res.sendRedirect("purshes.html");
		} catch (SQLException e)
		{
			
			e.printStackTrace();
		}



		}
	}
	

