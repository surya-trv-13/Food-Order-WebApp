package com.saptrv;


import java.io.IOException;
import java.sql.Blob;
import java.util.Base64;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialBlob;


@WebServlet("/FoodToCart")
public class FoodToCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public FoodToCart() {
        super();
        
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("inside post");
		String name=request.getParameter("foodName");
		String type=request.getParameter("foodType");
		float pay=Float.parseFloat(request.getParameter("price"));
		
		String string=request.getParameter("image");
		byte[] decodedByte = Base64.getDecoder().decode(string);
		Blob image = null;
		try {
			image = new SerialBlob(decodedByte);
		} catch (Exception e1) {
			e1.printStackTrace();
		} 
		
		
		
		FoodToCartBean ff=new FoodToCartBean();
		ff.setImage(image);
		ff.setName(name);
		ff.setPay(pay);
		ff.setType(type);
		
		try {
			ff.valid();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
