package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WritingDataToExcel {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws Exception {
		FileInputStream fis=new FileInputStream("./data/ExcelData.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet s=wb.getSheet("Sheet1");
		Row r=s.createRow(5);
		Cell cell=r.createCell(5);
		cell.setCellValue("Filpkart");
		
		
		
		
		
		
		FileOutputStream fos=new FileOutputStream("./data/ExcelData.xls");
		wb.write(fos);
		wb.close();
		
		
		

	}

}
