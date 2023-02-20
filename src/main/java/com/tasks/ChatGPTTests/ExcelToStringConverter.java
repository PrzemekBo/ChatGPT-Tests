package com.tasks.ChatGPTTests;

import java.io.ByteArrayInputStream;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelToStringConverter {

    public static String convertExcelToString(byte[] excelFileBytes) {
        try (ByteArrayInputStream bis = new ByteArrayInputStream(excelFileBytes);
             Workbook workbook = WorkbookFactory.create(bis)) {
            return workbook.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
