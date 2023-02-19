package com.tasks.ChatGPTTests.byteToFileConverter;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.junit.Test;

public class ByteToFileConverterTest {

    @Test
    public void testConvertByteToFile() throws IOException {
        // create a test byte array
        byte[] testBytes = "Hello, world!".getBytes();
        // call the conversion method
        File tempFile = ByteToFileConverter.convertByteToFile(testBytes, "test");
        // make sure the file was created and has the correct name
        assertTrue(tempFile.exists());
        assertEquals("test.docx", tempFile.getName());
        // read the contents of the file and make sure they match the original byte array
        byte[] fileBytes = Files.readAllBytes(tempFile.toPath());
        assertArrayEquals(testBytes, fileBytes);
    }

    @Test(expected = IOException.class)
    public void testConvertByteToFileInvalidFileName() throws IOException {
        // create a test byte array
        byte[] testBytes = "Hello, world!".getBytes();
        // call the conversion method with an invalid file name
        ByteToFileConverter.convertByteToFile(testBytes, ""); // empty file name should throw an exception
    }

    @Test(expected = NullPointerException.class)
    public void testConvertByteToFileNullByteArray() throws IOException {
        // call the conversion method with a null byte array
        ByteToFileConverter.convertByteToFile(null, "test");
    }
}
