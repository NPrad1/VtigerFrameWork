package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadFirstAndSecondColumnExcel {

	public static void main(String[] args) throws Exception {
		
		FileInputStream fis=new FileInputStream("./data/ExcelData.xlsx");
		//open workbook in read mode
		Workbook wb=WorkbookFactory.create(fis);
		
		//get the control of the sheet-1
	Sheet	sh=wb.getSheet("Sheet1");
	
	//Geting No of rows
	int lRowNo = sh.getLastRowNum();  
	for(int i=0;i<lRowNo;i++) {
	//get the Control of the row
	Row row=sh.getRow(i);
	
	//get the Control of the cell
	Cell cell=row.getCell(0);
	Cell cell1=row.getCell(1);
	String cellvalue = cell.getStringCellValue();
	String cellvalue1 = cell1.getStringCellValue();
	System.out.println(cellvalue);
	System.out.println(cellvalue1);
	}
	

	}

}
