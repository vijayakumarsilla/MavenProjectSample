package ExcepOperations;

import java.io.IOException;

public class xlValidations {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		excelUtility xl = new excelUtility();
		String path = System.getProperty("user.dir")+"\\TestData\\";
		String filename = "mydatacreate.xlsx";
		String filePath = path+filename;
		
		int rowsCount = xl.getRowsCount(filePath, "Sheet1");
		System.out.println("total no of rows "+rowsCount);
		for(int r = 0; r<rowsCount; r++)
		{
			int colscount = xl.getColsCountForRow(filePath, "Sheet1", r);
			for(int c = 0;c<colscount; c++)
			{
				String cellText = xl.getCellValue(filePath, "Sheet1", r, c);
				System.out.print(cellText+"    ");
			}
			System.out.println();
		}
		xl.setCellGreenAndBold(filePath, "Sheet1", 3, 3);
	}

}
