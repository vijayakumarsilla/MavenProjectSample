package ExcepOperations;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CreateExcel {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileOutputStream file = new FileOutputStream(System.getProperty("user.dir")+"\\TestData\\mydatacreate.xlsx");
		
		XSSFWorkbook wb = new XSSFWorkbook();		
		XSSFSheet ws = wb.createSheet("Sheet1");
		XSSFRow rowline = ws.createRow(0);
		
		rowline.createCell(0).setCellValue("Name");
		rowline.createCell(1).setCellValue("Salary");
		
		wb.write(file);
		wb.close();
	}

}
