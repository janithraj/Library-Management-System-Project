package com.qsp.UserController;

import java.io.IOException;
import java.io.PrintWriter;

import com.qsp.userDAO.AdminDao;
import com.qsp.userDTO.AdminDTO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/AdminController")
public class AdminController extends HttpServlet{
	
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		PrintWriter pw=resp.getWriter();
		                String aid1=req.getParameter("aid");
		                int aid2=Integer.parseInt(aid1);
		                
		                String password1=req.getParameter("password");
		                AdminDTO adto=new AdminDTO();
		                AdminDao adao=new  AdminDao();
		                    adto.setAid(aid2);
		                    adto.setPassword(password1);
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
//						    		+ "        border: 1px solid black ;"
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
								if(adao.adminPasswordMatch(adto)) {
									  
									  
									  resp.sendRedirect("admin.html");
								  }
								
									
									else {
										
										pw.print("   <div id='div1'>"
								    			+ "    <h2> Opps....!!! Invalid Details.</h2>"
								    			+ "    <button id='btn2'><a href='LandPage.html'>home</a></button>"
								    			+ "</div>");
										
									}
							
							} catch (Exception e) {
								pw.print("   <div id='div1'>"
						    			+ "    <h2> Opps....!!! Invalid Details.</h2>"
						    			+ "    <button id='btn2'><a href='LandPage.html'>home</a></button>"
						    			+ "</div>");
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						
						
		                
		                
		                
		                
		
		
	}

}
