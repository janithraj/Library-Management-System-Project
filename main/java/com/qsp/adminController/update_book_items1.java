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

@WebServlet("/update_book_items1")

public class update_book_items1 extends HttpServlet {
	
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter pw=resp.getWriter();
		String bid=req.getParameter("bookid");
		int bid1=Integer.parseInt(bid);
		
		
		AdminDAO dao=new AdminDAO();
		AdminDTO dto=new AdminDTO();
		
		pw.print("<style>"
				+ "   form{\r\n"
				+ "            border: 1px solid black;\r\n"
				+ "            height: 500px;\r\n"
				+ "            width: 400px;\r\n"
				+ " background-color: rgb(184, 181, 130);"
				+ "margin-left: 300px;"
				+ " margin-top: 150px;"
				+ "        }"
				+ "h2{"
				+ "display:inline;"
				+ "padding-left:20px;"
				+ " font-family: sans-serif;"
				+ "    font-size: large;"
				+ "    color: rgb(74, 73, 73);"
				+ "line-height: 80px;"
				
				+ "}"
				+ ""
				+ ""
				+ "     input{\r\n"
				+ "    height: 30px;\r\n"
				+ "    width: 200px;\r\n"
				+ "    font-size: medium;\r\n"
				+ "    font-family: sans-serif;\r\n"
				+ "    color: rgb(110, 27, 27);\r\n"
				+ "    border-color:rgb(110, 27, 27) ;\r\n"
				+ "    border-radius: 5px;\r\n"
				+ "  }\r\n"
				+ "\r\n"
				+ "  input:focus{\r\n"
				+ "    background-color: bisque;\r\n"
				+ "  }"
				+ ""
				+ "    button{\r\n"
				+ "        height: 30px;\r\n"
				+ "        width: 300px;\r\n"
				+ "        background-color: rgb(48, 48, 211);\r\n"
				+ "        border-radius: 10px;\r\n"
				+ "        border-color: blue;\r\n"
				+ "        color: white;\r\n"
				+ "        font-family: sans-serif;\r\n"
				+ "margin-left:60px;"
				+ "    font-size: large;\r\n"
				+ "    }\r\n"
				+ "    button:hover{\r\n"
				
				+ "        background-color: rgb(176, 176, 241);\r\n"
				+ "        border-radius: 10px;\r\n"
				+ "        background-color: rgb(58, 58, 60);\r\n"
				+ "        color: rgb(233, 222, 209);\r\n"
				+ "        font-family: sans-serif;\r\n"
				+ "    font-size: large;\r\n"
				+ "    border-color: rgb(14, 14, 15);\r\n"
				+ "    }"
				+ "       body{\r\n"
				+ "        background-attachment: fixed;\r\n"
				+ "        height: 800px;\r\n"
				+ "        background-color: rgb(145, 225, 92);\r\n"
				+ "    }"
				+ ""
				+ ""
				+ ""
				+ "</style>");
		dto.setBid(bid1);
		
		
		
		try {
			AdminDTO dto1=dao.searchbook(dto);
			if(dto1!=null) {
				
				pw.print("<form action='update_book_items2'>"
						+ "<pre>"
						+ "<h2>BookID</h2>           :  <input type='number' required='required' name='bookid' value='"+dto.getBid()+"' readonly=\readonly\"><br>"
						+ "<h2>Book Name</h2>        :  <input type='text' placeholder='Book Name' required='required' name='bname'><br>"
						+ "<h2>Author Name</h2>      :  <input type='text' placeholder='enter your Author Name' required='required' name='authorname'><br>"
						+ "<h2>Book Price</h2>       :  <input type='number' placeholder='enter your Book Price' required='required' name='bookprice'><br>"
						+ "<h2>Book Quantity</h2>    :  <input type='number' placeholder='enter your Quantity ' required='required' name='bookquantity'><br>"
						                        + "<button>Submit</button>");
				
				
			}
			else {
				
				pw.print("<h2> Oops Something went wrong.....!!!</h2>");
			}
		      
	       }
		 catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		 
		
		
		
		
		
		
		
	}

}
