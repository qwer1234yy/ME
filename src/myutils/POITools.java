package myutils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;

public class POITools {
	public static <T> InputStream exportList(Class<T> clazz, List<T> list)
			throws IOException, IllegalArgumentException, IllegalAccessException {
		Field[] fields = clazz.getDeclaredFields();
		System.out.println(fields.length);
		HSSFWorkbook workBook = new HSSFWorkbook();
		HSSFSheet sheet = workBook.createSheet("helloWorld");
		int rownum = list.size() + 1;
		int cellnum = fields.length;

		for (int file = 0; file < rownum; ++file) {
			HSSFRow in = sheet.createRow(file);

			for (int j = 0; j < cellnum; ++j) {
				HSSFCell cell_temp = in.createCell(j, CellType.STRING);
				if (file == 0) {
					cell_temp.setCellValue(fields[j].getName());
				} else {
					List values = getValues(list.get(file - 1));
					cell_temp.setCellValue((String) values.get(j));
				}
			}
		}

		workBook.write(new File("D:\\tmp\\测试2.xls"));
		File arg11 = new File("D:\\tmp\\测试2.xls");
		FileInputStream arg12 = new FileInputStream(arg11);
		workBook.close();
		return arg12;
	}

	public static List<String> getValues(Object o) throws IllegalArgumentException, IllegalAccessException {
		ArrayList values = new ArrayList();
		Class clazz = o.getClass();
		Field[] fields = clazz.getDeclaredFields();

		for (int i = 0; i < fields.length; ++i) {
			fields[i].setAccessible(true);
			values.add(fields[i].get(o).toString());
		}

		return values;
	}
}
