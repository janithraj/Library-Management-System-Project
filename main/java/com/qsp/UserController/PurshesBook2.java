package com.qsp.UserController;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import com.qsp.userDAO.BOOKdao;
import com.qsp.userDTO.BOOKDto;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/PurshesBook2")

public class PurshesBook2 extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		BOOKdao bdo=new BOOKdao();
		pw.print("<style>"
				
						+ "#para1,#para2{"
//						  +"border:1px solid red;"
				      	 +"height:900px;"
						 +"width:400px;"
						 + "color:brown;"
     					 + "background-color:rgb(235, 188, 171) ;"
     					 + "margin-left:30px"
//						
						 
						 
//						 + " text-align: center;"
//						
						 +"}"
						 + "img{"
//						  +"border:1px solid black;"
						  +"height:400px;"
						  +"width:400px;"
						  + "}"
						 
	
						 + "button{"
						 + "height:50px;"
						 + "width:100px;"
						 + ""
						 + "border:none;"
						 + "}"
						 
						 
						 + "#con{"
						
						 + ""
//						 + "  position: absolute;"
						 + "display:;"
						 + ""
						 + "}"
						 
						 
						 + "#container1{"
//						 + " border:4px solid green;"
						 				         

                          + "display: flex;"
				         
				          + " visibility: visible;"
				          
				         
//				          + "height:800px;"
//                         + "display:inline"
						 + "}"
						
						 + "  h2{"
						 + "    padding-left: 70px;"
						 + "color:rgb(60, 59, 59)"
						 + "}"
						 + " button{"
						 + "        background-color:rgb(78, 229, 78) ;"
						 + "        color: white;"
						 + "        border-radius: 10%;"
						 + "      }"
						 + " button:hover{"
						 + "        background-color: rgb(84, 89, 84);"
						 + "        color: rgb(77, 231, 128);"
						 + "        border-radius: 10%;"
						
						 + "    }"
						 + ""
						 + "        #btn2{"
						 + "           width: 200px;"
						 + "           height: 30px;"
						 + "           background-color: rgb(126, 126, 188);"
						 + "           border: none;"
						 + "           margin-left: 70px;"
						 + ""
						 + "        }"
						 + "    a{"
						 + "      text-decoration: none;"
						 + "      color: white;"
						 + ""
						 + "    }"
						 + "    a:hover{"
						 + "      text-decoration: none;"
						 + "      color: rgb(59, 57, 57);"
						 + ""
						 + "    }"
						 + "    h3{"
						 + "        padding-top: 30px;"
						 + "        font-size: 30px;"
						 + "        text-align: center;"
						 + "        color: rgb(124, 70, 45);"
						 + "    }"
						 + ""
			
						 + "</style>"
						);
	 
		
			try {pw.print("<body id='con'>");
				pw.print("<div id='container1'>");
				for (BOOKDto dao2 : bdo.displayall()) 
				  {
					 
					if(dao2.getQuantity()>0){
					pw.print("<div id=para1>");
				   pw.print("<img src='http://localhost:8000/Library_management_system/book/"+dao2.getBname()+".jpeg' alt='image1'>");
					
					pw.print("<form action='PurshesBook'>"
							+ "<pre>"
					
                           + "<h2>"
                           + "BooID           :  "      + dao2.getBid()+"<br>"
                           		+ "<br>"
                           + "BookName        :  "      +dao2.getBname()+"<br>"
                           		+ "<br>"
						   + "AuthorName      :  "      +dao2.getAuthor()+"<br>"
						   		+ "<br>"
						   + "BookPrice       :  "      +dao2.getPrice()+"<br>"
						   		+ "<br>"
						   		
						   		
						   
						   + "BookQuantity    :  "      +dao2.getQuantity()+"<br>"
						   		+ "<br>"
						                 		
						   + "</h2>"
						                 
						                 		
						   + " <input type='text' value='"+dao2.getBid()+"' name='id' hidden>"
						                 + "<button name='"+dao2.getBid()+"' value=''>BUY</button>"
						                 + "</pre>"
						                 + "</form>"
						                 
						                 );
					
				
					
							
					pw.print("</div>");
					
					
					}
					else {
						
						pw.print("<div id='para2'>");
						   pw.print("<img src='http://localhost:8000/Library_management_system/book/"+dao2.getBname()+".jpeg' alt='image1'>");
							
							pw.print("<form action='NoBook.html'>"
									+ "<pre>"
							
		                           + "<h2>"
		                           + "BooID           :  "      + dao2.getBid()+"<br>"
		                           		+ "<br>"
		                           + "BookName        :  "      +dao2.getBname()+"<br>"
		                           		+ "<br>"
								   + "AuthorName      :  "      +dao2.getAuthor()+"<br>"
								   		+ "<br>"
								   + "BookPrice       :  "      +dao2.getPrice()+"<br>"
								   		+ "<br>"
								   		
								   		
								   
								   + "BookQuantity    :No More books "
								                   
								   		+ "<br>"
								                 		
								   + "</h2>"
								                 
								                 		
								   + " <input type='text' value='"+dao2.getBid()+"' name='id' hidden>"
								                 + "<button name='"+dao2.getBid()+"' value='' id='btn1' >BUY</button>"
								                 + "</pre>"
								                 + "</form>"
								                  );		
							pw.print("</div>");
							
					}
					

				
					}
				
				
				
		
				
		
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
			
			pw.print("</div>");
			
			pw.print("    <button style='height: 35px;width: 100px;background-color: rgb(117, 117, 226);border-radius:5px;margin-left: 700px;margin-top: 10px;margin-bottom: 20px;'><a href='LandPage.html'>home</a></button>");
			
			
			
			pw.print("</body>");
			
//			pw.print(" <div id='container2'>"
//					+ "<h3>There is no more <b>Books</b></h3>"
//					+ "<button id='btn2'><a href='PurshesBook2'>Back</a></button>"
//					+ " </div>");  
			
			
			
		

				}
		
		
		
		
		
	}


