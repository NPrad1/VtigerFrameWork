package comcast.vtiger.genericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_utility {
	
	public String getExcelData(String sheetName,int rowNum,int cellNum) throws Throwable {
		FileInputStream fis=new FileInputStream("./data/ExcelData.xlsx");
		Workbook book=WorkbookFactory.create(fis);
		/*
		Sheet sheet=book.getSheet(sheetName);
		Row row=sheet.getRow(rowNum);
		Cell cell=row.getCell(cellNum);
		String data = cell.getStringCellValue();
		return data;
		*/
		DataFormatter format=new DataFormatter();
		return format.formatCellValue(book.getSheet(sheetName).getRow(rowNum).getCell(cellNum));
	}
	/*used to write data in excel file
	 * @param SheetName
	 * @param rowNum
	 * @param cellNum
	 * @param Data
	 */
	public void setDataExcel(String SheetName,int rowNum,int cellNum,String data) throws Throwable {
		FileInputStream fis=new FileInputStream("./data/ExcelData.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(SheetName);
		Row r=sh.getRow(rowNum);
		Cell c=r.createCell(cellNum);
		c.setCellValue(data);
		FileOutputStream fos=new FileOutputStream("./data/ExcelData.xlsx");
		wb.write(fos);
		wb.close();
		
	}
	/* used to get last used row number in Sheet
	 * @param sheetName
	 */
	
	public int getRowCount(String sheetName) throws Throwable {
		FileInputStream fis=new FileInputStream("./data/ExcelData.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheetName);
		wb.close();
		return sh.getLastRowNum();
		
	}

}
