package com.tasks.ChatGPTTests;

import org.apache.poi.ss.usermodel.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class ExcelReader {
    public static void main(String[] args) throws IOException {
       // byte[] excelData = // your byte array
                InputStream inputStream = new ByteArrayInputStream(excelData);

        Workbook workbook = WorkbookFactory.create(inputStream);
        Sheet sheet = workbook.getSheetAt(0);

        for (Row row : sheet) {
            for (Cell cell : row) {
                System.out.print(cell.getStringCellValue() + "\t");
            }
            System.out.println();
        }

        workbook.close();
        inputStream.close();
    }


    import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

 /*   // assuming you have the byte array of the Excel file in a variable called excelByteArray
    byte[] excelByteArray = ...;

    // load the byte array into a Workbook object
    Workbook workbook = WorkbookFactory.create(new ByteArrayInputStream(excelByteArray));

    // convert the Workbook object to a String
    String excelString = null;
    ByteArrayOutputStream out = new ByteArrayOutputStream();
try {
        workbook.write(out);
        excelString = out.toString(StandardCharsets.UTF_8.name());
    } catch (IOException e) {
        e.printStackTrace();
    }*/

    public static String convertExcelByteArrayToString(byte[] excelByteArray) {
        Workbook workbook = null;
        String excelString = null;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            workbook = WorkbookFactory.create(new ByteArrayInputStream(excelByteArray));
            workbook.write(out);
            excelString = out.toString(StandardCharsets.UTF_8.name());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (workbook != null) {
                    workbook.close();
                }
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return excelString;
    }

}
