package com.hr.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

public class ResponseUtil {
	public static void jump(HttpServletResponse response,String alertName,String url){
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out;
		try {
			out = response.getWriter();
			
			out.print("<script>");
			out.print("alert('"+alertName+"');");
			out.print("location.href='"+url+"'");
			out.print("</script>");
			
			out.flush();
			
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
