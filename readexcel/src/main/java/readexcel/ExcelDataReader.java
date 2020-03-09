package readexcel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataReader {

	public static int countNullHireDate = 0;
	public static int countNullEmpId = 0;
	
	public static void main(String[] args) throws FileNotFoundException, IOException{
		
		
		readFromExcel("C:/Users/sanjasha/Documents/Telstra/sampledata_read.xlsx");
		
		write_baeldung();
        

	}
	
	 private static void write_baeldung() {
		 Workbook workbook = new XSSFWorkbook();
		 
		 Sheet sheet = workbook.createSheet("Results");
		 sheet.setColumnWidth(0, 6000);
		 sheet.setColumnWidth(1, 4000);
		  
		 Row header = sheet.createRow(0);  
		  
		 Cell headerCell = header.createCell(0);
		 headerCell.setCellValue("Hire_Date");
		  
		 headerCell = header.createCell(1);
		 headerCell.setCellValue("Emp Id");
		 
		 Row row2 = sheet.createRow(1);  
		  
		 headerCell = row2.createCell(0);
		 headerCell.setCellValue(countNullHireDate);
		  
		 headerCell = row2.createCell(1);
		 headerCell.setCellValue(countNullEmpId);
		 
		 FileOutputStream outputStream;
		try {
			outputStream = new FileOutputStream("C:/Users/sanjasha/Documents/Telstra/sampledata_write.xlsx");
			try {
				workbook.write(outputStream);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 try {
				workbook.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		
	}

	public static void readFromExcel(String file1) throws IOException{
		 File f = null;
		 Workbook workbook = null;
		 FileInputStream file = null;
		 try
	        {	
			 
			 	f  = new File(file1);
	            file = new FileInputStream(f);
	 
	            // Creating a Workbook from an Excel file (.xls or .xlsx)
	            workbook = WorkbookFactory.create(file);

	            // Retrieving the number of sheets in the Workbook
	            System.out.println("Workbook has " + workbook.getNumberOfSheets() + " Sheets : "); 
	
	           
	            // obtaining a sheetIterator and iterate over it
	            Iterator<Sheet> sheetIterator = workbook.sheetIterator();
	            System.out.println("Retrieving Sheets using Iterator");
	            while (sheetIterator.hasNext()) {
	                Sheet sheet = sheetIterator.next();
	                System.out.println("=> " + sheet.getSheetName());
	            }

	            // Getting the Sheet at index zero
	            Sheet sheet = workbook.getSheetAt(0);

	            // Create a DataFormatter to format and get each cell's value as String
	            DataFormatter dataFormatter = new DataFormatter();

	            
	         // obtaining a rowIterator and columnIterator and iterate over them
	            
	            Iterator<Row> rowIterator = sheet.rowIterator();
	            Integer count = 0;
	            Boolean flag = false;
	            Integer expectedColumnIndex = 0;
	            while (rowIterator.hasNext()) {
	                Row row = rowIterator.next();

	                // Now let's iterate over the columns of the current row
	                Iterator<Cell> cellIterator = row.cellIterator();
	                count = 0;
	                while (cellIterator.hasNext()) {
	                	count++;
	                    Cell cell = cellIterator.next();
	                    String cellValue = dataFormatter.formatCellValue(cell);
	                    if(cellValue.equals("Hire Date")) {
	                    	expectedColumnIndex = count;
	                    	flag = true;
	                    	break;
	                    }
	               }
	               if(flag)
	            	   break;
	            }
	            	            
	         // columnIterator and iterate over them-- Hire Date	            
	            Iterator<Row> rowIterator1 = sheet.rowIterator();
	           countNullHireDate = 0; 
	            while (rowIterator1.hasNext()) {
	                Row row1 = rowIterator1.next();
	                Cell  cell = row1.getCell(expectedColumnIndex-1);
	                String cellValue = dataFormatter.formatCellValue(cell);
	                if(cellValue == null || cellValue.isEmpty()) {
	                	countNullHireDate++;
	                }
	            }
	            /////////////////////////////////////////////
	            
	            Iterator<Row> rowIterator_empId = sheet.rowIterator();
	            Integer count_empId = 0;
	            Boolean flag_empId = false;
	            Integer expectedColumnIndex_empId = 0;
	            while (rowIterator_empId.hasNext()) {
	                Row row_empId = rowIterator_empId.next();

	                // Now let's iterate over the columns of the current row
	                Iterator<Cell> cellIterator_empId = row_empId.cellIterator();
	                count_empId = 0;
	                while (cellIterator_empId.hasNext()) {
	                	count_empId++;
	                    Cell cell = cellIterator_empId.next();
	                    String cellValue = dataFormatter.formatCellValue(cell);
	                    if(cellValue.equals("Emp Id")) {
	                    	expectedColumnIndex_empId = count_empId;
	                    	flag_empId = true;
	                    	break;
	                    }
	               }
	               if(flag_empId)
	            	   break;
	            }
	            	            
	         // columnIterator and iterate over them-- Emp Id	            
	            
	           countNullEmpId = 0; 
	            while (rowIterator_empId.hasNext()) {
	                Row row1 = rowIterator_empId.next();
	                Cell  cell = row1.getCell(expectedColumnIndex_empId-1);
	                String cellValue = dataFormatter.formatCellValue(cell);
	                if(cellValue == null || cellValue.isEmpty()) {
	                	countNullEmpId++;
	                }
	            }
	            System.out.println("Hire Date blank count is "+ countNullHireDate); 
	            System.out.println("Emp Id blank count is "+ countNullEmpId);  
	        } 
	        catch (Exception e) 
	        {
	            e.printStackTrace();
	        }finally {
	        	file.close();
		        workbook.close();
		      	
	        }
	           
	 }

}
