package learning;
	import org.apache.poi.ss.usermodel.*;
	import org.apache.poi.xssf.usermodel.XSSFWorkbook;
    import org.openqa.selenium.WebDriver;
    import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.FileInputStream;
	import java.io.FileOutputStream;
	import java.io.IOException;

	public class Utilityfiles {
		
	    private static Workbook workbook;
	    private static Sheet sheet;

	    public static void setExcelFile(String path, String sheetName) throws IOException {
	        FileInputStream excelFile = new FileInputStream(path);
	        workbook = new XSSFWorkbook(excelFile);
	        sheet = workbook.getSheet(sheetName);
	    }

	    public static String getCellData(int rowNum, int colNum) {
	        Cell cell = sheet.getRow(rowNum).getCell(colNum);
	        return cell.getStringCellValue();
	    }

	    public static void setCellData(String data, int rowNum, int colNum) throws IOException {
	        Row row = sheet.getRow(rowNum);
	        Cell cell = row.createCell(colNum);
	        cell.setCellValue(data);
	        FileOutputStream fileOut = new FileOutputStream("src/test/resources/registrationData.xlsx");
	        workbook.write(fileOut);
	        fileOut.close();
	    }
	    private static WebDriver driver;

	    public static WebDriver getDriver() {
	        if (driver == null) {
	        	//WebDriverManager.chromedriver().driverPath("/path/to/your/workspace/driver_folder").setup();
	        	System.setProperty("webdriver.chrome.driver", "C:\\eclipseTesting\\automationtraining\\TestAutomationjava\\chromedriver.exe");
	        	WebDriverManager.chromedriver().setup();
	        	driver = new ChromeDriver();
	            driver.manage().window().maximize();
	        }
	        return driver;
	    }

	    public static void tearDown() {
	        if (driver != null) {
	            driver.quit();
	            driver = null;
	        }
	    }
	}
	


