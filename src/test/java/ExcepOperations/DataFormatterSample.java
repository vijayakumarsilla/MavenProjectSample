package ExcepOperations;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataFormatterSample {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileInputStream fileinput = new FileInputStream(System.getProperty("user.dir")+"\\TestData\\mydata.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fileinput);
		FormulaEvaluator evaluator = wb.getCreationHelper().createFormulaEvaluator();
		XSSFSheet sheet = wb.getSheet("Sheet1");
		
		int rowscnt = sheet.getLastRowNum();
		
		for(int row=0; row<=rowscnt; row++)
		{
			XSSFRow rowline = sheet.getRow(row);
			int colscount = rowline.getLastCellNum();
			
			for(int col=0; col<colscount; col++) 
			{
				XSSFCell cell = rowline.getCell(col);
				DataFormatter data = new DataFormatter();
				
				if(cell.getCellType() == CellType.NUMERIC)				
				{
					
					System.out.print(data.formatCellValue(cell)+"    ");
				} else if (cell.getCellType() == CellType.STRING)
				{
					//System.out.print(cell.toString()+"    ");
					System.out.print(data.formatCellValue(cell)+"    ");
				} else if (cell.getCellType() == CellType.FORMULA)
				{
//					System.out.println(evaluator.evaluateFormulaCell(cell));
					switch (evaluator.evaluateFormulaCell(cell))
					{
					case NUMERIC:
						System.out.println(cell.getNumericCellValue());
					}
				}
			} 
			System.out.println();
		}
		wb.close();
		fileinput.close();
	}

}
