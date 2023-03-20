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

@WebServlet("/loginservlet")
public class loginservlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		String mail = req.getParameter("mailid");
		String password = req.getParameter("password");

		UserDto dto = new UserDto();
		UserDao dao = new UserDao();
		dto.setEmail(mail);
		dto.setPassword(password);
		BOOKdao bdo = new BOOKdao();
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
			
			if (dao.passwordmatch(dto)) {
				
				res.sendRedirect("LoginToPurchesLayer.html");
				
				
		        
//
			}
			
			
			else {

				pw.print("   <div id='div1'>"
		    			+ "    <h2> Opps....!!! Invalid Details.</h2>"
		    			+ "    <button id='btn2'><a href='LandPage.html'>home</a></button>"
		    			+ "</div>");

				}
			}
		 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
	

