package testData;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import jxl.Sheet;
import jxl.Workbook;
import jxl.format.Colour;
import jxl.format.Pattern;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class TestDataExcel {
	
	public static Map<String, Map<String,String>> readExcel(String path,String workSheet) throws FileNotFoundException{
		//Map<String, String> shopProduct = null;
		Map<String,Map<String,String>> map=new HashMap<>();		
			try {
				//FileInputStream inputFile=new FileInputStream(new File(path));
				Workbook wrkbk=Workbook.getWorkbook(new File(path));
				Sheet sheet=wrkbk.getSheet(workSheet);
				int row=sheet.getRows();
				int col=sheet.getColumns();
				//System.out.println(row);
				//System.out.println(col);
				String[] Title=new String[col];
				String[] TcName=new String[row];
				for(int i=0;i<Title.length;i++) {
					Title[i]=sheet.getCell(i, 0).getContents();
				}				
				for(int j=0;j<TcName.length;j++) {
					TcName[j]=sheet.getCell(0, j).getContents();
				}				
				for(int i=0;i<row;i++) {
					Map<String,String> temp=new HashMap<>();
										
					for(int j=0;j<col;j++) {
					temp.put(Title[j], sheet.getCell(j,i).getContents());
					//System.out.println(temp);
					}
					map.put(TcName[i], temp);					
				}
				wrkbk.close();
				//System.out.println(map);
			} 			
			catch (BiffException|IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
		return map;		
	}
	
	public static String[][] readTcRunnable(String path,String workSheet) throws  IOException {
		
		String[][] data=null;
			//FileInputStream inputFile=new FileInputStream(new File(path));
		try {
			Workbook wrkbk=Workbook.getWorkbook(new File(path));
			Sheet sheet=wrkbk.getSheet(workSheet);
			int sizecol=sheet.getRows();
			
						
			data=new String[2][sizecol-1];
			
			for(int i=0;i<=1;i++) {				
									
				for(int j=1;j<sizecol;j++) {
				data[i][j-1]=sheet.getCell(i, j).getContents();
				//System.out.println(data[i][j-1]);
				}				
						
			}
			wrkbk.close();
		}
		catch(BiffException e) {
			e.printStackTrace();
		}
			return data;
		
	}
	
	
	
	public static void setValueInoCell(String path,String strSheetName,int icolNumber,int irowNumber,String strData) {
		Workbook wbook1=null;
		WritableWorkbook wwbcopy1=null;
		WritableSheet shSheet1=null;
		
		try {
			wbook1=Workbook.getWorkbook(new File(path));
			wwbcopy1=Workbook.createWorkbook(new File(path), wbook1);
			//shSheet1=wwbcopy1.getSheet(0);
			
		
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		WritableSheet wshtemp=wwbcopy1.getSheet(strSheetName);
		System.out.println(strData);
		
		try {
			if(strData.equalsIgnoreCase("Pass")) {
				Label labelTemp=new Label(icolNumber, irowNumber, strData, getCellFormat(Colour.GREEN,Pattern.SOLID));
				wshtemp.addCell(labelTemp);
				wwbcopy1.write();
				wwbcopy1.close();
				wbook1.close();				
			}
			else if(strData.equalsIgnoreCase("Fail")) {
				Label labelTemp=new Label(icolNumber, irowNumber, strData, getCellFormat(Colour.RED,Pattern.SOLID));
				wshtemp.addCell(labelTemp);
				wwbcopy1.write();
				wwbcopy1.close();
				wbook1.close();				
			} 
			
			else if(strData.equalsIgnoreCase("Skip")) {
				Label labelTemp=new Label(icolNumber, irowNumber, strData, getCellFormat(Colour.YELLOW,Pattern.SOLID));
				wshtemp.addCell(labelTemp);
				wwbcopy1.write();
				wwbcopy1.close();
				wbook1.close();				
			}
			
			else {
				
					Label labelTemp=new Label(icolNumber, irowNumber, strData);
					wshtemp.addCell(labelTemp);
					wwbcopy1.write();
					wwbcopy1.close();
					wbook1.close();				
				
			}
			
			
	}
		catch(Exception e) {
			e.printStackTrace();	
		}
	
	}
	 private static WritableCellFormat getCellFormat(Colour colour, Pattern pattern) throws WriteException {
		    WritableFont cellFont = new WritableFont(WritableFont.ARIAL, 11);
		    WritableCellFormat cellFormat = new WritableCellFormat(cellFont);
		    cellFormat.setBackground(colour, pattern);
		    return cellFormat;
		  }


}
