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


