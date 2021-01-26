package testData;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class TestDataValue {

	public static String testdata(String path,String workSheet,String TC,String FieldName) throws BiffException, IOException{
		String data=null;
		
		Workbook wrkbk=Workbook.getWorkbook(new File(path));
		Sheet sheet = wrkbk.getSheet(workSheet);
		Map map=TestDataExcel.readExcel(path, workSheet);
		Map insidemap=new HashMap<>();
		
		insidemap= (Map) map.get(TC);
		data=(String) insidemap.get(FieldName);		
		
		return data;
	}
	
	public static Boolean isRunnable(String path,String workSheet,String TC) throws BiffException, IOException{
		String isRunnable;
		String FieldName="Runnable";
		//System.out.println(path);
		//System.out.println(workSheet);
		Map map=TestDataExcel.readExcel(path, workSheet);
		Map insidemap=new HashMap<>();
		
		insidemap= (Map) map.get(TC);
		//System.out.println(insidemap);
		isRunnable=(String) insidemap.get(FieldName);
		//System.out.println(isRunnable);
		//wrkbk.close();
		if(isRunnable.equalsIgnoreCase("Y")) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
	public static String[][] testDataProvider(String path,String workSheet) throws IOException{
		
		
		String[][] data=TestDataExcel.readTcRunnable(path, workSheet);
		
		int r=data.length;//number of rows
		int c=data[0].length;//number of columns
		
		String[][] testDataProvider=new String[c][r];
		
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				testDataProvider[j][i]=data[i][j];
				//System.out.println(testDataProvider[j][i]);
			}
		}
		
		return testDataProvider;
	}
	
	
}
