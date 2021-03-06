package com.crm.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase {

	public static long Page_Load_TimeOut = 30;
	public static long Implicit_Wait = 20;
	public static String Test_Data_Sheet_Path = "D:\\Eclipse Workspace\\AutomationTests\\src\\main\\java\\com\\crm\\qa\\testdata\\FreeCRMTestData.xlsx";

	static Workbook book;
	static Sheet sheet;

	public void switchToFrame() {
		driver.switchTo().frame("mainpanel");
	}

	public static Object[][] getTestData(String sheetName) {
		FileInputStream file = null;

		try {
			file = new FileInputStream(Test_Data_Sheet_Path);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		try {

			book = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {

			e.printStackTrace();
		}

		catch (IOException e) {
			e.printStackTrace();
		}

		sheet = book.getSheet(sheetName);

		Object data[][] = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];

		System.out.println(sheet.getLastRowNum() + "--------" + sheet.getRow(0).getLastCellNum());

		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				System.out.println(data[i][k]);
			}
		}

		return data;

	}

	public static void takeScreenShotAtEndOfTest() throws IOException {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currDir = System.getProperty("user.dir");
		FileHandler.copy(src, new File(currDir + "/ScreenShot/" + System.currentTimeMillis() + ".png"));
	}
}
