package com.tasks.ChatGPTTests.byteToFileConverter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;

public class ByteToFileConverter {

//    public static File convertByteToFile(byte[] byteArray, String fileName) throws IOException {
//        File tempFile = Files.createTempFile(fileName, ".tmp").toFile();
//
//        try (FileOutputStream fos = new FileOutputStream(tempFile)) {
//            fos.write(byteArray);
//        }
//
//        return tempFile;
//    }

    public static File convertByteToFile(byte[] byteArray, String fileName) throws IOException {
        String newFileName = fileName + ".docx";


        File tempFile = new File(newFileName);

        try (FileOutputStream fos = new FileOutputStream(tempFile)) {
            fos.write(byteArray);
        }
        return tempFile;
    }
}

