package com.qsp.UserController;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import com.qsp.userDAO.UserDao;
import com.qsp.userDTO.UserDto;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/PasswordChange")
public class PasswordChange extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
				
	PrintWriter pw= resp.getWriter();
	     String email= req.getParameter("email");
	    String password1=req.getParameter("pass1");
	    String password2=req.getParameter("pass2");
	    
	    UserDao dao=new UserDao();
	    UserDto dto=new UserDto();
	    dto.setPassword(password1);
	    
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
//	    		+ "        border: 1px solid black ;"
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
			if(dao.userpasswordmatch(dto)) {
				
				 UserDto dto1=new UserDto();
				    dto1.setEmail(email);
				    dto1.setPassword(password2);
				    if(dao.userpasswordUpdate(dto1)) {
				    	
				    	pw.print("   <div id='div1'>"
				    			+ "    <h2>successfully password changed</h2>"
				    			+ "    <button id='btn2'><a href='LoginToPurchesLayer.html'>home</a></button>"
				    			+ "</div>");
				    	
				    	
				    }
				    else {
				    	
				    	pw.print("   <div id='div1'>"
				    			+ "    <h2> Opps....!!!Not successfully password changed</h2>"
				    			+ "    <button id='btn2'><a href='LoginToPurchesLayer.html'>home</a></button>"
				    			+ "</div>");
				    }	
				    	
			}
			else {
				pw.print("   <div id='div1'>"
		    			+ "    <h2> Opps....!!!Not successfully password changed</h2>"
		    			+ "    <button id='btn2'><a href='LoginToPurchesLayer.html'>home</a></button>"
		    			+ "</div>");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
		
		
		
	
	}

}
