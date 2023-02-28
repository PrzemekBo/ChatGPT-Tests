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




            public static String convertExcelByteToString5(byte[] excelBytes) {
                try {
                    ByteArrayInputStream inputStream = new ByteArrayInputStream(excelBytes);
                    Workbook workbook = WorkbookFactory.create(inputStream);
                    DataFormatter dataFormatter = new DataFormatter();

                    Sheet sheet = workbook.getSheetAt(0);
                    StringBuilder stringBuilder = new StringBuilder();

                    for (Row row : sheet) {
                        for (Cell cell : row) {
                            String cellValue = dataFormatter.formatCellValue(cell);
                            stringBuilder.append(cellValue).append("\t");
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


    public static List<String> readFirstColumnValues(String filePath) throws IOException {
        List<String> values = new ArrayList<>();
        FileInputStream inputStream = new FileInputStream(new File(filePath));
        Workbook workbook = WorkbookFactory.create(inputStream);
        Sheet sheet = workbook.getSheetAt(0); // Assuming the first sheet is the one you want to read from
        for (Row row : sheet) {
            Cell cell = row.getCell(0); // Get the first cell of each row
            if (cell != null) {
                String value = cell.getStringCellValue(); // Get the string value of the cell
                values.add(value);
            }
        }
        workbook.close();
        inputStream.close();
        return values;
    }
    public static List<String> readFirstColumnValues(byte[] fileData) throws IOException {
        List<String> values = new ArrayList<>();
        ByteArrayInputStream inputStream = new ByteArrayInputStream(fileData);
        Workbook workbook = WorkbookFactory.create(inputStream);
        Sheet sheet = workbook.getSheetAt(0); // Assuming the first sheet is the one you want to read from
        for (Row row : sheet) {
            Cell cell = row.getCell(0); // Get the first cell of each row
            if (cell != null) {
                String value = cell.getStringCellValue(); // Get the string value of the cell
                values.add(value);
            }
        }
        workbook.close();
        inputStream.close();
        return values;
    }



    public static List<String> readColumnValues(byte[] fileData, String columnName) throws IOException {
        List<String> values = new ArrayList<>();
        Workbook workbook = WorkbookFactory.create(new ByteArrayInputStream(fileData));
        Sheet sheet = workbook.getSheetAt(0); // Assuming the first sheet is the one you want to read from
        int columnIndex = -1;
        Row headerRow = sheet.getRow(0);
        for (Cell cell : headerRow) {
            if (cell.getStringCellValue().equals(columnName)) {
                columnIndex = cell.getColumnIndex();
                break;
            }
        }
        if (columnIndex == -1) {
            throw new IllegalArgumentException("Column not found: " + columnName);
        }
        for (Row row : sheet) {
            Cell cell = row.getCell(columnIndex);
            if (cell != null) {
                String value = cell.getStringCellValue();
                values.add(value);
            }
        }
        workbook.close();
        return values;
    }

    List<String> firstField = Arrays.asList("string1", "string2", "string3");
    List<String> secondField = Arrays.asList("second1", "second2", "second3");

    List<MyObject> myObjects = IntStream.range(0, firstField.size())
            .mapToObj(i -> new MyObject(firstField.get(i), secondField.get(i)))
            .collect(Collectors.toList());



    public static byte[] removeRowsAndReturnByteArray(byte[] fileData, String charactersToRemove) throws IOException {
        Workbook workbook = WorkbookFactory.create(new ByteArrayInputStream(fileData));
        Sheet sheet = workbook.getSheetAt(0); // Assuming the first sheet is the one you want to modify
        List<Row> rowsToRemove = new ArrayList<>();
        for (Row row : sheet) {
            Cell cell = row.getCell(0); // Assuming the name is in the first column
            if (cell != null && cell.getStringCellValue().contains(charactersToRemove)) {
                rowsToRemove.add(row);
            }
        }
        for (Row row : rowsToRemove) {
            sheet.removeRow(row);
        }
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        workbook.write(outputStream);
        workbook.close();
        byte[] outputData = outputStream.toByteArray();
        outputStream.close();
        return outputData;
    }



    public static byte[] removeRowsAndReturnByteArray(byte[] fileData, String charactersToRemove) throws IOException {
        Workbook workbook = WorkbookFactory.create(new ByteArrayInputStream(fileData));
        Sheet sheet = workbook.getSheetAt(0); // Assuming the first sheet is the one you want to modify
        Row headerRow = sheet.getRow(0);
        sheet.removeRow(headerRow); // Remove the header row
        List<Row> rowsToRemove = new ArrayList<>();
        for (Row row : sheet) {
            Cell cell = row.getCell(0); // Assuming the name is in the first column
            if (cell != null && cell.getStringCellValue().contains(charactersToRemove)) {
                rowsToRemove.add(row);
            }
        }
        for (Row row : rowsToRemove) {
            sheet.removeRow(row);
        }
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        workbook.write(outputStream);
        workbook.close();
        byte[] outputData = outputStream.toByteArray();
        outputStream.close();
        return outputData;
    }

    public static byte[] removeRowsAndReturnByteArray(byte[] fileData, List<String> charactersToRemove) throws IOException {
        Workbook workbook = WorkbookFactory.create(new ByteArrayInputStream(fileData));
        Sheet sheet = workbook.getSheetAt(0); // Assuming the first sheet is the one you want to modify
        Row headerRow = sheet.getRow(0);
        sheet.removeRow(headerRow); // Remove the header row
        List<Row> rowsToRemove = new ArrayList<>();
        for (Row row : sheet) {
            Cell cell = row.getCell(0); // Assuming the name is in the first column
            if (cell != null) {
                String cellValue = cell.getStringCellValue();
                for (String character : charactersToRemove) {
                    if (cellValue.contains(character)) {
                        rowsToRemove.add(row);
                        break; // no need to check other characters for this row
                    }
                }
            }
        }
        for (Row row : rowsToRemove) {
            sheet.removeRow(row);
        }
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        workbook.write(outputStream);
        workbook.close();
        byte[] outputData = outputStream.toByteArray();
        outputStream.close();
        return outputData;
    }


    List<String> firstField = Arrays.asList("string1", "string2", "string3", "string4");
    List<String> secondField = Arrays.asList("second1", "second2", "second3", "second4");

    List<MyObject> myObjects = IntStream.range(0, firstField.size())
            .mapToObj(i -> new MyObject(firstField.get(i), secondField.get(i)))
            .collect(Collectors.toList());

    List<String> certainCharacters = Arrays.asList("1", "2");

myObjects.removeIf(obj -> certainCharacters.stream()
            .anyMatch(c -> obj.getFirstField().contains(c)));

    public List<String> getSecondFieldsWithoutCertainCharacters(List<MyObject> myObjects, List<String> certainCharacters) {
        return myObjects.stream()
                .filter(obj -> certainCharacters.stream()
                        .noneMatch(c -> obj.getFirstField().contains(c)))
                .map(MyObject::getSecondField)
                .collect(Collectors.toList());
    }


    import org.apache.poi.ss.usermodel.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

    public List<MyObject> readExcel(byte[] file) throws IOException {
        List<MyObject> objects = new ArrayList<>();
        Workbook workbook = WorkbookFactory.create(new ByteArrayInputStream(file));
        Sheet sheet = workbook.getSheetAt(0);

        for (Row row : sheet) {
            MyObject object = new MyObject();
            object.setField1(row.getCell(0).getStringCellValue());
            object.setField2(row.getCell(1).getNumericCellValue());
            object.setField3(row.getCell(2).getDateCellValue());
            // Add more setField calls for additional columns

            objects.add(object);
        }

        return objects;
    }



    for (Row row : sheet) {
        RowResponse rawResponse = new RowResponse();

        rawResponse.setQuestions(row.getCell(0) != null ? row.getCell(0).getStringCellValue() : null);
        rawResponse.setVariable(row.getCell(1) != null ? row.getCell(1).getStringCellValue() : null);
        rawResponse.setCategory(row.getCell(2) != null ? row.getCell(2).getStringCellValue() : null);
        rawResponse.setDataType(row.getCell(3) != null ? row.getCell(3).getStringCellValue() : null);
        rawResponse.setComment(row.getCell(4) != null ? row.getCell(4).getStringCellValue() : null);
        rawResponse.setDefaultValues(row.getCell(5) != null ? row.getCell(5).getStringCellValue() : null);

        objects.add(rawResponse);
    }


    for (Row row : sheet) {
        RowResponse rawResponse = new RowResponse();

        Cell questionCell = row.getCell(0);
        if (questionCell != null) {
            if (questionCell.getCellType() == CellType.NUMERIC) {
                rawResponse.setQuestions(Double.toString(questionCell.getNumericCellValue()));
            } else {
                rawResponse.setQuestions(questionCell.getStringCellValue());
            }
        }

        // Repeat the same pattern for the other cells...

        objects.add(rawResponse);
    }

import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


    public static List<String> readColumnFromExcel(byte[] excelFile, String columnName) throws Exception {
        Workbook workbook = WorkbookFactory.create(new ByteArrayInputStream(excelFile));
        Sheet sheet = workbook.getSheetAt(0);

        // Find the index of the specified column by name
        int columnIndex = sheet.getRow(0).stream()
                .filter(cell -> cell.getStringCellValue().equals(columnName))
                .mapToInt(Cell::getColumnIndex)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Column name not found: " + columnName));

        // Read the values from the specified column and remove duplicates
        return sheet.stream()
                .skip(1)
                .map(row -> row.getCell(columnIndex))
                .filter(cell -> cell != null)
                .map(Cell::getStringCellValue)
                .distinct()
                .collect(Collectors.toList());
    }

    import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

    public List<String> getUniqueValuesFromColumn(byte[] excelFile, String columnName) throws IOException {
        // Load the byte array into a ByteArrayInputStream to create a Workbook object
        ByteArrayInputStream inputStream = new ByteArrayInputStream(excelFile);
        Workbook workbook = WorkbookFactory.create(inputStream);

        // Get the first sheet in the workbook
        Sheet sheet = workbook.getSheetAt(0);

        // Find the column index for the specified column name
        int columnIndex = sheet.getRow(0).stream()
                .filter(cell -> cell.getStringCellValue().equalsIgnoreCase(columnName))
                .map(Cell::getColumnIndex)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Column not found: " + columnName));

        // Use a stream to iterate over the rows in the sheet and extract the cell values
        Set<String> uniqueValues = sheet.stream()
                .skip(1) // skip the first row (headers)
                .map(row -> row.getCell(columnIndex))
                .filter(cell -> cell != null)
                .map(Cell::getStringCellValue)
                .collect(Collectors.toCollection(LinkedHashSet::new));

        // Convert the set to a list and return it
        return new ArrayList<>(uniqueValues);
    }


    public static List<String> filterObjects(List<MyObject> objects) {
        List<String> filteredList = new ArrayList<>();
        for (MyObject obj : objects) {
            if (obj.getField2() == null && obj.getField3() == null) {
                filteredList.add(obj.getField1());
            }
        }
        return filteredList;
    }

    public List<FinalObject> processRows(List<String> stringList, List<RowResponse> rowList) {
        return stringList.stream()
                .map(str -> {
                    FinalObject finalObj = new FinalObject();
                    finalObj.setName(str);
                    finalObj.setRowResponses(rowList.stream()
                            .filter(row -> str.equals(row.getName()) && str.equals(row.getText()))
                            .collect(Collectors.toList()));
                    return finalObj;
                })
                .collect(Collectors.toList());
    }


    public List<RowInfoResponse> generateRowInfoResponses(List<String> stringList, List<RowResponse> rowResponseList) {
        List<RowInfoResponse> rowInfoResponseList = new ArrayList<>();

        for (String title : stringList) {
            RowInfoResponse rowInfoResponse = new RowInfoResponse();
            rowInfoResponse.setTitle(title);

            List<RowResponse> matchingRowResponses = new ArrayList<>();
            for (RowResponse rowResponse : rowResponseList) {
                if (rowResponse.getQuestions().equals(title)) {
                    matchingRowResponses.add(rowResponse);
                }
            }

            rowInfoResponse.setRowResponse(matchingRowResponses);
            rowInfoResponseList.add(rowInfoResponse);
        }

        return rowInfoResponseList;
    }


    public static void removeObjectsWithTitles(List<MyObject> objectList, List<String> stringList) {
        objectList.removeIf(obj -> stringList.contains(obj.getTitle()));
    }

import java.util.List;
import java.util.stream.Collectors;

    public class RawResponseModifier {

        public static List<RawResponse> modifyRawResponses(List<RawResponse> rawResponses) {
            return rawResponses.stream()
                    .map(response -> {
                        if (response.getCucu().equals("texxt")) {
                            response.setCucu("text");
                        } else if (response.getCucu().equals("ogon")) {
                            response.setCucu("ogon 6");
                        }
                        return response;
                    })
                    .collect(Collectors.toList());
        }

    }


    public static List<RawResponse> modifyRawResponses(List<RawResponse> rawResponses) {
        return rawResponses.stream()
                .peek(response -> {
                    String cucu = response.getCucu();
                    if (cucu.equals("texxt")) {
                        response.setCucu("text");
                    } else if (cucu.equals("ogon")) {
                        response.setCucu("ogon 6");
                    } else if (cucu.equals("kozak")) {
                        response.setCucu("kzak 13");
                    }
                })
                .collect(Collectors.toList());
    }





    public static List<MyObject> removeObjectsWithTitles(List<MyObject> objectList, List<String> stringList) {
        List<MyObject> result = new ArrayList<>();
        for (MyObject obj : objectList) {
            if (!stringList.contains(obj.getTitle())) {
                result.add(obj);
            }
        }
        return result;
    }


    public static List<String> convertStringToList(String inputString) {
        return Arrays.stream(inputString.split(","))
                .map(String::trim)
                .collect(Collectors.toList());
    }


    import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

    public class StringToListExample {
        public static void main(String[] args) {
            String inputString1 = "Director, Senior Manager, Manager";
            List<String> outputList1 = convertStringToList(inputString1);
            System.out.println(outputList1);

            String inputString2 = "SingleString";
            List<String> outputList2 = convertStringToList(inputString2);
            System.out.println(outputList2);

            String inputString3 = "";
            List<String> outputList3 = convertStringToList(inputString3);
            System.out.println(outputList3);

            String inputString4 = null;
            List<String> outputList4 = convertStringToList(inputString4);
            System.out.println(outputList4);
        }

        public static List<String> convertStringToList(String inputString) {
            if (inputString == null || inputString.isEmpty()) {
                return Collections.emptyList();
            }
            else if (!inputString.contains(",")) {
                return Collections.singletonList(inputString.trim());
            }
            else {
                return Arrays.stream(inputString.split(","))
                        .map(String::trim)
                        .collect(Collectors.toList());
            }
        }
    }


    public List<ConvertedRow> processRows(List<ConvertedRow> convertedRows) {
        for (ConvertedRow row : convertedRows) {
            if (row.getQuestions().equals("Status RM")) {
                row.setComment(List.of("1", "2"));
                row.setDefaultValues("dasasd");
            }
        }
        return convertedRows;
    }



    import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.apache.poi.xwpf.extractor.XHTMLConverter;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

    public static String getCssFromWord(byte[] wordBytes) throws IOException {
        // Convert Word document byte array to XHTML
        XWPFDocument document = new XWPFDocument(new ByteArrayInputStream(wordBytes));
        XHTMLConverter converter = (new XHTMLConverter()).convert(document);

        // Extract CSS from the generated HTML using Jsoup
        Document htmlDoc = Jsoup.parse(converter.toString());
        String css = htmlDoc.head().getElementsByTag("style").html();

        return css;
    }


    import org.zwobble.mammoth.DocumentConverter;
import org.zwobble.mammoth.Result;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

    public class CssExtractor {
        public static String extractCss(byte[] wordDocBytes) throws IOException {
            InputStream inputStream = new ByteArrayInputStream(wordDocBytes);
            DocumentConverter converter = new DocumentConverter();
            Result<String> result = converter.extractStyles(inputStream);
            String css = result.getValueOrElse("");
            return css;
        }
    }

    import org.zwobble.mammoth.DocumentConverter;
import org.zwobble.mammoth.Result;
import org.zwobble.mammoth.internal.styles.HtmlPath;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

    public class CssExtractor {
        public static String extractCss(byte[] wordDocBytes) throws IOException {
            InputStream inputStream = new ByteArrayInputStream(wordDocBytes);
            DocumentConverter converter = new DocumentConverter();
            Result<String> result = converter.convertToHtml(inputStream);
            String html = result.getValueOrElse("");
            String css = extractCssFromHtml(html);
            return css;
        }

        private static String extractCssFromHtml(String html) {
            StringBuilder cssBuilder = new StringBuilder();
            int startIndex = 0;
            while (true) {
                startIndex = html.indexOf("<style>", startIndex);
                if (startIndex == -1) {
                    break;
                }
                startIndex += "<style>".length();
                int endIndex = html.indexOf("</style>", startIndex);
                if (endIndex == -1) {
                    break;
                }
                String css = html.substring(startIndex, endIndex);
                cssBuilder.append(css);
                startIndex = endIndex + "</style>".length();
            }
            return cssBuilder.toString();
        }
    }















}
