package genericutilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileUtility {
	public String readDataFromPropertyFile(String key) throws IOException {
		FileInputStream fisp=new FileInputStream("C:\\Users\\Admin\\Desktop\\java\\Swaglabs_maven_Hybridframeworks\\src\\test\\resources\\Commondata.properties");
		Properties p=new Properties();
		p.load(fisp);
		return p.getProperty(key);
	}
}
