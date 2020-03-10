package com.crm.qa.util;

import java.io.File;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import com.crm.qa.base.TestBase;
import org.apache.commons.io.FileUtils;
public class TestUtil extends TestBase {

	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 20;

//	public static String TESTDATA_SHEET_PATH = "F:\\Ecilpse_Workspace\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\testdata";
//	public static String File_Name = "FreeCRMTestData.xlsx";
//	public static String Sheet_Name = "contacts";
//	
	public static String TESTDATA_SHEET_PATH = "F:\\Ecilpse_Workspace\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\testdata";
	public static String File_Name = "FreeCRMTestData.xlsx";
	public static String Sheet_Name = "Deals";

	static Workbook book;
	static Sheet sheet;

	
	

	public void switchToFrame() {
		driver.switchTo().frame("mainpanel");
	}
	
	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	}

/*	public static Object[][] getTestData(String sheetName) throws IOException{

	    File file = new File(TESTDATA_SHEET_PATH+"\\"+File_Name);
	    FileInputStream inputStream = new FileInputStream(file);
	    Workbook guru99Workbook = null;
	    guru99Workbook = new XSSFWorkbook(inputStream);
	    Sheet contactsSheet = guru99Workbook.getSheet(sheetName);
	    int rowCount = contactsSheet.getLastRowNum() - contactsSheet.getFirstRowNum();
	    int colCount = contactsSheet.getRow(0).getLastCellNum();
	    Object[][] data = new Object[rowCount][colCount];

	    for (int i = 1; i < rowCount+1; i++) {
	        Row row = contactsSheet.getRow(i);
	        for (int j = 0; j < colCount; j++) {
	        	data[i-1][j] = row.getCell(j).getStringCellValue();
	        	System.out.println(data[i-1][j]);
	        }
	        }
	    return data;
	    } */
	 
public static Object[][] getTestData(String sheetName) throws IOException{

    File file = new File(TESTDATA_SHEET_PATH+"\\"+File_Name);
    FileInputStream inputStream = new FileInputStream(file);
	    Workbook guru99Workbook = null;
	    guru99Workbook = new XSSFWorkbook(inputStream);
	    Sheet DealsSheet = guru99Workbook.getSheet(sheetName);
	    int rowCount = DealsSheet.getLastRowNum() - DealsSheet.getFirstRowNum();
	    int colCount = DealsSheet.getRow(0).getPhysicalNumberOfCells();
	    Object[][] data = new Object[rowCount][colCount];

    for (int i = 1; i < rowCount+1; i++) {
        Row row = DealsSheet.getRow(i);
        for (int j = 0; j < colCount; j++) {
        	data[i-1][j] = GetValue(row.getCell(j));
       	System.out.println(data[i-1][j]);
        }
    }
    return data;
}
public void Checking() {
	
}


public static String GetValue(Cell cell)
{
	DataFormatter df = new DataFormatter();
	return df.formatCellValue(cell);
}


	
  
  public static boolean VerifyDataExists(String tableXpath, String colName, String expectedValue)
	{
		boolean flag = false;
		int index = GetColumnIndex(tableXpath,colName);
		WebElement WebTable = driver.findElement(By.xpath(tableXpath));
		List<WebElement> rows = WebTable.findElements(By.tagName("tr"));
		for(int i=4; i<=rows.size()-1; i++)
		{
			List<WebElement> cols = rows.get(i).findElements(By.tagName("td"));
				String colValue = cols.get(index).getText();
				colValue = colValue.trim();
				if(colValue.equals(expectedValue))
				{
					flag = true;
					break;
				}
		}
		return flag;
	}
	
	public static int GetColumnIndex(String tableXpath, String colName)
	{
		int index = 0;
		boolean flag = false;
		WebElement WebTable = driver.findElement(By.xpath(tableXpath));
		List<WebElement> rows = WebTable.findElements(By.tagName("tr"));
		for(int i=1; i<=rows.size()-1; i++)
		{
			List<WebElement> cols = rows.get(i).findElements(By.tagName("td"));
			for(int j=0; j<cols.size(); j++)
			{
				String colValue = cols.get(j).getText();
				
				if(colValue.equals(colName))
				{
					index = j;
					flag = true;
					break;
				}
	        }
			if(flag)
			break;
		}
		return index;
}

	
	

	
//	public static void VerifyDataExists(String tableXpath )
//	{
//		WebElement WebTable = driver.findElement(By.xpath(tableXpath));
//		
//		WebElement rows=driver.findElement(By.xpath("//*[@id=\"vContactsForm\"]/table/tbody/tr[7]"));
//		String rowtext = WebTable.getText();
//		 System.out.println("Third row of table : "+rowtext);
//		 WebElement cell=driver.findElement(By.xpath("//*[@id=\"vContactsForm\"]/table/tbody/tr[8]/td[2]"));
//		 String value = cell.getText();
//		    System.out.println("Cell value is : " + value); 
//		
//	}
//	
}	