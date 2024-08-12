package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.poi.EncryptedDocumentException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.apache.poi.ss.usermodel.Sheet;

public class ReadXLSdata {
	
  


	@DataProvider(name="bvtdata")
	public Object[][] getData (Method m) throws EncryptedDocumentException, IOException
	{
		String excelSheetName = m.getName();
		System.out.println(excelSheetName);
		File f = new File(System.getProperty("user.dir")+"\\src\\test\\resources\\Testdata.xlsx");
		FileInputStream fis = new FileInputStream(f);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		//Workbook wb = WorkbookFactory.create(fis);
		Sheet sheetName = wb.getSheet(excelSheetName);
		
		int totalRows = sheetName.getLastRowNum();
		System.out.println(totalRows);
		
		Row rowCells = sheetName.getRow(0);
		int totalcols = rowCells.getLastCellNum();
		System.out.println(totalcols);
		
		DataFormatter format = new DataFormatter();
		
		Object[][] data = new Object [totalRows][totalcols];
		for (int i =1; i<=totalRows; i++) {
			for (int j=0; j<totalcols; j++) {
				data[i-1][j]= format.formatCellValue(sheetName.getRow(i).getCell(j));
				System.out.println(data[i-1][j]);
		
			}
		
			}
		return data;
		
		
	}

		}
