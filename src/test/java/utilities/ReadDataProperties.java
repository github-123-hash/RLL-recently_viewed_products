package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadDataProperties {
	
	 Properties properties = new Properties();
     FileInputStream input = null;

	
	public  String getData(String path) throws IOException {
		
		  input = new FileInputStream("D:\\DemoWebShop-Group-3-RLL\\DemoWebShop-Group-3-RLL\\src\\test\\java\\properties\\data.properties");
		  properties.load(input);
		  
		//  Properties file in Selenium separate test data from the code, making it easy to modify test data without changing the underlying logic.
		//  Using properties files reduces the dependency on the development team, as non-technical users can update test data.
		  //The java.util.Properties class in Selenium allows loading and retrieving values from properties files.
		  //Loading a properties file involves creating a Properties object and using the load() method with a FileInputStream.
		//  Values can be retrieved from the properties file using the getProperty() method based on the associated keys.
		//  Retrieved values can be used in Selenium test scripts to perform actions such as navigating to URLs or populating form fields.

     // Retrieving values from properties file
     
     String data = properties.getProperty(path);

     return data;
	}
	
	
}
	
