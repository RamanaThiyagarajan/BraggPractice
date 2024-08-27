package BraggIndia.dataDriven;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Exceldriven {
	

	public ArrayList<String> getData(String TestcaseName) throws IOException {
		// TODO Auto-generated method stub
		
		ArrayList<String> a = new ArrayList<String>();
		FileInputStream fis = new FileInputStream("D:\\Copy of ExcelDemo.xlsx"); 
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		int sheets = workbook.getNumberOfSheets();
		for(int i=0; i<sheets; i++) {
			if(workbook.getSheetName(i).equalsIgnoreCase("testdata")) {
				XSSFSheet sheet =workbook.getSheetAt(i);
				Iterator<Row> rows = sheet.rowIterator();
				Row firstrow = rows.next();
			   Iterator<Cell> ce= firstrow.cellIterator();
			   int column= 0;
			   int k=0;
			   while(ce.hasNext()) {
				   Cell value = ce.next();				   
				   if(value.getStringCellValue().equalsIgnoreCase("Testcase")) {
					   column=k;
				   }
				   k++;
			   }
			   System.out.println(column);
			   while(rows.hasNext()) {
				   Row r = rows.next();
				   if(r.getCell(column).getStringCellValue().equalsIgnoreCase(TestcaseName)) {
					  Iterator<Cell> cell= r.cellIterator();
					  while(cell.hasNext()) {
						 Cell c= cell.next();
						 if(c.getCellType()==CellType.STRING) {
							 a.add(c.getStringCellValue());
						 }else {
							a.add(NumberToTextConverter.toText(c.getNumericCellValue()));
						 }
					  }
				   }
			   }
			}
		}
		return a;
		
	}

}
