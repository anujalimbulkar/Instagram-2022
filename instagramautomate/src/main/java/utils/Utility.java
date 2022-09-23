package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.commons.math3.analysis.function.Ceil;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;


public class Utility {
	
	public static String getdatafromsheet(String Sheet, int Row, int Cell ) throws EncryptedDocumentException, IOException {
	
		FileInputStream file = new FileInputStream("C:\\Users\\ADVIKA\\OneDrive\\Documents\\file1.xlsx");
		
		
		Cell cell = WorkbookFactory.create(file).getSheet("Data").getRow(Row).getCell(Cell);
		try {
			String value = cell.getStringCellValue();
		    return value;
		}
		catch(IllegalStateException e) {
			
		
		long value1 = (long)cell.getNumericCellValue();
		String str = String.valueOf(value1);
		
		System.out.println(str);
		return str;
	
	
		}
		
		
		
	   
	}


	
	

	public static void Screenshot(WebDriver driver, String testId) throws IOException
	{
		DateFormat format = new SimpleDateFormat("MM-dd-yyyy HH-mm-ss");
		Date currentdate = new Date();
		String screenshotfile = currentdate.toString().replace(" ", "-").replace(":", "-");
		
		TakesScreenshot take = (TakesScreenshot)driver;
        File src = take.getScreenshotAs(OutputType.FILE);
        File dest = new File("C:\\Users\\ADVIKA\\OneDrive\\Documents\\test1\\img"+testId+" "+screenshotfile+".jpg");
		FileHandler.copy(src, dest);
		
		
	}
}
