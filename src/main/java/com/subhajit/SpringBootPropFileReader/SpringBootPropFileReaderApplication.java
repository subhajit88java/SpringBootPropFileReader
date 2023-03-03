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
		@PropertySource(value = "classpath:file_absent.properties", ignoreResourceNotFound = true),
		@PropertySource(value = "file:/D:\\sb-property\\custom3.properties"),
		@PropertySource("classpath:custom-profile-${spring.profiles.active}.properties")
})
public class SpringBootPropFileReaderApplication{

	public static void main(String[] args) {
		SpringApplication.run(SpringBootPropFileReaderApplication.class, args);
	}

}

// This Spring boot app shows various techniques of reading internal and external properties file.