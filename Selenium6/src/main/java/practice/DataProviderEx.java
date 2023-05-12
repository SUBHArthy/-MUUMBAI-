package practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import generic_utility.Excel_Utility;

public class DataProviderEx {

	@Test(dataProvider = "dataProviderEx")
	public void bookTickets(String src, String dest) {
		System.out.println("book tickets from " + src + " to " + dest);
	}

	@DataProvider
	public Object[][] dataProviderEx() throws Throwable {

		Excel_Utility ex = new Excel_Utility();
		String data = ex.getExcelData("DataProvider", 0, 0);
		String data1 = ex.getExcelData("DataProvider", 0, 1);
		String data2 = ex.getExcelData("DataProvider", 1, 0);
		String data3 = ex.getExcelData("DataProvider", 1, 1);
		String data4 = ex.getExcelData("DataProvider", 2, 0);
		String data5 = ex.getExcelData("DataProvider", 2, 1);

		Object[][] obj = new Object[3][2];
		obj[0][0] = data;
		obj[0][1] = data1;

		obj[1][0] = data2;
		obj[1][1] = data3;

		obj[2][0] = data4;
		obj[2][1] = data5;

		return obj;

	}
}
