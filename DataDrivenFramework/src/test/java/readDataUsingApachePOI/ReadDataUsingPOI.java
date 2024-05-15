package readDataUsingApachePOI;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReadDataUsingPOI {
	
	static List<String> userNameList = new ArrayList<String>();
	static List<String> passWordList = new ArrayList<String>();
	
	public void readExcel() throws IOException {
		FileInputStream excel = new FileInputStream("./src/test/resources/Excel Files/TestDataPOI.xlsx");
		
		Workbook workBook = new XSSFWorkbook(excel);
		
		Sheet sheet = workBook.getSheetAt(0);
		
		Iterator<Row> rowIterator = sheet.iterator();
		
		while(rowIterator.hasNext()) {
			Row rowValue = rowIterator.next();
			Iterator<Cell> columnIterator = rowValue.iterator();
			int i=2;
			while(columnIterator.hasNext()) {
				if(i%2==0) {
					userNameList.add(columnIterator.next().getStringCellValue());
				}else {
					passWordList.add(columnIterator.next().getStringCellValue());
				}
				i++;
			}
		}
	}
		public void login(String email,String pWord) {
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demowebshop.tricentis.com/login");
		
		WebElement emailTF = driver.findElement(By.id("Email"));
		emailTF.sendKeys(email);
		
		WebElement passWord = driver.findElement(By.id("Password"));
		passWord.sendKeys(pWord);
		
		WebElement loginButton = driver.findElement(By.className("login-button"));
		
		driver.quit();
	}
	
	public void executeTest() {
		for(int i=0;i<userNameList.size();i++) {
			login(userNameList.get(i),passWordList.get(i));
		}
	}
	public static void main(String[] args) throws IOException {
		ReadDataUsingPOI usingPOI = new ReadDataUsingPOI();
		usingPOI.readExcel();
		System.out.println("UserName List "+userNameList);
		System.out.println("Password List "+passWordList);
		usingPOI.executeTest();
	}
}
