package com.qsp.adminController;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.SQLException;

import com.qsp.adminDAO.AdminDAO;
import com.qsp.adminDTO.AdminDTO;
import com.qsp.userDAO.AdminDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Addbooks")

public class Addbooks extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter pw=resp.getWriter();
		    String bid=req.getParameter("bookid");
		    int bid1=Integer.parseInt(bid);
		    String bname=req.getParameter("bname");
		    String author=req.getParameter("authorname");
		    String price=req.getParameter("bookprice");
		    double price1=Double.parseDouble(price);
		    String quantity=req.getParameter("bookquantity");
		    int quantity1=Integer.parseInt(quantity);
		    
		    
		   AdminDTO dto=new AdminDTO ();
		   
		   AdminDAO dao=new  AdminDAO();
		     dto.setBid(bid1);
		     dto.setBname(bname);
		     dto.setAuthor(author);
		     dto.setPrice(price1);
		     dto.setQuanity(quantity1);
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
//			    		+ "        border: 1px solid black ;"
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
				if(dao.addbookitems(dto)) {
					 
			    	pw.print("   <div id='div1'>"
			    			+ "    <h2>successfully BookItems are Added</h2>"
			    			+ "    <button id='btn2'><a href='admin.html'>home</a></button>"
			    			+ "</div>");
					 
				 }
				else {
					pw.print("   <div id='div1'>"
			    			+ "    <h2> Opps....!!! BookItems are not Added</h2>"
			    			+ "    <button id='btn2'><a href='AddBook_items.html'>home</a></button>"
			    			+ "</div>");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				pw.print("   <div id='div1'>"
		    			+ "    <h2> Opps....!!! BookItems are not Added</h2>"
		    			+ "    <button id='btn2'><a href='AddBook_items.html'>home</a></button>"
		    			+ "</div>");
				e.printStackTrace();
			}
		     
		       
		   
		    
		    
		    
		    
		
		
		
		
		
		
	}

}
