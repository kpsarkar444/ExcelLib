package LoginCode;


import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelLib 
{
	FileInputStream fis=null;
	XSSFWorkbook wb=null;
	XSSFSheet sh=null;
	
	public ExcelLib(String excelpath) throws Exception
	{
		fis=new FileInputStream(excelpath);
		wb=new XSSFWorkbook(fis);
		
	}
	
	public String getData(String sheetname, int rownum, int colnum)
	{
		sh=wb.getSheet(sheetname);
		String value = sh.getRow(rownum).getCell(colnum).getStringCellValue();
		return value;
	}
	
	public int getRow(String sheetname)
	{
		int lastrow = wb.getSheet(sheetname).getLastRowNum();
		lastrow=lastrow+1;
		return lastrow;
	}

}
