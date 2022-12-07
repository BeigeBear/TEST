package ch14_loging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogTest {
	
	public static void main(String[] args) {
		String msg = "Hello log!!";
		Logger logger = LoggerFactory.getLogger(LogTest.class);
		logger.info("test Log");
		logger.warn("test Log : {}", msg);
	}
	
}
