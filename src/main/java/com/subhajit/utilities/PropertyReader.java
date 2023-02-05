package com.subhajit.utilities;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.stereotype.Component;

@Component
public class PropertyReader {

	public String getPropertyClasspath(String key) {
		Resource resource = new ClassPathResource("/custom5.properties");
		try {
			System.out.println(resource.getFilename());
			Properties props = PropertiesLoaderUtils.loadProperties(resource);
			return props.getProperty(key);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public String getPropertyExtlocation(String key) {
		try {
			//FileReader reader=new FileReader("D:\\External_props\\custom6.properties"); 
			FileReader reader=new FileReader(System.getProperty("test.file.path")); 
		      
		    Properties p=new Properties();  
		    p.load(reader);  
		      
			return p.getProperty(key);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
