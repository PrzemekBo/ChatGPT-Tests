package com.tasks.ChatGPTTests;

public class NewClass {


    import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFStyles;

    public class WordToCSSConverter {

        public static String extractCSSFromWordDocument(byte[] documentBytes) throws IOException {
            InputStream inputStream = new ByteArrayInputStream(documentBytes);
            XWPFDocument document = new XWPFDocument(inputStream);
            XWPFStyles styles = document.getStyles();
            StringBuilder cssBuilder = new StringBuilder();
            Iterator<XWPFParagraph> paragraphIterator = document.getParagraphsIterator();
            while (paragraphIterator.hasNext()) {
                XWPFParagraph paragraph = paragraphIterator.next();
                String styleId = paragraph.getStyleID();
                if (styleId != null) {
                    String styleName = styles.getStyle(styleId).getName();
                    if (styleName != null) {
                        String styleCSS = styles.getStyle(styleId).getCTStyle().getPPr().toString();
                        cssBuilder.append(styleCSS);
                    }
                }
            }
            return cssBuilder.toString();
        }
    }


    public class Witch {
        @Id

        private Long id;

        @Lob
        @Basic(fetch = FetchType.LAZY)
        @Column(nullable = false)
        private byte[] htmlFile;

        @ElementCollection
        private List<String> photoList;

}
    CREATE TABLE HtmlDocument (
            id VARCHAR(255) NOT NULL PRIMARY KEY,
    name VARCHAR(255),
    type VARCHAR(255),
    data LONGBLOB,
    languageType ENUM('ENGLISH', 'FRENCH', 'GERMAN', 'SPANISH'),
    CONSTRAINT fk_images FOREIGN KEY (image_id) REFERENCES WordImage(id)
            );

