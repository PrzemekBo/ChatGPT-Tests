package com.tasks.ChatGPTTests;

import com.tasks.ChatGPTTests.stringMatcher.StringMatcher;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import java.util.List;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class ChatGptTestsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChatGptTestsApplication.class, args);

		List<String> result = StringMatcher.findDollarStrings("nfcnifncfi" +
				"$$hug$$" +
				"njdfdbjfbj$jcbdsjcbsdj" +
				"$$bhdbhdbh$$" +
				"jbsdjbdsuf" +
				"$$bsbdubasubdiasbdbaus$$" +
				"bsabduaus$$$$gsgys$$$$ggjuujmj$$hyukk");
		System.out.println(result);

	}

}
