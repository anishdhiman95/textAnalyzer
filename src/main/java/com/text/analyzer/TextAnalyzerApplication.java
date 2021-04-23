package com.text.analyzer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Auto-configuration class to enable @EnableAutoConfiguration, @ComponentScan
 * and @Configuration for this Spring Boot Application.
 * 
 * @author anishdhiman95
 */
@SpringBootApplication
public class TextAnalyzerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TextAnalyzerApplication.class, args);
	}

}
