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




);


