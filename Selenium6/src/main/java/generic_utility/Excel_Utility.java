package generic_utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_Utility {

	/**
	 * @author maity this method is used to fetch the data from the Excel
	 * @param sheet
	 * @param rowNum
	 * @param cellNum
	 * @return String
	 * @throws Throwable
	 */

	public String getExcelData(String sheet, int rowNum, int cellNum) throws Throwable {

		FileInputStream fis = new FileInputStream("./src/test/resources/TestData.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Sheet sh = book.getSheet(sheet);
		Row row = sh.getRow(rowNum);
		Cell cell = row.getCell(cellNum);
		String data = cell.getStringCellValue();
		return data;

	}

	/**
	 * @author maity this method is used to fetch the data from the Excel
	 * @param sheet
	 * @param rowNum
	 * @param cellNum
	 * @return String
	 * @throws Throwable
	 */

	public String getExcelUsingDataFormatter(String sheet, int rowNum, int cellNum) throws Throwable {

		FileInputStream fis = new FileInputStream("./src/test/resources/TestData.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		DataFormatter format = new DataFormatter();
		String data = format.formatCellValue(book.getSheet(sheet).getRow(rowNum).getCell(cellNum));
		return data;
	}
	
	
	
	public Object[][] getMultipleInput(String SheetName) throws Throwable{
		FileInputStream fis=new FileInputStream("./src/test/resources/TestData.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		
		Sheet sh = book.getSheet(SheetName);
		
		int rowCount=sh.getLastRowNum()+1;
		int cellCount=sh.getRow(0).getLastCellNum();
		
		Object[][] obj=new Object[rowCount][cellCount];
		for(int  i=0;i<rowCount;i++) {
			for (int j = 0; j < cellCount; j++) {
				obj[i][j]=sh.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return obj;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

//	public Object[][] getMultipleInputsFromExcel(String sheet) throws Throwable {
//
//		FileInputStream fis = new FileInputStream("./src/test/resources/TestData.xlsx");
//		Workbook book = WorkbookFactory.create(fis);
//
//		Sheet sh = book.getSheet(sheet);
//		int lastRow = sh.getLastRowNum() + 1;
//		int lastCell = sh.getRow(0).getLastCellNum();
//
//		Object[][] obj = new Object[lastRow][lastCell];
//		for (int i = 0; i < lastRow; i++) {
//			for (int j = 0; j < lastCell; j++) {
//				obj[i][j] = sh.getRow(i).getCell(j).getStringCellValue();
//			}
//		}
//		return obj;
//	}

	public Object[][] readMultipleData(String sheet) throws Throwable {
		FileInputStream fis = new FileInputStream("./src/test/resources/TestData.xlsx");
		Workbook book = WorkbookFactory.create(fis);

		Sheet sh = book.getSheet(sheet);
		int lastRow = sh.getLastRowNum() + 1;
		int lastCell = sh.getRow(0).getLastCellNum();
		DataFormatter format = new DataFormatter();
		Object[][] obj = new Object[lastRow][lastCell];
		for (int i = 1; i < lastRow; i++) {
			for (int j = 0; j < lastCell; j++) {

				obj[i][j] = format.formatCellValue(book.getSheet(sheet).getRow(i).getCell(j));
			}
		}
		return obj;

	}

}
