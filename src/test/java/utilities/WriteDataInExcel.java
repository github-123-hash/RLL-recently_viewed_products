package utilities;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteDataInExcel {

	public static void main(String args[]) throws IOException {
		
		XSSFWorkbook workbook=new XSSFWorkbook();
		
		XSSFSheet sheet=workbook.createSheet("mysheet");
		
		Object[][] data= {{"Name","Location"},
				{"Asish5","jjkr"},{"Asish5","jjkr2"},
				{"Asish6","jjkr3"},{"Asish6","jjkr4"}
		};
		
		
		int rowLength=data.length;
		int col=data[0].length;
		
		for (int i = 0; i < rowLength; i++) {//to go to row
			
			XSSFRow row=sheet.createRow(i);
			
			//create columns
			for (int j = 0; j < col; j++) {
				
				XSSFCell cell=row.createCell(j);
				Object cellValue=data[i][j];//get value from data array
				cell.setCellValue((String)cellValue);//insert value in each cell
			}
			
			String excelpath="C:\\Users\\shaik\\OneDrive\\Desktop\\mytestdata\\testdata.xlsx";
			File file=new File(excelpath);
			FileOutputStream fso=new FileOutputStream(file);
			workbook.write(fso);
			
		}
		
			workbook.close();
		
	}
	
}
