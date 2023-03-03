package com.subhajit.SpringBootPropFileReader;

import com.subhajit.SpringBootPropFileReader.bean.ConfigProperties;
import com.subhajit.SpringBootPropFileReader.bean.StudentConfigProperties;
import com.subhajit.SpringBootPropFileReader.bean.TeacherConfigProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.subhajit.utilities.PropertyReader;

@RestController
public class IntExtPropfileReadController {

	@Autowired
	private ConfigProperties configProperties;

	@Autowired
	private TeacherConfigProperties teacherConfigProperties;

	@Autowired
	private StudentConfigProperties studentConfigProperties;

	@GetMapping("/test-precedence")
	public ResponseEntity<String> testPrecedence(@Value("${key.name:'dummy'}") String name){
		return new ResponseEntity("Values : " + name, HttpStatus.OK);
	}

	@GetMapping("/property-not-found")
	public ResponseEntity<String> propertyNotFound(@Value("${key.address:'dummy'}") String address){
		return new ResponseEntity("Values : " + address, HttpStatus.OK);
	}
	
	@GetMapping("/dynamic-classpath-prop-reading")
	public ResponseEntity<String> dynamicClasspathPropReading(){
		return new ResponseEntity("Values : " + new PropertyReader().getPropertyClasspath("key.name"),HttpStatus.OK);
	}
	
	@GetMapping("/dynamic-extlocation-prop-reading")
	public ResponseEntity<String> dynamicExtlocationPropReading(){
		return new ResponseEntity("Values : " + new PropertyReader().getPropertyExtlocation("key.name"),HttpStatus.OK);
	}

	@GetMapping(value = "/test-configuration-properties", produces = MediaType.APPLICATION_JSON_VALUE)
	public String testConfigurationProperties(){
		return configProperties.getId() + " - " + configProperties.getName() + " - " + configProperties.getAddress();
	}

	@GetMapping(value = "/test-teacher-configuration-properties", produces = MediaType.APPLICATION_JSON_VALUE)
	public TeacherConfigProperties testTeacherConfigurationProperties(){
		System.out.println("teacherConfigProperties controller ==> " + teacherConfigProperties + " - " + System.identityHashCode(teacherConfigProperties));
		return teacherConfigProperties;
	}

	@GetMapping(value = "/test-student-configuration-properties", produces = MediaType.APPLICATION_JSON_VALUE)
	public StudentConfigProperties testStudentConfigurationProperties(){
		return studentConfigProperties;
	}
}
