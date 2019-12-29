package com.saptrv;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.util.Base64;

public class Food_Dao {
	public String getBaseString(Blob blob) {
		String base64Image = null;
		try {
			InputStream inputStream = blob.getBinaryStream();
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	        byte[] buffer = new byte[4096];
	        int bytesRead = -1;
	         
	        while ((bytesRead = inputStream.read(buffer)) != -1) {
	            outputStream.write(buffer, 0, bytesRead);                  
	        }
	         
	        byte[] imageBytes = outputStream.toByteArray();
	        base64Image = Base64.getEncoder().encodeToString(imageBytes);
			
	        if(base64Image != null)
	        	return base64Image;
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return base64Image;
		
		
	}
}
