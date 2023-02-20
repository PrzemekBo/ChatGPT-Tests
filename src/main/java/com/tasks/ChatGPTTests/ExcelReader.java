package com.tasks.ChatGPTTests;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

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

    public static String convertExcelByteArrayToString2(byte[] excelByteArray) {
        Workbook workbook = null;
        String excelString = null;
        try {
            workbook = WorkbookFactory.create(new ByteArrayInputStream(excelByteArray));
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            workbook.write(out);
            byte[] bytes = out.toByteArray();
            excelString = new String(bytes, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (workbook != null) {
                    workbook.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return excelString;
    }


    public static String convertExcelByteArrayToString3(byte[] excelByteArray) {
        Workbook workbook = null;
        String excelString = null;
        try (ByteArrayInputStream inputStream = new ByteArrayInputStream(excelByteArray)) {
            workbook = WorkbookFactory.create(inputStream);
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            workbook.write(out);
            byte[] bytes = out.toByteArray();
            excelString = new String(bytes, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (workbook != null) {
                    workbook.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return excelString;
    }



    public static String convertExcelByteArrayToString(byte[] excelByteArray) {
        try (InputStream is = new ByteArrayInputStream(excelByteArray)) {
            Workbook workbook = WorkbookFactory.create(is);
            XSSFWorkbook xssfWorkbook = new XSSFWorkbook(workbook);
            return xssfWorkbook.getSheetAt(0).getRow(0).getCell(0).getStringCellValue();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String convertExcelByteArrayToString(byte[] excelByteArray) {
        try (InputStream is = new ByteArrayInputStream(excelByteArray)) {
            Workbook workbook = WorkbookFactory.create(is);
            XSSFSheet sheet = new XSSFWorkbook(workbook).getSheetAt(0);
            return sheet.getRow(0).getCell(0).getStringCellValue();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }


        public static String convertExcelByteToString(byte[] excelBytes) {
            try {
                ByteArrayInputStream inputStream = new ByteArrayInputStream(excelBytes);
                Workbook workbook = WorkbookFactory.create(inputStream);

                Sheet sheet = workbook.getSheetAt(0);
                StringBuilder stringBuilder = new StringBuilder();

                for (Row row : sheet) {
                    for (Cell cell : row) {
                        stringBuilder.append(cell.getStringCellValue()).append("\t");
                    }
                    stringBuilder.append("\n");
                }

                inputStream.close();

                return stringBuilder.toString();
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }



}
