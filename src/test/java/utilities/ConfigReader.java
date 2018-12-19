package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	
	 static Properties pro;

		static {
				pro = new Properties();

			try {
//				NOTE: FileInputStream throws exception, in order to  surround it with try catch it has to be inside of a main method or any other blocks
				//otherwise, it does not allow you to handle the exception. 
				FileInputStream fl = new FileInputStream("config3.properties");
				pro.load(fl);

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		public static String getMyValue(String key) {

			String value = pro.getProperty(key);
			return value;

		}

	}



