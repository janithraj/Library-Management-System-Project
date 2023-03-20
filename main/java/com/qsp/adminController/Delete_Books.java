package com.qsp.adminController;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import com.qsp.adminDAO.AdminDAO;
import com.qsp.adminDTO.AdminDTO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Delete_Books")

public class Delete_Books extends HttpServlet {
	
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter pw=resp.getWriter();
		String bid=req.getParameter("bookid");
		int bid1=Integer.parseInt(bid);
		
		
		AdminDAO dao=new AdminDAO();
		AdminDTO dto=new AdminDTO();
		dto.setBid(bid1);
	     pw.print("<style>"
		    		+ "body{"
		    		+ "background-color: rgb(127, 212, 112);"
		    		+ "}"
		    		
		    		
		    		+ "h2{"
		    		+ "  padding-left: 20px;"
		    		+ "          padding-right: 10px;"
		    		+ "            font-size:25px;"
		    		+ "            font-family: sans-serif;"
		    		+ "            font-weight: bolder;"
		    		+ "            color: brown;"
		    		+ "}"
		    		+ ""
		    		+ "   #div1{"
//		    		+ "        border: 1px solid black ;"
		    		+ "            height: 190px;"
		    		+ "            width: 400px;"
		    		+ "            margin-top: 50px;"
		    		+ "margin-left:80px;"
		    		+ " background-color: antiquewhite;"
		    		+ ""
		    		+ ""
		    		+ "    }"
		    		+ ""
		    	
		    		+ "   #btn2{"
		    		+ "           width: 200px;"
		    		+ "           height: 30px;"
		    		+ "           background-color: rgb(126, 126, 188);"
		    		+ "           border: none;"
		    		+ "           margin-left: 70px;"
		    		+ ""
		    		+ "        }"
		    		+ ""
		    		+ ""
		    		+ "   a{"
		    		+ "      text-decoration: none;"
		    		+ "      color: white;"
		    		+ ""
		    		+ "    }"
		    		+ "    a:hover{"
		    		+ "      text-decoration: none;"
		    		+ "      color: rgb(59, 57, 57);"
		    		+ "    }"
		    	        
		    		+ "</style>");
		
		try {
			if(dao.deletebook(bid1)) {
			
			
				pw.print("   <div id='div1'>"
		    			+ "    <h2>successfully BookItems are Deleted</h2>"
		    			+ "    <button id='btn2'><a href='admin.html'>home</a></button>"
		    			+ "</div>");
				
			}
			else {
				pw.print("   <div id='div1'>"
		    			+ "    <h2> Opps....!!! BookItems are not Deleted</h2>"
		    			+ "    <button id='btn2'><a href='admin.html'>home</a></button>"
		    			+ "</div>");
			}	
	       }
		 catch (SQLException e) {
			 pw.print("   <div id='div1'>"
		    			+ "    <h2> Opps....!!! BookItems are not Deleted</h2>"
		    			+ "    <button id='btn2'><a href='admin.html'>home</a></button>"
		    			+ "</div>");
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		 
		
		
		
		
		
		
		
	}

}
