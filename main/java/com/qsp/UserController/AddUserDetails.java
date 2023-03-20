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


@WebServlet("/AddUserDetails")
public class AddUserDetails extends HttpServlet {
	
  


	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		               String mail=req.getParameter("mailid");
		               String password=req.getParameter("password");
		               String contact1=req.getParameter("contactno");
		               int contact=Integer.parseInt(contact1);
		               String name=req.getParameter("name");
		               
		               
		               UserDto dto=new  UserDto();
		               UserDao dao=new  UserDao();
		               dto.setEmail(mail);
		               dto.setName(name);
		               dto.setPassword(password);
		               dto.setContactno(contact1);
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
//					    		+ "        border: 1px solid black ;"
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
		            	   
						if(dao.RegisterUserDetails(dto)) {
							
							pw.print("   <div id='div1'>"
					    			+ "    <h2>successfully added the user details.</h2>"
					    			+ "    <button id='btn2'><a href='PurshesBook2'>Purcheses</a></button>"
					    			+ "</div>");
							
						}
						else {
							pw.print("   <div id='div1'>"
					    			+ "    <h2> Opps....!!! the user details are not added.</h2>"
					    			+ "    <button id='btn2'><a href='LandPage.html'>home</a></button>"
					    			+ "</div>");
						}
					} catch (SQLException e) {
						pw.print("   <div id='div1'>"
				    			+ "    <h2> Opps....!!! Invalid Details.</h2>"
				    			+ "    <button id='btn2'><a href='LandPage.html'>home</a></button>"
				    			+ "</div>");
						e.printStackTrace();
					}
		               
		      
		
		
		
		
		
	
		
		
	}

	


}
