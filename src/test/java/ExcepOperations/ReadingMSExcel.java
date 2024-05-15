package ExcepOperations;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadingMSExcel {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileInputStream file1 = new FileInputStream(System.getProperty("user.dir")+"\\TestData\\mydata.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(file1);
		XSSFSheet ws = wb.getSheet("Sheet1");
		XSSFSheet ws1 = wb.getSheetAt(1);
		//System.out.println(wb.getNumberOfSheets());
		System.out.println("no of rows "+ws.getLastRowNum());
		System.out.println("no of cells "+ws.getRow(0).getLastCellNum());
		
		int rowscnt = ws.getLastRowNum();
		
		for (int row=0;row<=rowscnt;row++)		
		{
			
			XSSFRow rowLine = ws.getRow(row);
			int cellcnt = rowLine.getLastCellNum();
			for (int col=0; col<cellcnt; col++)
			{
				XSSFCell CellText = rowLine.getCell(col);
				
				String cellvalue = CellText.toString();
				//String cellvalue = CellText.getStringCellValue();
				System.out.print(cellvalue+"    ");
			}
			System.out.println();
		}
		wb.close();
	}

}
