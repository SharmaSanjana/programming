package readexcel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataAllFields {
	public static int countNullHireDate = 0;
	public static int countNullEmpId = 0;

	public static void main(String[] args) throws IOException {
		Map<String,Integer> result = readFromExcel("C:/Users/sanjasha/Documents/Telstra/sampledata_read.xlsx");
		updateExcel(result);

	}

	private static void updateExcel(Map<String,Integer> countMap) throws FileNotFoundException, IOException {

		FileInputStream file = new FileInputStream(
				new File("C:/Users/sanjasha/Documents/Telstra/sampledata_read.xlsx"));
		Workbook workbook = new XSSFWorkbook(file);

		Sheet sheetToupdate = workbook.createSheet("results 2");

		Row header = sheetToupdate.createRow(0);
		Row result = sheetToupdate.createRow(1);
		Integer count = 0 ;
		for(Entry<String,Integer> entry : countMap.entrySet()) {
			Cell headerCell = header.createCell(count);
			Cell resultCell = result.createCell(count);
			headerCell.setCellValue(entry.getKey());
			resultCell.setCellValue(entry.getValue());
			count++;
		}
		file.close();
		FileOutputStream outputStream = new FileOutputStream(
				"C:/Users/sanjasha/Documents/Telstra/sampledata_read.xlsx");
		workbook.write(outputStream);
		outputStream.close();
		workbook.close();

	}

	public static Map<String,Integer> readFromExcel(String file1) throws IOException {
		File f = null;
		Workbook workbook = null;
		FileInputStream file = null;
		try {

			f = new File(file1);
			file = new FileInputStream(f);
			workbook = WorkbookFactory.create(file);
			System.out.println("Workbook has " + workbook.getNumberOfSheets() + " Sheets : ");
			Sheet sheet = workbook.getSheetAt(0);
			DataFormatter dataFormatter = new DataFormatter();

			int countColumns = 0;
			Row firstRow = sheet.getRow(0);

			Iterator<Cell> cellIteratorInit = firstRow.cellIterator();

			Map<String, Integer> countMap = new HashMap<>();
			Map<Integer, String> headerMap = new HashMap<>();

			while (cellIteratorInit.hasNext()) {
				Cell cell = cellIteratorInit.next();
				String cellValue = dataFormatter.formatCellValue(cell);
				countMap.put(cellValue, 0);
				headerMap.put(countColumns, cellValue);
				countColumns++;
			}

			Iterator<Row> rowIterator = sheet.rowIterator();
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				countColumns = 0;
				Iterator<Cell> cellIterator = row.cellIterator();
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					String cellValue = dataFormatter.formatCellValue(cell);
					if (cellValue == null || cellValue.isEmpty()) {
						String key = headerMap.get(countColumns);
						Integer value = countMap.get(key) + 1;
						countMap.put(key, value);
					}
					countColumns++;
				}
			}
			return countMap;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			file.close();
			workbook.close();

		}

		return null;

	}

}
