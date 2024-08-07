package com.kwd.utilities;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtilities {

	FileInputStream file;
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	XSSFCell cell;
	public static String locatorColumnValue;
	public static String locatorName;
	public static String locatorValue;
	public static String keywordColumnValue;
	public static String dataColumnValue;
	public static int totalRows;
	
	public void readExcelFile(String location) throws IOException {
		//file location

		file = new FileInputStream(location);

		workbook = new XSSFWorkbook(file);

		sheet = workbook.getSheet("Sheet1");
		
		totalRows=sheet.getLastRowNum();

	}

	public void getLocatorsKeywordsAndData(int row,int locatorColumn,int keywordColumn,int dataColumn) {

		
		locatorColumnValue=sheet.getRow(row).getCell(locatorColumn).toString().trim();
		
		if(!locatorColumnValue.contains("NA")) {
		locatorName = locatorColumnValue.split(":")[0].toString().trim();
		locatorValue = locatorColumnValue.split(":")[1].toString().trim();
		}else {
			locatorName="NA";
			locatorValue="NA";
		}
		
		
		keywordColumnValue=sheet.getRow(row).getCell(keywordColumn).toString().trim();
		
		dataColumnValue=sheet.getRow(row).getCell(dataColumn).toString().trim();
		
		
		System.out.println(locatorName +" : "+locatorValue +" Keyword : "+keywordColumnValue+
			"Data : "+dataColumnValue );
		
	}


}