    CREATE TABLE WordImage (
            id VARCHAR(255) NOT NULL PRIMARY KEY,
    content LONGBLOB,
    name VARCHAR(255)
);


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "word_image_seq")
    @SequenceGenerator(name = "word_image_seq", sequenceName = "word_image_seq", allocationSize = 1)
    private Long id;




    CREATE TABLE word_image (
            id VARCHAR(255) NOT NULL,
    content BLOB,
    name VARCHAR(255),
    PRIMARY KEY (id)



    CREATE TABLE html_document (
            id VARCHAR(255) NOT NULL,
    name VARCHAR(255),
    type VARCHAR(255),
    data BLOB,
    language_type INTEGER,
    PRIMARY KEY (id),
    FOREIGN KEY (images) REFERENCES word_image(id)
            );

    public static String readHtmlContent(byte[] htmlBytes) {
        String content = null;
        try {
            content = new String(htmlBytes, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return content;
    }

    public static String getBase64Image(byte[] imageData) {
        String encodedImage = Base64.getEncoder().encodeToString(imageData);
        String mimeType = URLConnection.guessContentTypeFromStream(new ByteArrayInputStream(imageData));
        return "data:" + mimeType + ";base64," + encodedImage;
    }


    public static String replaceImageNames(String longString, List<String> imageNames) {
        for (String imageName : imageNames) {
            String pattern = "kkkkkk" + imageName + "tttttt";
            if (longString.contains(pattern)) {
                longString = longString.replace(pattern, imageName);
            }
        }
        return longString;
    }


    public String replaceImageNamesWithBytes(List<String> imageNames, List<String> imageBytes, String longString) {
        for (int i = 0; i < imageNames.size(); i++) {
            longString = longString.replace(imageNames.get(i), imageBytes.get(i));
        }
        return longString;
    }


    public static List<String> getBase64Images(List<byte[]> imageDataList) {
        List<String> encodedImages = new ArrayList<>();

        for (byte[] imageData : imageDataList) {
            String encodedImage = Base64.getEncoder().encodeToString(imageData);
            String mimeType = URLConnection.guessContentTypeFromStream(new ByteArrayInputStream(imageData));
            encodedImages.add("data:" + mimeType + ";base64," + encodedImage);
        }

        return encodedImages;
    }

    public class Example {
        public static void main(String[] args) {
            String bigString = "<html><head><title>Page Title</title></head><body><h1>Heading</h1><p>Some text</p></body></html>";
            System.out.println("Original string: " + bigString);
            String result = removeHeadTags(bigString);
            System.out.println("String after removing <head> tags: " + result);
        }

        public static String removeHeadTags(String bigString) {
            int startIndex = bigString.indexOf("<head>");
            int endIndex = bigString.indexOf("</head>");
            if (startIndex != -1 && endIndex != -1) {
                return bigString.substring(0, startIndex) + bigString.substring(endIndex + 7);
            }
            return bigString;
        }
    }


    public static String removeBetweenInputs(String bigString, String input1, String input2) {
        int startIndex = bigString.indexOf(input1);
        int endIndex = bigString.indexOf(input2);
        if (startIndex != -1 && endIndex != -1 && startIndex < endIndex) {
            return bigString.substring(0, startIndex) + bigString.substring(endIndex + input2.length());
        }
        return bigString;
    }

    public List<String> findStringsBetweenBraces(String input) {
        List<String> result = new ArrayList<>();
        int startIndex = 0;
        int endIndex = 0;
        while (startIndex != -1 && endIndex != -1) {
            startIndex = input.indexOf("}", endIndex);
            endIndex = input.indexOf("{", startIndex);
            if (startIndex != -1 && endIndex != -1 && endIndex > startIndex) {
                result.add(input.substring(startIndex + 1, endIndex));
            }
        }
        return result;
    }

import java.util.*;

    public class MyClass {

        public static Map<String, String> extractValues(List<String> classStrings, String bigString) {
            Map<String, String> result = new HashMap<>();
            for (String classString : classStrings) {
                int startIndex = bigString.indexOf(classString);
                if (startIndex != -1) {
                    startIndex += classString.length();
                    int endIndex = bigString.indexOf("}", startIndex);
                    if (endIndex != -1) {
                        String value = bigString.substring(startIndex, endIndex).trim();
                        result.put(classString, value);
                    }
                }
            }
            return result;
        }

        public static void main(String[] args) {
            List<String> classStrings = Arrays.asList(".foo", ".bar");
            String bigString = "This is a .foo{blah blah} and this is a .bar{blah 542}.sds";
            Map<String, String> result = extractValues(classStrings, bigString);
            System.out.println(result); // prints "{.foo=blah blah, .bar=blah 542}"
        }
    }
    public Map<String, String> generateOutputList(String bigString, List<String> inputList) {
        Map<String, String> outputList = new HashMap<>();
        for (String input : inputList) {
            int index = bigString.indexOf(input);
            if (index >= 0) {
                int endIndex = bigString.indexOf("}", index) + 1;
                String css = bigString.substring(index, endIndex);
                outputList.put(input, css);
            }
        }
        return outputList;
    }


    public static Map<String, String> generateOutput(String bigString, List<String> inputList) {
        Map<String, String> outputList = new HashMap<>();

        // Loop through each input in the inputList
        for (String input : inputList) {
            // Find the start index of the input in bigString
            int startIndex = bigString.indexOf(input);
            if (startIndex == -1) {
                // Input not found in bigString, skip to next input
                continue;
            }

            // Find the end index of the input in bigString
            int endIndex = bigString.indexOf(")", startIndex);
            if (endIndex == -1) {
                // Matching closing parenthesis not found, skip to next input
                continue;
            }

            // Extract the text between the input and closing parenthesis
            String text = bigString.substring(startIndex + input.length(), endIndex);

            // Add the input and extracted text to the output map
            outputList.put(input, text.trim());
        }

        return outputList;
    }
    public static String getSubstringBetween(String largeString, String startString, String endString) {
        int startIndex = largeString.indexOf(startString);
        int endIndex = largeString.indexOf(endString, startIndex + startString.length());
        if (startIndex == -1 || endIndex == -1) {
            return "";
        }
        return largeString.substring(startIndex + startString.length(), endIndex);
    }
    public static String getStringBetween(String inputStr, String startStr, String endStr) {
        int startIndex = inputStr.indexOf(startStr);
        if (startIndex != -1) {
            startIndex += startStr.length();
            int endIndex = inputStr.indexOf(endStr, startIndex);
            if (endIndex != -1) {
                return inputStr.substring(startIndex, endIndex);
            }
        }
        return null;
    }

    public static String getSubstringBetween(String str1, String str2, String largeStr) {
        int startIdx = largeStr.indexOf(str1);
        if (startIdx == -1) {
            return null;
        }
        startIdx += str1.length();
        int endIdx = largeStr.lastIndexOf(str2);
        if (endIdx == -1) {
            return null;
        }
        return largeStr.substring(startIdx, endIdx);
    }

    public String extractString(String start, String end, String bigString) {
        int startIndex = bigString.indexOf(start) + start.length();
        int endIndex = bigString.indexOf(end, startIndex);
        if (startIndex == -1 || endIndex == -1) {
            return null;
        }
        return bigString.substring(startIndex, endIndex).trim();
    }

    public static void removeDotsFromKeys(Map<String, ?> map) {
        Set<String> keys = new HashSet<>(map.keySet());
        for (String key : keys) {
            if (key.contains(".")) {
                Object value = map.remove(key);
                String newKey = key.replaceAll("\\.", "");
                map.put(newKey, value);
            }
        }
    }
    public static HashMap<String, String> removeDotFromKeys(HashMap<String, String> originalMap) {
        HashMap<String, String> updatedMap = new HashMap<>();
        for (String key : originalMap.keySet()) {
            if (key.contains(".")) {
                String updatedKey = key.replace(".", "");
                updatedMap.put(updatedKey, originalMap.get(key));
            } else {
                updatedMap.put(key, originalMap.get(key));
            }
        }
        return updatedMap;
    }

    public static List<String> extractStrings(String bigString, String word) {
        List<String> extractedStrings = new ArrayList<>();
        String startTag = "<" + word + ">";
        String endTag = "</" + word + ">";
        int startIndex = bigString.indexOf(startTag);
        while (startIndex != -1) {
            int endIndex = bigString.indexOf(endTag, startIndex);
            String extractedString = bigString.substring(startIndex + startTag.length(), endIndex);
            extractedStrings.add(extractedString);
            startIndex = bigString.indexOf(startTag, endIndex);
        }
        return extractedStrings;
    }


    public static List<String> extractStrings(String bigString, String word) {
        List<String> extractedStrings = new ArrayList<>();
        String startTag = "<" + word + ">";
        String endTag = "</" + word + ">";
        int startIndex = bigString.indexOf(startTag);
        while (startIndex != -1) {
            int endIndex = bigString.indexOf(endTag, startIndex);
            if (endIndex != -1) {
                String extractedString = bigString.substring(startIndex, endIndex + endTag.length());
                extractedStrings.add(extractedString);
            } else {
                // end tag not found, break out of loop
                break;
            }
            startIndex = bigString.indexOf(startTag, endIndex);
        }
        return extractedStrings;
    }



    public static List<String> extractStrings(String bigString, List<String> words) {
        List<String> extractedStrings = new ArrayList<>();
        for (String word : words) {
            String startTag = "<" + word + ">";
            String endTag = "</" + word + ">";
            int startIndex = bigString.indexOf(startTag);
            while (startIndex != -1) {
                int endIndex = bigString.indexOf(endTag, startIndex);
                if (endIndex != -1) {
                    String extractedString = bigString.substring(startIndex, endIndex + endTag.length());
                    extractedStrings.add(extractedString);
                } else {
                    // end tag not found, break out of loop
                    break;
                }
                startIndex = bigString.indexOf(startTag, endIndex);
            }
        }
        return extractedStrings;
    }


    import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

    public class HTMLFormatter {

        public static List<String> formatHTML(Map<String, String> inputMap, List<String> inputList) {
            List<String> outputList = new ArrayList<>();
            for (String input : inputList) {
                StringBuilder output = new StringBuilder();
                String[] tokens = input.split("(?<=\\})|(?=\\{)");
                for (String token : tokens) {
                    if (token.startsWith("{")) {
                        output.append(" style=\"" + inputMap.get(token.substring(1)) + "\">");
                    } else if (token.endsWith("}")) {
                        output.append("</" + token.substring(0, token.length() - 1) + ">");
                    } else {
                        output.append(token);
                    }
                }
                outputList.add(output.toString());
            }
            return outputList;
        }

        public static void main(String[] args) {
            Map<String, String> inputMap = new HashMap<>();
            inputMap.put("c49", "padding-top:0pt;padding-bottom:0pt;line-height:1.15;text-align:left");
            inputMap.put("c42", "background-color:#ffff00");
            inputMap.put("c37", "font-weight:700");
            inputMap.put("c24", "padding-top:0pt;padding-bottom:9pt;line-height:1.15;text-align:left");
            inputMap.put("c10", "padding-top:12pt;padding-bottom:6pt;line-height:1.15;text-align:left");
            inputMap.put("c5", "border-right-style:solid;padding:7.2pt 7.2pt 7.2pt 7.2pt;border-bottom-color:#ffffff;border-top-width:0pt;border-right-width:0pt; border-left-color:#ffffff;vertical-align:middle;border-right-color:#ffffff;border-left-width:0pt;border-top-style:solid;border-left-style:solid;border-bottom-width:0pt;width:138.8pt;border-top-color:#ffffff;border-bottom-style:solid");
            inputMap.put("c18", "color:#000000;font-weight:400;text-decoration:none;vertical-align:baseline;font-size:10pt;font-family:\"Arial\";font-style:normal");
            inputMap.put("c17", "height:0pt");
            inputMap.put("c16", "background-color:#ffff00;color:#000000;font-weight:400;text-decoration:none;vertical-align:baseline;font-size:10pt;font-family:\"Arial\";font-style:normal");

            List<String> inputList = new ArrayList<>();
            inputList.add("<p class=\"c49\"><span class=\"c42 c37\">%%Entity_name_full%%</span><span class=\"c16\"><br>%%Street%%% %Number%%</span></p>");
            inputList.add("<p class=\"c24\"><span class=\"c42\">%%zip%%%%City%%<br>%%Country%%</span></p>");
            inputList.add("<p class=\"c10 c5\"><span class=\"c18\"></span></p>");

            List<String> outputList = formatHTML(inputMap, inputList);

            for (String output : outputList) {
                System.out.println(output);
            }
        }
    }


    import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

    public class CssStyleConverter {

        public static List<String> convert(List<String> inputList, Map<String, String> inputMap) {
            List<String> outputList = new ArrayList<String>();

            for (String input : inputList) {
                StringBuilder output = new StringBuilder();

                // extract the class name from the input string
                String className = input.substring(input.indexOf("class=\"") + 7, input.indexOf("\"", input.indexOf("class=\"") + 7));

                // get the corresponding CSS style for the class name
                String cssStyle = inputMap.get(className);
                if (cssStyle == null) {
                    // if no CSS style is found for the class, use an empty style
                    cssStyle = "{}";
                }

                // add the style attribute to the output string
                output.append(input.substring(0, input.indexOf("class=\"") + 7));
                output.append(cssStyle.substring(0, cssStyle.length() - 1)); // remove the closing bracket
                output.append(";\"");
                output.append(input.substring(input.indexOf("\"", input.indexOf("class=\"") + 7)));

                // add the rest of the input string to the output string
                output.append(input.substring(input.indexOf(">") + 1, input.lastIndexOf("<")));

                // add the output string to the output list
                outputList.add(output.toString());
            }

            return outputList;
        }

        public static void main(String[] args) {
            // sample input
            Map<String, String> inputMap = new HashMap<String, String>();
            inputMap.put("c49", "{padding-top:0pt;padding-bottom:0pt;line-height:1.15;text-align:left");
            inputMap.put("c42", "{background-color:#ffff00");
            inputMap.put("c37", "{font-weight:700");
            inputMap.put("c24", "{padding-top:0pt;padding-bottom:9pt;line-height:1.15;text-align:left");
            inputMap.put("c10", "{padding-top:12pt;padding-bottom:6pt;line-height:1.15;text-align:left");
            inputMap.put("c5", "{border-right-style:solid;padding:7.2pt 7.2pt 7.2pt 7.2pt;border-bottom-color:#ffffff;border-top-width:0pt;border-right-width:0pt; border-left-color:#ffffff;vertical-align:middle;border-right-color:#ffffff;border-left-width:0pt;border-top-style:solid;border-left-style:solid;border- bottom-width:0pt;width:138.8pt;border-top-color:#ffffff;border-bottom-style:solid");
            inputMap.put("c18", "{color:#000000;font-weight:400;text-decoration:none;vertical-align:baseline;font-size:10pt;font-family:\"Arial\";font-style:normal ");
            inputMap.put("c17", "{height:0pt");
            inputMap.put("c16", "{background-color:#ffff00;color:#000000;font-weight:400;text-decoration:none;vertical-align:baseline;font-size:10pt;font-family:\"Arial\";font-style:normal");

            List<String> inputList = new ArrayList<String>();
            inputList.add("<p class=\"c49\"><span class=\"c42 c37\">%%Entity_name_full%%</span><span class=\"c16\"><br>%%Street%%% %Number%%</span></p>");
            inputList.add("<p class=\"c24\"><span class=\"c42\">%%zip%%%%City%%<br>%%Country%%</



            );
            public static Map<String, String> removeCurlyBraces(Map<String, String> inputMap) {
                Map<String, String> outputMap = new HashMap<>();

                for (Map.Entry<String, String> entry : inputMap.entrySet()) {
                    String value = entry.getValue();
                    if (value != null && value.contains("{")) {
                        value = value.replaceAll("\\{", "");
                    }
                    outputMap.put(entry.getKey(), value);
                }

                return outputMap;
            }


            public static List<String> updateSpanList(Map<String, String> inputMap, List<String> spanList) {
                List<String> updatedList = new ArrayList<>();
                for (String span : spanList) {
                    StringBuilder sb = new StringBuilder(span);
                    int index = sb.indexOf("class=\"");
                    while (index != -1) {
                        int endIndex = sb.indexOf("\"", index + 7);
                        String className = sb.substring(index + 7, endIndex);
                        if (inputMap.containsKey(className)) {
                            String style = "style=\"" + inputMap.get(className) + "\"";
                            sb.insert(endIndex + 1, " " + style);
                        }
                        index = sb.indexOf("class=\"", endIndex);
                    }
                    updatedList.add(sb.toString());
                }
                return updatedList;
            }


            public static List<String> updateSpanList(Map<String, String> inputMap, List<String> spanList) {
                List<String> updatedList = new ArrayList<>();
                for (String span : spanList) {
                    StringBuilder sb = new StringBuilder(span);
                    int index = sb.indexOf("class=\"");
                    while (index != -1) {
                        int endIndex = sb.indexOf("\"", index + 7);
                        String classNames = sb.substring(index + 7, endIndex);
                        String[] classes = classNames.split(" ");
                        String style = "";
                        for (String className : classes) {
                            if (inputMap.containsKey(className)) {
                                if (!style.isEmpty()) {
                                    style += "; ";
                                }
                                style += inputMap.get(className);
                            }
                        }
                        if (!style.isEmpty()) {
                            sb.insert(endIndex + 1, " style=\"" + style + "\"");
                        }
                        index = sb.indexOf("class=\"", endIndex);
                    }
                    updatedList.add(sb.toString());
                }
                return updatedList;
            }

            public List<String> addStylesToSpanList(Map<String, String> inputMap, List<String> spanList) {
                List<String> modifiedList = new ArrayList<>();
                for (String span : spanList) {
                    int classIndex = span.indexOf("class=\"");
                    if (classIndex != -1) {
                        int endIndex = span.indexOf("\"", classIndex + 7);
                        if (endIndex != -1) {
                            String className = span.substring(classIndex + 7, endIndex);
                            String style = inputMap.get(className);
                            if (style != null) {
                                span = span.replace(classIndex + 6, classIndex + 7, "style=\"" + style + "\" ");
                            }
                        }
                    }
                    modifiedList.add(span);
                }
                return modifiedList;
            }

            public Map<String, String> removeInvalidValues(Map<String, String> map) {
                Map<String, String> result = new HashMap<>();
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    String value = entry.getValue();
                    if (value.startsWith("{")) {
                        value = value.substring(1);
                    } else if (value.matches("^\\d+\\{.*")) {
                        continue; // skip invalid objects
                    }
                    result.put(entry.getKey(), value);
                }
                return result;
            }


            public static String replaceStyles(String bigString, List<String> withoutStyle, List<String> zStyle) {
                if (withoutStyle.size() != zStyle.size()) {
                    throw new IllegalArgumentException("Lists must be the same size");
                }
                for (int i = 0; i < withoutStyle.size(); i++) {
                    bigString = bigString.replace(withoutStyle.get(i), zStyle.get(i));
                }
                return bigString;
            }

            public List<String> addBraceToList(List<String> inputList) {
                return inputList.stream()
                        .map(str -> str.length() == 1 && str.charAt(0) == 'c' ? str + "{" : str)
                        .collect(Collectors.toList());
            }


            public static Map<String, String> extractData(String bigString, List<String> inputList) {
                Map<String, String> outputList = new HashMap<>();
                for (String input : inputList) {
                    int pos = bigString.indexOf(input);
                    if (pos >= 0) {
                        int startPos = pos + input.length();
                        int endPos = bigString.indexOf(")", startPos);
                        if (endPos < 0) {
                            endPos = bigString.length();
                        }
                        String data = bigString.substring(startPos, endPos);
                        outputList.put(input, data);
                    }
                }
                return outputList;
            }
            public static Map<String, String> extractData(String bigString, List<String> inputList) {
                Map<String, String> outputList = new HashMap<>();
                for (String input : inputList) {
                    int pos = bigString.indexOf(input);
                    if (pos >= 0) {
                        int startPos = bigString.indexOf("(", pos) + 1;
                        int endPos = bigString.indexOf(")", startPos);
                        if (endPos < 0) {
                            endPos = bigString.length();
                        }
                        String data = bigString.substring(startPos, endPos);
                        outputList.put(input, data);
                    }
                }
                return outputList;
            }

import java.util.*;

            public class CssParser {

                public static Map<String, String> parseCss(String bitInput, List<String> inputList) {
                    Map<String, String> outputMap = new HashMap<>();
                    String[] cssSegments = bitInput.split("\\}");
                    for (String cssSegment : cssSegments) {
                        String[] cssRules = cssSegment.split("\\{");
                        if (cssRules.length == 2) {
                            String cssSelector = cssRules[0].trim();
                            String cssProperties = cssRules[1].trim();
                            if (inputList.contains(cssSelector)) {
                                outputMap.put(cssSelector, cssProperties);
                            }
                        }
                    }
                    return outputMap;
                }

                public static void main(String[] args) {
                    String bitInput = "pt}.c73{background-color:#fef6f0}.c31{height:20.9pt}.c39{height:24.4pt}.c17{heig";
                    List<String> inputList = Arrays.asList(".c73",".c31",".c39");
                    Map<String, String> outputMap = parseCss(bitInput, inputList);
                    System.out.println(outputMap);
                }
            }

import java.util.*;

            public class CSSParser {
                public static Map<String, String> parseCSS(String bitInput, List<String> inputList) {
                    Map<String, String> outputMap = new HashMap<>();
                    String[] parts = bitInput.split("[{}]");
                    for (int i = 0; i < parts.length - 1; i += 2) {
                        String selector = parts[i].trim();
                        String css = parts[i + 1].trim();
                        if (inputList.contains(selector)) {
                            outputMap.put(selector, css);
                        }
                    }
                    return outputMap;
                }
            }


            public List<String> extractStringList(String bigString) {
                List<String> stringList = new ArrayList<>();
                Pattern pattern = Pattern.compile("\\}(.*?)\\{");
                Matcher matcher = pattern.matcher(bigString);
                while (matcher.find()) {
                    String match = matcher.group(1);
                    if (match.startsWith(".")) {
                        stringList.add(match);
                    }
                }
                return stringList;
            }


            import java.util.ArrayList;
import java.util.List;

            public class StringParser {

                public static List<String> parseStrings(String bigString) {
                    List<String> stringList = new ArrayList<>();
                    int startIndex = 0;
                    int endIndex = 0;
                    while (startIndex != -1 && endIndex != -1) {
                        startIndex = bigString.indexOf("}", endIndex);
                        if (startIndex == -1) {
                            break;
                        }
                        endIndex = bigString.indexOf("{", startIndex);
                        if (endIndex == -1) {
                            break;
                        }
                        String subString = bigString.substring(startIndex + 1, endIndex);
                        stringList.add(subString);
                    }
                    return stringList;
                }

                public static void main(String[] args) {
                    String bigString = "This is a {test.value} string {with.some.other.value} values.";
                    List<String> stringList = parseStrings(bigString);
                    for (String string : stringList) {
                        System.out.println(string);
                    }
                }
            }


            public static String addStyleToClass(String bigString, Map<String, String> inputMap) {
                String patternString = "class=\"([^\"]*)\"";
                Pattern pattern = Pattern.compile(patternString);
                Matcher matcher = pattern.matcher(bigString);
                StringBuffer outputString = new StringBuffer();
                while (matcher.find()) {
                    String classValues = matcher.group(1);
                    String[] classArray = classValues.split(" ");
                    String styleValues = "";
                    for (String classValue : classArray) {
                        if (inputMap.containsKey(classValue)) {
                            styleValues += inputMap.get(classValue) + ";";
                        }
                    }
                    if (!styleValues.isEmpty()) {
                        String styleAttribute = "style=\"" + styleValues.substring(0, styleValues.length() - 1) + "\"";
                        matcher.appendReplacement(outputString, "class=\"" + classValues + " \" " + styleAttribute);
                    }
                }
                matcher.appendTail(outputString);
                return outputString.toString();
            }


            import java.io.*;
import org.apache.poi.xwpf.usermodel.*;

            public static File htmlToDocx(String html) {
                File outputFile = null;
                try {
                    // Create a new docx document
                    XWPFDocument doc = new XWPFDocument();

                    // Parse the HTML and add it to the document
                    XWPFParagraph para = doc.createParagraph();
                    XWPFRun run = para.createRun();
                    run.setText(html);

                    // Write the document to a file
                    outputFile = File.createTempFile("output", ".docx");
                    FileOutputStream out = new FileOutputStream(outputFile);
                    doc.write(out);
                    out.close();

                    System.out.println("HTML converted to docx successfully!");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return outputFile;
            }


            public static String removeBackslash(String input) {
                StringBuilder output = new StringBuilder();
                boolean escaped = false;
                for (int i = 0; i < input.length(); i++) {
                    char c = input.charAt(i);
                    if (escaped) {
                        if (c == '\"') {
                            output.append(c);
                        } else {
                            output.append('\\');
                            output.append(c);
                        }
                        escaped = false;
                    } else if (c == '\\') {
                        escaped = true;
                    } else {
                        output.append(c);
                    }
                }
                return output.toString();
            }




            <dependencies>
    <dependency>
        <groupId>org.docx4j</groupId>
        <artifactId>docx4j</artifactId>
        <version>11.3.2</version>
    </dependency>
    <dependency>
        <groupId>org.docx4j</groupId>
        <artifactId>docx4j-ImportXHTML</artifactId>
        <version>11.3.2</version>
    </dependency>
</dependencies>

            import java.io.File;

import org.docx4j.Docx4J;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.convert.in.xhtml.XHTMLImporter;
import org.docx4j.convert.in.xhtml.XHTMLImporterImpl;

            public class HTMLtoDOCXConverter {
                public static File convertHtmlToDocx(String html, String outputFilename) {
                    File outputFile = null;
                    try {
                        // Create a new WordprocessingMLPackage
                        WordprocessingMLPackage wordMLPackage = WordprocessingMLPackage.createPackage();

                        // Configure the XHTML importer
                        XHTMLImporter xhtmlImporter = new XHTMLImporterImpl(wordMLPackage);

                        // Convert the HTML string to a list of docx objects
                        wordMLPackage.getMainDocumentPart().getContent().addAll(xhtmlImporter.convert(html, null));

                        // Save the resulting docx file
                        outputFile = new File(outputFilename);
                        wordMLPackage.save(outputFile);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return outputFile;
                }

                public static void main(String[] args) {
                    String html = "<html><head><title>Test</title></head><body><h1>Hello, World!</h1></body></html>";
                    String outputFilename = "output.docx";
                    File outputFile = convertHtmlToDocx(html, outputFilename);
                    System.out.println("File saved to: " + outputFile.getAbsolutePath());
                }
            }



            public static String removeBackslashBeforeDoubleQuote(String bigString) {
                if (bigString == null) {
                    return null;
                }

                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < bigString.length(); i++) {
                    char currentChar = bigString.charAt(i);

                    if (currentChar == '\\' && (i + 1) < bigString.length() && bigString.charAt(i + 1) == '\"') {
                        continue; // Skip the current backslash character
                    }

                    sb.append(currentChar);
                }

                return sb.toString();
            }


            import java.io.File;
import java.io.OutputStream;
import java.io.FileOutputStream;
import org.docx4j.Docx4J;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.convert.in.xhtml.XHTMLImporterImpl;
import org.docx4j.convert.in.xhtml.XHTMLImporter;

            public static File htmlStringToDocx(String htmlString, String outputDocxFilePath) {
                File outputFile = null;

                try {
                    // Create a new WordprocessingMLPackage
                    WordprocessingMLPackage wordMLPackage = WordprocessingMLPackage.createPackage();

                    // Create an XHTMLImporter with the WordprocessingMLPackage
                    XHTMLImporter xhtmlImporter = new XHTMLImporterImpl(wordMLPackage);

                    // Convert the HTML string to a list of docx4j objects
                    List<Object> convertedObjects = xhtmlImporter.convert(htmlString, null);

                    // Add the converted objects to the WordprocessingMLPackage's main document part
                    wordMLPackage.getMainDocumentPart().getContent().addAll(convertedObjects);

                    // Save the WordprocessingMLPackage to a .docx file
                    outputFile = new File(outputDocxFilePath);
                    try (OutputStream outputStream = new FileOutputStream(outputFile)) {
                        Docx4J.save(wordMLPackage, outputStream, Docx4J.FLAG_SAVE_ZIP_FILE);
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }

                return outputFile;
            }


     <dependencies>
  <dependency>
    <groupId>org.docx4j</groupId>
    <artifactId>docx4j</artifactId>
    <version>11.3.2</version>
  </dependency>
  <dependency>
    <groupId>org.docx4j</groupId>
    <artifactId>docx4j-ImportXHTML</artifactId>
    <version>11.3.2</version>
  </dependency>
</dependencies>

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

            public static String readHtmlFromFile(String inputFilePath) throws IOException {
                File inputFile = new File(inputFilePath);
                byte[] fileBytes = Files.readAllBytes(inputFile.toPath());
                return new String(fileBytes, StandardCharsets.UTF_8);
            }


            import java.io.File;
import java.io.OutputStream;
import java.io.FileOutputStream;
import org.docx4j.Docx4J;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.openpackaging.parts.WordprocessingML.StyleDefinitionsPart;
import org.docx4j.convert.in.xhtml.XHTMLImporterImpl;
import org.docx4j.convert.in.xhtml.XHTMLImporter;
import org.docx4j.wml.Styles;

            public static File htmlStringToDocx(String htmlString, String outputDocxFilePath) {
                File outputFile = null;

                try {
                    // Create a new WordprocessingMLPackage
                    WordprocessingMLPackage wordMLPackage = WordprocessingMLPackage.createPackage();

                    // Create a StyleDefinitionsPart and add it to the MainDocumentPart
                    StyleDefinitionsPart stylePart = new StyleDefinitionsPart();
                    wordMLPackage.getMainDocumentPart().addTargetPart(stylePart);
                    Styles styles = new org.docx4j.wml.ObjectFactory().createStyles();
                    stylePart.setJaxbElement(styles);

                    // Create an XHTMLImporter with the WordprocessingMLPackage
                    XHTMLImporter xhtmlImporter = new XHTMLImporterImpl(wordMLPackage);

                    // Convert the HTML string to a list of docx4j objects
                    List<Object> convertedObjects = xhtmlImporter.convert(htmlString, null);

                    // Add the converted objects to the WordprocessingMLPackage's main document part
                    wordMLPackage.getMainDocumentPart().getContent().addAll(convertedObjects);

                    // Save the WordprocessingMLPackage to a .docx file
                    outputFile = new File(outputDocxFilePath);
                    try (OutputStream outputStream = new FileOutputStream(outputFile)) {
                        Docx4J.save(wordMLPackage, outputStream, Docx4J.FLAG_SAVE_ZIP_FILE);
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }

                return outputFile;
            }



            import org.docx4j.Docx4J;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.openpackaging.parts.PartName;
import org.docx4j.openpackaging.parts.WordprocessingML.BinaryPartAbstractImage;
import org.docx4j.openpackaging.parts.WordprocessingML.MainDocumentPart;
import org.docx4j.relationships.Relationship;
import org.docx4j.wml.P;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

            public class HtmlToDocxConverter {

                public static void main(String[] args) throws Exception {
                    // Read HTML file
                    String htmlFilePath = "path/to/your/html/file.html";
                    File htmlFile = new File(htmlFilePath);
                    InputStream inputStream = new FileInputStream(htmlFile);
                    String htmlContent = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);

                    // Create a new WordprocessingMLPackage
                    WordprocessingMLPackage wordMLPackage = WordprocessingMLPackage.createPackage();

                    // Convert HTML to docx
                    MainDocumentPart documentPart = wordMLPackage.getMainDocumentPart();
                    List<P> paragraphs = documentPart.convertHtml(htmlContent, null, null);
                    for (P paragraph : paragraphs) {
                        documentPart.addObject(paragraph);
                    }

                    // Save the docx file
                    String outputFilePath = "path/to/output/docx/file.docx";
                    Docx4J.save(wordMLPackage, new File(outputFilePath), Docx4J.FLAG_SAVE_ZIP_FILE);
                }
            }

            public static File convertHtmlToDocx(String inputHtmlPath, String outputDocxPath) throws Exception {
                // Read HTML file
                File htmlFile = new File(inputHtmlPath);
                InputStream inputStream = new FileInputStream(htmlFile);
                String htmlContent = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);

                // Create a new WordprocessingMLPackage
                WordprocessingMLPackage wordMLPackage = WordprocessingMLPackage.createPackage();

                // Convert HTML to docx
                List<P> paragraphs = wordMLPackage.getMainDocumentPart().convertHtml(htmlContent, null, null);
                for (P paragraph : paragraphs) {
                    wordMLPackage.getMainDocumentPart().addObject(paragraph);
                }

                // Save the docx file
                File outputFile = new File(outputDocxPath);
                Docx4J.save(wordMLPackage, outputFile, Docx4J.FLAG_SAVE_ZIP_FILE);
                return outputFile;
            }
            public static File convertHtmlToDocx(String inputHtmlPath, String outputDocxPath) throws Exception {

            // Read HTML file
            File htmlFile = new File(inputHtmlPath);
            InputStream inputStream = new FileInputStream(htmlFile);
            String htmlContent = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);

            // Create a new WordprocessingMLPackage
            WordprocessingMLPackage wordMLPackage = WordprocessingMLPackage.createPackage();

            // Configure XHTML Importer
            XHTMLImporterImpl xhtmlImporter = new XHTMLImporterImpl(wordMLPackage);
            xhtmlImporter.setHyperlinkStyle("Hyperlink");

            // Convert HTML to docx
            List<Object> convertedObjects = xhtmlImporter.convert(htmlContent, null);
            for (Object o : convertedObjects) {
                if (o instanceof P) {
                    wordMLPackage.getMainDocumentPart().addObject(o);
                }
            }

            // Save the docx file
            File outputFile = new File(outputDocxPath);
            Docx4J.save(wordMLPackage, outputFile, Docx4J.FLAG_SAVE_ZIP_FILE);
            return outputFile;
        }


        import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import org.docx4j.Docx4J;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.wml.P;
import org.docx4j.wml.R;
import org.docx4j.wml.Text;

import java.io.File;
import java.io.IOException;

            public class HtmlToDocx {

                public static void main(String[] args) {
                    String html = "<h1>Title</h1><p>Sample paragraph.</p>";
                    try {
                        htmlToDocx(html, "output.docx");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                public static void htmlToDocx(String html, String outputPath) throws Exception {
                    // Parse HTML using jsoup
                    Document document = Jsoup.parse(html);
                    Elements elements = document.body().children();

                    // Create a new docx file
                    WordprocessingMLPackage wordMLPackage = WordprocessingMLPackage.createPackage();

                    // Iterate through HTML elements and add them to the docx
                    for (Element element : elements) {
                        P paragraph = wordMLPackage.getMainDocumentPart().createParagraphOfText("");
                        R run = new R();
                        Text text = new Text();
                        text.setValue(element.text());
                        run.getContent().add(text);
                        paragraph.getContent().add(run);
                        wordMLPackage.getMainDocumentPart().getContent().add(paragraph);
                    }

                    // Save the docx file
                    Docx4J.save(wordMLPackage, new File(outputPath), Docx4J.FLAG_SAVE_ZIP_FILE);
                }
            }



            import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.apache.poi.xwpf.usermodel.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

            public class HtmlToDocxConverter {

                public static File htmlToDocx(String html) throws IOException {
                    // Parse the HTML content using Jsoup
                    Document document = Jsoup.parse(html);

                    // Create a new DOCX document
                    XWPFDocument docxDocument = new XWPFDocument();

                    // Iterate through the elements in the HTML content
                    for (Node node : document.body().childNodes()) {
                        if (node instanceof Element) {
                            Element element = (Element) node;

                            if (element.tagName().equalsIgnoreCase("p")) {
                                XWPFParagraph docxParagraph = docxDocument.createParagraph();
                                XWPFRun run = docxParagraph.createRun();
                                run.setText(element.text());
                            } else if (element.tagName().equalsIgnoreCase("img")) {
                                String imageUrl = element.absUrl("src");
                                XWPFParagraph docxParagraph = docxDocument.createParagraph();
                                XWPFRun run = docxParagraph.createRun();

                                try {
                                    run.addPicture(new URL(imageUrl).openStream(), XWPFDocument.PICTURE_TYPE_JPEG, imageUrl, Units.toEMU(200), Units.toEMU(200));
                                } catch (Exception e) {
                                    System.err.println("Error adding image: " + imageUrl + ", " + e.getMessage());
                                }
                            }
                        }
                    }

                    // Create a temporary file and save the DOCX document to it
                    File tempFile = File.createTempFile("convertedDocx", ".docx");
                    try (FileOutputStream out = new FileOutputStream(tempFile)) {
                        docxDocument.write(out);
                    }

                    return tempFile;
                }
            }
