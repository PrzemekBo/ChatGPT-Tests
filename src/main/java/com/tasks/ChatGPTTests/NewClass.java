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
