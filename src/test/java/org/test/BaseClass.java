package org.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;

	public static void launchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	public static void windowMaximize() {
		driver.manage().window().maximize();
	}
	public static void launchUrl(String url) {
		driver.get(url);
	}
	public static String pageTitle() {
		String title = driver.getTitle();
		System.out.println(title);
		return title;
	}
	public static String pageUrl() {
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
		return currentUrl;
	}
	public static void passText(String txt, WebElement ele) {
		ele.sendKeys(txt);
	}
	public static void closeEntireBrowser() {
		driver.quit();
	}
	public static void clickBtn(WebElement ele) {
		ele.click();
	}
	public static void screenShot(String imgName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File image = ts.getScreenshotAs(OutputType.FILE);
		File f = new File("location+ imgName.png");
		FileUtils.copyFile(image, f);
	}
	public static Actions a;
	
	public static void moveTheCursor(WebElement targetWebElement) {
		a = new Actions(driver);
		a.moveToElement(targetWebElement).perform();
	}
	public static void dragDrop(WebElement dragWebElement, WebElement dropElement) {
		a = new Actions(driver);
		a.dragAndDrop(dragWebElement, dropElement).perform();
	}
	public static JavascriptExecutor js;
	
	public static void scrollThePage(WebElement tarwebEle) {
		js = (JavascriptExecutor)driver;
		js.executeScript("aguments[0].scrollIntoView(false)", tarwebEle);
	}
	public static void scroll(WebElement element) {
		js = (JavascriptExecutor)driver;
		js.executeScript("aguments[0].scrollIntoView(false)", element);
	}
	public static void excelread(String sheetName, int rowNum, int cellNum) throws IOException {
		File f = new File("excellocation.xlsx");
		FileInputStream fis = new FileInputStream(f);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("Data");
		XSSFRow row = sheet.getRow(rowNum);
		XSSFCell cell = row.getCell(cellNum);
		int cellType = cell.getCellType();
		
		String value = " ";
		if (cellType == 1) {
			String value2 = cell.getStringCellValue();
		}
		else if (DateUtil.isCellDateFormatted(cell)) {
			Date d = cell.getDateCellValue();
			SimpleDateFormat s = new SimpleDateFormat(value);
			String format = s.format(d);	
		}
		else {
			double dou = cell.getNumericCellValue();
			long l = (long) dou;
			String valueOf = String.valueOf(l);	
		}
		
	}	
		
	public static void createNewExcelFile(int rowNum, int cellNum, String writeData) throws IOException {
		File f = new File("C:\\Users\\LENOVO\\eclipse-workspace\\MavenProject\\Excel\\SampleNew.xlsx");
		XSSFWorkbook w = new XSSFWorkbook();
		XSSFSheet newsheet = w.getSheet("Datas");
		XSSFRow newrow = newsheet.getRow(rowNum);
		XSSFCell newcell = newrow.getCell(cellNum);
		newcell.setCellValue(writeData);
		FileOutputStream fos = new FileOutputStream(f);
		w.write(fos);
		
	}
	public static void createcell(int getRow, int creCell, String newData) throws IOException {
		File f = new File("C:\\Users\\LENOVO\\eclipse-workspace\\MavenProject\\Excel\\SampleNew.xlsx");
		FileInputStream fis = new FileInputStream(f);
		XSSFWorkbook w = new XSSFWorkbook(fis);
		XSSFSheet s = w.getSheet("Datas");
		XSSFRow r = s.createRow(getRow);
		XSSFCell c = r.createCell(creCell);
		c.setCellValue(newData);
		FileOutputStream fos = new FileOutputStream(f);
		w.write(fos);

	}
	public static void createRow(int creRow, int creCell, String newData) throws IOException {
		File f = new File("C:\\Users\\LENOVO\\eclipse-workspace\\MavenProject\\Excel\\SampleNew.xlsx");
		FileInputStream fis = new FileInputStream(f);
		XSSFWorkbook w = new XSSFWorkbook(fis);
		XSSFSheet s = w.getSheet("Datas");
		XSSFRow r = s.createRow(creRow);
		XSSFCell c = r.createCell(creCell);
		c.setCellValue(newData);
		FileOutputStream fos = new FileOutputStream(f);
		w.write(fos);
	}
	public static void updateDataToParticularCell(int getTheRow, int getTheCell, String existingData, String writeNewData) throws IOException {
		File f = new File("C:\\Users\\LENOVO\\eclipse-workspace\\MavenProject\\Excel\\SampleNew.xlsx");
		FileInputStream fis = new FileInputStream(f);
		XSSFWorkbook w = new XSSFWorkbook(fis);
		XSSFSheet s = w.getSheet("Datas");
		XSSFRow r = s.getRow(getTheRow);
		XSSFCell c = r.getCell(getTheCell);
		String value = c.getStringCellValue();
		if (value.equals(existingData)) {
			c.setCellValue(writeNewData);	
		}
		FileOutputStream fos = new FileOutputStream(f);
		w.write(fos);

	}
}
