package com.qsp.userDTO;

public class BOOKDto {
	
	int bid;
	String bname;
	String author;
	double price;
	int quantity;
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return " bid=" + bid + "\n bname=" + bname + "\n author=" + author + "\n price=" + price + "\n quantity="
				+ quantity + "";
	}
	
	
	
	

}
