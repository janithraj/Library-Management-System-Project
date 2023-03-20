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

@WebServlet("/Search_book")

public class Search_Books extends HttpServlet {
	
	
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
//	    		    + "        border: 1px solid black ;"
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
		    		+ "img{        "
//		    		+ "border: 1px solid black ;"
		    		+ "        height: 400px;"
		    		+ "        width: 500px;"
		    		+ "  }"
		    		+ ""
		    		+ "   #container1{"
//		    		+ "        border: 1px solid black ;"
		    		+ "        height: 680px;"
		    		+ "        width: 500px;"
		    		+ "        margin-left: 300px;"
		    		+ " background-color: rgb(217, 201, 181);"
		    		+ "}"
		    		+ "  h3{"
		    			    		
		    		+ "   font-size: 25px;"
		    		+ " line-height: 45px;"
		    		    		
		    		+ "   font-family: sans-serif;"
		    		+ "    font-weight: bolder;"
		    		+ "	color: brown;"
		    		+ "padding-left: 50px;"
		    	
		    		+" }"
		    		+ ""
		    		+ ""
		    		+ "  #btn{\r\n"
		    		+ "            height: 30px;\r\n"
		    		+ "        width: 200px;\r\n"
		    		+ "        margin-left:400px;"
		    		+ "        background-color: rgb(48, 48, 211);\r\n"
		    		+ "        border-radius: 10px;\r\n"
		    		+ "        border-color: blue;\r\n"
		    		+ "        color: white;\r\n"
		    		+ "        font-family: sans-serif;\r\n"
		    		+ "    font-size: large;\r\n"
		    		
		    		+ " }"
		    		
		    		
		    		
		    		
		    		+ "        #btn:hover{\r\n"
		    		
		    		+ "        border-radius: 10px;\r\n"
		    		+ "        background-color: rgb(58, 58, 60);\r\n"
		    	
		    		+ "        font-family: sans-serif;\r\n"
		    		+ "    font-size: large;\r\n"
		    		+ "    border-color: rgb(14, 14, 15);\r\n"
		    		+ "    }" 
		    		+ "</style>");
		  
		  
	 
		
		try {
			
				 AdminDTO dao2=dao.searchbook(dto); 
			
			
			
	if(dao2!=null) {
		if(dao2.getQuanity()>0) {
			pw.print("<div id=container1>");
				
			pw.print(" <img src='http://localhost:8000/Library_management_system/book/"+dao2.getBname()+".jpeg' alt='image"+dao2.getBname()+"'>");
			
pw.print("<h3>"
		+ "BookID        : "+dao2.getBid()+"<br>"
		+ " BookName     : "+dao2.getBname()+"<br>"
	    + " Book Author  : "+dao2.getAuthor()+"<br>"
		+ " Book Price   : "+dao2.getPrice()+"<br>"
	    + " Book Quantity: "+dao2.getQuanity()+
	    "</h3>");




pw.print("</div>");	}
		else {
			pw.print("<div id=container1>");
			pw.print(" <img src='http://localhost:8000/Library_management_system/book/"+dao2.getBname()+".jpeg' alt='image"+dao2.getBname()+"'>");
			
			pw.print("<h3>"
					+ "BookID         : "+dao2.getBid()+"<br>"
					+ " BookName      : "+dao2.getBname()+"<br>"
				    + " Book Author   : "+dao2.getAuthor()+"<br>"
					+ " Book Price    : "+dao2.getPrice()+"<br>"
				    + " Book Quantity : No More Books"
				    +"</h3>"
				    + "</div>");
			
		}	
		pw.print("    <button id='btn'><a href='admin.html'>home</a></button>");
	
	}
			else {
				pw.print("   <div id='div1'>"
		    			+ "    <h2> Opps....!!! BookItems are not Shows</h2>"
		    			+ "    <button id='btn2'><a href='SearchBook.html'>home</a></button>"
		    			+ "</div>");
			}	
	       }
		 catch (SQLException e) {
				pw.print("   <div id='div1'>"
		    			+ "    <h2> Opps....!!! BookItems are not Shows </h2>"
		    			+ "    <button id='btn2'><a href='SearchBook.html'>home</a></button>"
		    			+ "</div>");
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		 
		
		
		
		
		
		
		
	}

}
