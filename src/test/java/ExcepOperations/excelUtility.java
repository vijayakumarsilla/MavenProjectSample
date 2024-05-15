package ExcepOperations;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xslf.usermodel.XSLFSheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelUtility {
	public FileInputStream fis;
	public FileOutputStream fos;
	public XSSFWorkbook wb;
	public XSSFSheet ws;
	public XSSFRow row;
	public XSSFCell cell;
	public CellStyle cellstyle;
	public DataFormatter dtformat;
	
	public int getRowsCount(String filePath, String sheetName) throws IOException
	{
		fis = new FileInputStream(filePath);
		wb = new XSSFWorkbook(fis);
		ws = wb.getSheet(sheetName);
		int rowsCount = ws.getLastRowNum();		
		wb.close();
		fis.close();
		return rowsCount;
	}
	
	public int getColsCountForRow(String filePath, String sheetName, int rownum) throws IOException
	{
		fis = new FileInputStream(filePath);
		wb = new XSSFWorkbook(fis);
		ws = wb.getSheet(sheetName);
		int colsCount = ws.getRow(rownum).getLastCellNum();
		wb.close();
		fis.close();		
		return colsCount;
	}
	
	public String getCellValue(String filePath, String sheetName, int rownum, int colnum) throws IOException
	{
		fis = new FileInputStream(filePath);
		wb = new XSSFWorkbook(fis);
		ws = wb.getSheet(sheetName);
		cell = ws.getRow(rownum).getCell(colnum);
		dtformat = new DataFormatter();
		FormulaEvaluator fe = wb.getCreationHelper().createFormulaEvaluator();
//		String cellValue = dtformat.formatCellValue(cell);
		try
		{
			switch (cell.getCellType())
			{
				case FORMULA:
					return fe.evaluate(cell).formatAsString();
				default:
					dtformat = new DataFormatter();					
//					System.out.println(dtformat.formatCellValue(cell));
					return dtformat.formatCellValue(cell);
			}			
		}
		finally
		{
			wb.close();
			fis.close();				
		}	
	}
	
	public void writeCellValue(String filePath, String sheetName, int rownum, int colnum, String cellsetvalue) throws IOException
	{
		fos = new FileOutputStream(filePath);
		wb = new XSSFWorkbook();
		ws = wb.getSheet(sheetName);
		cell = ws.getRow(rownum).getCell(colnum);
		cellstyle = wb.createCellStyle();
//		cellstyle.setFillForegroundColor(IndexedColors.GREEN.getIndex());
//		cellstyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
//		cell.setCellStyle(cellstyle);
		wb.write(fos);
		wb.close();
		fos.close();				
	}
	
	public void setCellGreenAndBold(String filePath, String sheetName, int rownum, int column) throws IOException
	{
		fos = new FileOutputStream(filePath);
		wb = new XSSFWorkbook();
		ws = wb.getSheet(sheetName);
		cell = ws.getRow(rownum).getCell(column);
		cellstyle = wb.createCellStyle();
		cellstyle.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		cellstyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		cell.setCellStyle(cellstyle);
		wb.write(fos);
		wb.close();
		fos.close();
	}
}
