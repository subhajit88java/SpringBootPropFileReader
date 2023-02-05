package com.subhajit.SpringBootPropFileReader;

import java.util.Map;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.subhajit.utilities.PropertyReader;

@RestController
public class IntExtPropfileReadController {

	
	@GetMapping("/application-prop-wins")
	public ResponseEntity<String> applicationPropWins(@Value("${key.name}") String name, @RequestParam String city){
		System.out.println("City : " + city.toString());
		return new ResponseEntity("Values : " + name,HttpStatus.OK);
	}
	
	@GetMapping("/latest-prop-wins")
	public ResponseEntity<String> latestPropWins(@Value("${key.city}") String city){
		return new ResponseEntity("Values : " + city,HttpStatus.OK);
	}
	
	@GetMapping("/prop-outside-classpath")
	public ResponseEntity<String> propOutsideClasspath(@Value("${key.idol}") String idol){
		return new ResponseEntity("Values : " + idol,HttpStatus.OK);
	}
	
	@GetMapping("/dynamic-classpath-prop-reading")
	public ResponseEntity<String> dynamicClasspathPropReading(){
		
		return new ResponseEntity("Values : " + new PropertyReader().getPropertyClasspath("key.love"),HttpStatus.OK);
	}
	
	@GetMapping("/dynamic-extlocation-prop-reading")
	public ResponseEntity<String> dynamicExtlocationPropReading(){
		
		return new ResponseEntity("Values : " + new PropertyReader().getPropertyExtlocation("key.color"),HttpStatus.OK);
	}
}
