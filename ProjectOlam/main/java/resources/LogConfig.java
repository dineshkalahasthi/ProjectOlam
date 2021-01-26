package resources;

import java.io.File;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.status.StatusLogger;


public class LogConfig {
	
	/* Configuration */
	static {
		/* Turning off the default status logging in console */
		StatusLogger.getLogger().setLevel(Level.OFF);
		
		/* The following code sets the path for the log4j2 configuration file */
		/* Default path is the project's src folder */
		String configPath = LogConfig.class.getResource("/resources/log4j2.xml").getPath();
		((LoggerContext) LogManager.getContext(false)).setConfigLocation(new File(configPath).toURI());
	}
	
	/* Use this method to get the logger object */
	public static Logger getLogger(Class<?> clazz) {
		return LogManager.getLogger(clazz);
	}
}
