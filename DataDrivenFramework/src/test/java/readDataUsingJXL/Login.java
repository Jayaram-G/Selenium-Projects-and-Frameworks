package readDataUsingJXL;
import java.io.FileInputStream;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class Login {
	WebDriver driver;
	String [][] data = null;
	
	@DataProvider(name="loginData")
	public String[][] loginDataProvider() throws BiffException, IOException{
		data=getExcelData();
		return data;
	} 
	
	public String[][] getExcelData() throws BiffException, IOException {
		
		FileInputStream excel = new FileInputStream("./src/test/resources/Excel Files/TestDataJXL.xls");
		
		Workbook workBook = Workbook.getWorkbook(excel);
		
		Sheet sheet = workBook.getSheet(0);
		
		int rowCount = sheet.getRows();
		
		int columnCount = sheet.getColumns();
		
		String testData [][] = new String[rowCount-1][columnCount];
		
		for(int i=1;i<rowCount;i++) {
			for(int j=0;j<columnCount;j++) {
				testData[i-1][j]= sheet.getCell(j, i).getContents();
			}
		}
		return testData;
	}
	
	@BeforeTest
	public void beforeTest() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@AfterTest
	public void afterTest() {
		driver.quit();
	}
	
	
	@Test(dataProvider = "loginData")
	public void login(String email,String pWord)  {
		
		driver.get("https://demowebshop.tricentis.com/login");
		
		WebElement emailTF = driver.findElement(By.id("Email"));
		emailTF.sendKeys(email);
		
		WebElement passWord = driver.findElement(By.id("Password"));
		passWord.sendKeys(pWord);
		
		WebElement loginButton = driver.findElement(By.className("login-button"));
		
	}

}
