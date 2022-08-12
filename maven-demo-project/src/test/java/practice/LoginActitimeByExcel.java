package practice;


import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginActitimeByExcel {

	public static void main(String[] args) throws Exception {
		
		
		FileInputStream fis=new FileInputStream("./data/ExcelData.xlsx");
		//open workbook in read mode
		Workbook wb=WorkbookFactory.create(fis);
		
		//get the control of the sheet-1
	Sheet	sh=wb.getSheet("Sheet1");
	
	//get the Control of the row
	Row row=sh.getRow(1);
	
	//get the Control of the cell
	Cell cell=row.getCell(0);
	String cellValue = cell.getStringCellValue();
	System.out.println(cellValue);
	
			

	}

}
