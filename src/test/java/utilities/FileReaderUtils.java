package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Reporter;


public class FileReaderUtils
{
	public static Properties prop = null;
	public List<HashMap<String, String>> ReadExcelToHashMap(String fileName, String sheetName)
	{
		List<HashMap<String, String>> excelData = new ArrayList<HashMap<String, String>>();
		FileInputStream fso;
		try {
			fso = new FileInputStream(fileName);
			XSSFWorkbook wb = new XSSFWorkbook(fso);
			XSSFSheet ws = wb.getSheet(sheetName);
			
			Row hdrRow = ws.getRow(0);
			
			for(int i=1; i<ws.getPhysicalNumberOfRows();i++)
			{
				HashMap<String, String> mp = new HashMap<String, String>();
				Row curRow = ws.getRow(i);
				int cols = hdrRow.getPhysicalNumberOfCells();
				for(int j=0; j<cols; j++)
				{
					Cell curCell = curRow.getCell(j);
					DataFormatter df = new DataFormatter();
					String value = df.formatCellValue(curCell);
					
					mp.put(hdrRow.getCell(j).getStringCellValue(), value);
				}
				excelData.add(mp);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			Reporter.log("File not found error");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			Reporter.log("Issue with opening excel file");
		}		
		return excelData;
	}
	
	public HashMap<String, String> ReadDataFromRow(String fileName, String sheetName, String rowRef)
	{
		//List<HashMap<String, String>> excelData = new ArrayList<HashMap<String, String>>();
		HashMap<String, String> mp = new HashMap<String, String>();
		FileInputStream fso;
		try {
			fso = new FileInputStream(fileName);
			XSSFWorkbook wb = new XSSFWorkbook(fso);
			XSSFSheet ws = wb.getSheet(sheetName);
			
			Row hdrRow = ws.getRow(0);
			Row dtRow =null ;
			for(int k=1; k<ws.getPhysicalNumberOfRows();k++)
			{
				if(ws.getRow(k).getCell(0).toString().equalsIgnoreCase(rowRef))
				{	
					dtRow = ws.getRow(k);
					
					int cols = hdrRow.getPhysicalNumberOfCells();
					for(int j=1; j<cols; j++)
					{
						Cell curCell = dtRow.getCell(j);
						DataFormatter df = new DataFormatter();
						String value = df.formatCellValue(curCell);
						mp.put(hdrRow.getCell(j).getStringCellValue(), value);
					}
					//excelData.add(mp);
					break;
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			Reporter.log("File not found error");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			Reporter.log("Issue with opening excel file");
		}		
		return mp;
	}
	
	public Properties ReadFromTextFile(String strFilePath)
	{
		try {
			FileInputStream fileInput = new FileInputStream(new File(strFilePath));
			prop = new Properties();
			try {
				prop.load(fileInput);
				fileInput.close();
				return prop;
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("File is not found in the specified location "+ strFilePath);
		}
		return null;
	}
	
}

