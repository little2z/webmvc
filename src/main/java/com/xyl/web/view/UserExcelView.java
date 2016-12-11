package com.xyl.web.view;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import com.xyl.web.entity.User;

public class UserExcelView  extends AbstractExcelView {
	
	public final HSSFCellStyle NO_STYLE = null;
	
	@Override
	protected void buildExcelDocument(Map<String, Object> model, HSSFWorkbook workbook,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
		
		User user = (User)model.get("user");
		
		HSSFSheet sheet = workbook.createSheet();
		
		// Heading style
		HSSFCellStyle heading = workbook.createCellStyle();
		heading.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		heading.setBottomBorderColor(HSSFColor.BLACK.index);
		heading.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		heading.setFillBackgroundColor(HSSFColor.LIGHT_GREEN.index);
		heading.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		
		// Headings
		HSSFRow row = sheet.createRow(0);
		addToCell(row, 0, "UserName", heading);
		addToCell(row, 1, "Age", heading);
		
		HSSFRow row1 = sheet.createRow(1);
		addToCell(row1, 0, user.getUsername(), NO_STYLE);
		addToCell(row1, 1, user.getAge(), NO_STYLE);
		
	}
	
	private HSSFCell addToCell(HSSFRow row, int index, Object value,
			HSSFCellStyle style) {
		HSSFCell cell = row.createCell((short) index);

		if (style == null)
			style = cell.getCellStyle();

		if (value instanceof String) {
			String str = (String) value;
			if (str.startsWith("="))
				cell.setCellFormula(str.substring(1));
			else
				cell.setCellValue(new HSSFRichTextString(str));

			style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		} else if (value instanceof Date) {
			cell.setCellValue((Date) value);
			style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		}  else {
			if ( value == null) value = "";   // Ignore
			cell.setCellValue(new HSSFRichTextString(value.toString()));
			style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		}

		cell.setCellStyle(style);
		return cell;
	}
}
