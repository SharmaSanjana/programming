package count;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;

public class ExcelDataReader {

	public static void main(String[] args) throws FileNotFoundException, IOException{
		
		readFromExcel("C:/Users/sanjasha/Documents/Telstra/sampledata.xlsx");
		
		writeIntoExcel("C:/Users/sanjasha/Documents/Telstra/sampledata.xlsx");
        

	}
	
	 public static void readFromExcel(String file1) throws IOException{
		 try
	        {	
			 	File f  = new File(file1);
	            FileInputStream file = new FileInputStream(f);
	 
	            // Creating a Workbook from an Excel file (.xls or .xlsx)
	            Workbook workbook = WorkbookFactory.create(file1);

	            // Retrieving the number of sheets in the Workbook
	            System.out.println("Workbook has " + workbook.getNumberOfSheets() + " Sheets : ");

	            /*
	               =============================================================
	               Iterating over all the sheets in the workbook (Multiple ways)
	               =============================================================
	            */

	            // 1. You can obtain a sheetIterator and iterate over it
	            Iterator<Sheet> sheetIterator = workbook.sheetIterator();
	            System.out.println("Retrieving Sheets using Iterator");
	            while (sheetIterator.hasNext()) {
	                Sheet sheet = sheetIterator.next();
	                System.out.println("=> " + sheet.getSheetName());
	            }

	           

	            /*
	               ==================================================================
	               Iterating over all the rows and columns in a Sheet (Multiple ways)
	               ==================================================================
	            */

	            // Getting the Sheet at index zero
	            Sheet sheet = workbook.getSheetAt(0);

	            // Create a DataFormatter to format and get each cell's value as String
	            DataFormatter dataFormatter = new DataFormatter();

	            
	         // 1. You can obtain a rowIterator and columnIterator and iterate over them
	            System.out.println("\n\nIterating over Rows and Columns using Iterator\n");
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
	            System.out.println("\n\nIterating over Rows and Columns using Iterator\n");
	            Iterator<Row> rowIterator1 = sheet.rowIterator();
	           Integer countNullHireDate = 0; 
	            while (rowIterator1.hasNext()) {
	                Row row1 = rowIterator1.next();
	                Cell  cell = row1.getCell(expectedColumnIndex-1);
	                String cellValue = dataFormatter.formatCellValue(cell);
	                if(cellValue == null || cellValue.isEmpty()) {
	                	countNullHireDate++;
	                }
	            }
	            System.out.println("IS BLANK count ::"+ countNullHireDate);
	            
	         // Closing the workbook
	           // workbook.close();
	            
	          file.close();
	        
	/////////////////////////////////////////////////////////////////////////////
	            
	          
	          workbook = WorkbookFactory.create(file);
	         // Create a blank sheet 
	            XSSFSheet sheet1 = (XSSFSheet) workbook.createSheet("Null Check"); 
	      
	            // This data needs to be written (Object[]) 
	            Map<String, Integer> data = new HashMap<String, Integer>(); 
	            data.put("Hire Date", countNullHireDate);
	            data.put("Emp Id", 2);
	            
	      
	            // Iterate over data and write to sheet 
	            Set<String> keyset = data.keySet(); 
	            int rownum = 0; 
	            for (String key : keyset) { 
	                // this creates a new row in the sheet 
	                Row row = sheet1.createRow(rownum++); 
	                Integer value = data.get(key); 
	                int cellnum = 0; 
	                    // this line creates a cell in the next column of that row 
	                Cell cell = row.createCell(cellnum++); 
	                   
	                cell.setCellValue(value); 
	                   System.out.println("Row is "+ value);
	                        
	            } 
	            try { 
	                // this Writes the workbook gfgcontribute 
	                FileOutputStream out = new FileOutputStream(f); 
	                workbook.write(out); 
	                out.close(); 
	                System.out.println("gfgcontribute.xlsx written successfully on disk."); 
	            } 
	            catch (Exception e) { 
	                e.printStackTrace(); 
	            }
	            
	        } 
	        catch (Exception e) 
	        {
	            e.printStackTrace();
	        }     
	            
	       
	    }
	 }
	 
	 @SuppressWarnings("deprecation") 
	 public static void writeIntoExcel(String file) throws FileNotFoundException, IOException{
		 
	 }

}
