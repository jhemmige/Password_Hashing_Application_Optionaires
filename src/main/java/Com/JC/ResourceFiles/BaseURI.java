package Com.JC.ResourceFiles;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;
//import static io.restassured.RestAssured.given;

import org.apache.log4j.xml.DOMConfigurator;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;





public class BaseURI {
	
	public static Payload pl;
	
	public static String getBaseURI(String keyvalue) throws IOException {
		
		
		Properties prop= new Properties();
		String Filepath = "/Users/jayashreehemmige/eclipse-workspace/JumpCloud_RestAPI/src/main/java/Com/JC/ResourceFiles/Global.properties";
		FileInputStream fis= new FileInputStream(Filepath);
		prop.load(fis);
		
		return prop.getProperty(keyvalue);
		
		
			
			
		
		
	}

}
