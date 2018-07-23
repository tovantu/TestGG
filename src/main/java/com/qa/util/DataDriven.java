package com.qa.util;


import java.util.ArrayList;

public class DataDriven {
	
	static Xls_Reader reader;
	public static ArrayList<Object[]> getDataFromExcel(){
		ArrayList<Object[]> data = new ArrayList<Object[]>();
		try {
			reader = new Xls_Reader("D:/Phan Mem/Eclip/TestGG/src/main/java/com/qa/testdata/UserName_PW.xlsx");
		} catch (Exception e) {
			e.printStackTrace();
		}
		for(int rowNum =2 ; rowNum <= reader.getRowCount("account");rowNum++){
			String username = reader.getCellData("account","username",rowNum);
			String password = reader.getCellData("account","password",rowNum);
			
			Object ob[] = {username,password};
			data.add(ob);
		}
		return data;
	}
}
