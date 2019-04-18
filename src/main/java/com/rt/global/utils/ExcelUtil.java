package com.rt.global.utils;

import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

public class ExcelUtil {

	public static void download(String[] heads, List<String[]> rows,HttpServletResponse response,String fileHeadName) throws Exception {
		//创建一个excel 文件(poi,2007)
				@SuppressWarnings("resource")
				SXSSFWorkbook wb = new SXSSFWorkbook();
				//创建一个表
				Sheet sheet = wb.createSheet();
				//创建第0行(存表头数据)
				Row headRow = sheet.createRow(0);
				//创建表头中的列
				for (int i = 0; i < heads.length; i++) {
					Cell headCell = headRow.createCell(i);
					headCell.setCellValue(heads[i]);
				}
				//创建其他行
				for(int i=0;i<rows.size();i++){
					//数据是从第一行开始的
					Row dataRow = sheet.createRow(i+1);
					//拿到传过来的这一行的数据
					String[] strings = rows.get(i);
					//给每行的列赋值
					//System.out.println(strings.length +"dadasdsdasdas");
					for(int j=0;j<strings.length;j++){
						//创建列
						Cell dataCell = dataRow.createCell(j);
						//赋值
						dataCell.setCellValue(strings[j]);
					}
				}
				String fileName =fileHeadName + String.valueOf(System.currentTimeMillis()).substring(4, 13) + ".xlsx";    
				System.out.println(fileName);
//                   String fileName11 = URLEncoder.encode(fileName,"UTF-8");  
				
				String fileName11 = new String((fileName).getBytes(),"ISO8859_1");  
				System.out.println(fileName11);
				String headStr = "attachment; filename=\"" + fileName11 + "\"";    
				response.setContentType("APPLICATION/OCTET-STREAM");    
				response.setHeader("Content-Disposition", headStr);    
				OutputStream out = response.getOutputStream();
				wb.write(out);
				out.flush();
				out.close();
				
				
		
	}
	
	
}
