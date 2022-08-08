package com.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Hello
 */
@WebServlet("/Hello")
public class Hello extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Hello() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		System.out.println("Inside Service method");
		Properties p = new Properties();
		InputStream input=null;
		try
		{ input = 
			    getClass().getClassLoader().getResourceAsStream("prop1.properties");
		
		p.load(input);
		p.list(System.out);
		//Reading each property value
		System.out.println(p.getProperty("name"));
		System.out.println(p.getProperty("surname"));
		}catch(Exception e) {
			System.out.println(e);
		System.out.println("Inside catch");}
		finally {
	        if (input != null) {
	            try {
	                input.close();
	                System.out.println("Inside finally try");
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
