package com.subhajit.SpringBootPropFileReader;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

@SpringBootApplication
@PropertySources({
		@PropertySource("classpath:custom1.properties"),
		@PropertySource("classpath:custom2.properties"),
		@PropertySource(value = "classpath:custom3.properties", ignoreResourceNotFound = true),
		@PropertySource(value = "file:/D:\\External_props\\custom4.properties")
})
public class SpringBootPropFileReaderApplication extends ServletInitializer{

	public static void main(String[] args) {
		System.out.println("In main.......");
		SpringApplication.run(SpringBootPropFileReaderApplication.class, args);
	}

}

// This Spring boot app shows various techniques of reading internal and external properties file.