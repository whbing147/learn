package com.wanghanbing.learn.excel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;

public class ReadExcelDataForTestNG {
    private static  String parementFile = "E:/test-xiaozhangException.xls";

    public static void main(String[] args) throws Exception {
        File xlsFile = new File("/Users/wanghanbing/Downloads/test.xlsx");
        // 获得工作簿
        XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream(xlsFile));
        // 获得sheet
        XSSFSheet sheet0 = wb.getSheetAt(0);
        XSSFSheet sheet1 = wb.getSheetAt(1);

        Cell cell = sheet0.getRow(0).getCell(0);
        Cell copyCell = sheet1.getRow(0).getCell(0);
        Cell copyCell1 = sheet1.getRow(0).getCell(1);
        if (cell.getCellType() == CellType.NUMERIC) {
            copyCell.setCellValue(cell.getNumericCellValue());
        } else {
            copyCell.setCellValue(String.valueOf(cell.getNumericCellValue()));
            copyCell1.setCellValue(String.valueOf(cell.getNumericCellValue()));
        }
        wb.close();


    }
}