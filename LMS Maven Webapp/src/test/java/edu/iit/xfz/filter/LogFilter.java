package edu.iit.xfz.filter;

import java.util.Date;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

//Implements Filter class
public class LogFilter implements Filter {
	public void init(FilterConfig config) throws ServletException {
		// Get init parameter
		String testParam = config.getInitParameter("test-param");
		// Print the init parameter
		System.out.println("Test Param: " + testParam);
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws java.io.IOException, ServletException {

		// Get the IP address of client machine.
		String ipAddress = request.getRemoteAddr();

		// Log the IP address and current timestamp.
		System.out.println("IP " + ipAddress + ", Time " + new Date().toString() + "port:" + request.getRemotePort()+
							""+request.getAttributeNames().toString());
		
		Enumeration<String> headerNames = request.getAttributeNames();
	      
	      while(headerNames.hasMoreElements()) {
	         String paramName = (String)headerNames.nextElement();
	         System.out.print("[" + paramName + ":");
	         String paramValue = (String) request.getAttribute(paramName);
	         System.out.println(" " + paramValue + "]");
	      }

		// Pass request back down the filter chain
		chain.doFilter(request, response);
	}

	public void destroy() {
		/*
		 * Called before the Filter instance is removed from service by the web
		 * container
		 */
	}
}