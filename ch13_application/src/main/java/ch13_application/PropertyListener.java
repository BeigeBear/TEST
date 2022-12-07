package ch13_application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class PropertyListener implements ServletContextListener {
	
	public PropertyListener() {}

	public void contextInitialized(ServletContextEvent arg0) {
		ServletContext ctx = arg0.getServletContext();
		String file = ctx.getInitParameter("propfile");
		
			Properties p = new Properties();
			
			try {
				p.load(new FileInputStream(file));
			}
			catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			catch (IOException e) {
				e.printStackTrace();
			}
			ctx.setAttribute("prop", p);
	}
	
	public void contextDestroyed(ServletContextEvent arg0) {}
	
}
