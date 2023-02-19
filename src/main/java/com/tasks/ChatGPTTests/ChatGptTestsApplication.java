package com.tasks.ChatGPTTests;

import com.tasks.ChatGPTTests.byteToFileConverter.ByteToFileConverter;
import com.tasks.ChatGPTTests.stringMatcher.StringMatcher;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.List;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class ChatGptTestsApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(ChatGptTestsApplication.class, args);

		List<String> result = StringMatcher.findDollarStrings("nfcnifncfi" +
				"$$hug$$" +
				"njdfdbjfbj$jcbdsjcbsdj" +
				"$$bhdbhdbh$$" +
				"jbsdjbdsuf" +
				"$$bsbdubasubdiasbdbaus$$" +
				"bsabduaus$$$$gsgys$$$$ggjuujmj$$hyukk");
		System.out.println(result);
		byte[] data = { 65, 66, 67, 68, 69 }; // example byte array
		File file = ByteToFileConverter.convertByteToFile(data,"fileName");
		System.out.println(file);

	}

}
