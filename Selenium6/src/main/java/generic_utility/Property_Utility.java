package generic_utility;

import java.io.FileInputStream;
import java.util.Properties;

public class Property_Utility {

	public String getStringKeyAndValue(String key) throws Throwable {

		FileInputStream fis = new FileInputStream("./src/test/resources/CommonDataVtiger.property");
		Properties p = new Properties();
		p.load(fis);
		String data = p.getProperty(key);
		return data;
	}

}
