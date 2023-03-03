package com.subhajit.SpringBootPropFileReader.config;

import com.subhajit.SpringBootPropFileReader.bean.StudentConfigProperties;
import com.subhajit.SpringBootPropFileReader.bean.TeacherConfigProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class PropertyConfigurationFactory {

    @Bean
    @ConfigurationProperties(prefix = "teacher")
    @Profile("dev")
    public TeacherConfigProperties teacherConfigPropertiesDev(){
        TeacherConfigProperties teacherConfigProperties = new TeacherConfigProperties();
        System.out.println("teacherConfigProperties dev ==> " + teacherConfigProperties + " - " + System.identityHashCode(teacherConfigProperties));
        return teacherConfigProperties;
    }

    @Bean
    @ConfigurationProperties(prefix = "teacher")
    @Profile("qa")
    public TeacherConfigProperties teacherConfigPropertiesQa(){
        TeacherConfigProperties teacherConfigProperties = new TeacherConfigProperties();
        System.out.println("teacherConfigProperties qa ==> " + teacherConfigProperties + " - " + System.identityHashCode(teacherConfigProperties));
        return teacherConfigProperties;
    }

    @Bean
    @ConfigurationProperties(prefix = "teacher")
    @Profile("prod")
    public TeacherConfigProperties teacherConfigPropertiesProd(){
        TeacherConfigProperties teacherConfigProperties = new TeacherConfigProperties();
        System.out.println("teacherConfigProperties prod ==> " + teacherConfigProperties + " - " + System.identityHashCode(teacherConfigProperties));
        return teacherConfigProperties;
    }

    @Bean
    @ConfigurationProperties(prefix = "student")
    @Profile("dev")
    public StudentConfigProperties studentConfigPropertiesDev(){
        return new StudentConfigProperties();
    }

    @Bean
    @ConfigurationProperties(prefix = "student")
    @Profile("qa")
    public StudentConfigProperties studentConfigPropertiesQa(){
        return new StudentConfigProperties();
    }

    @Bean
    @ConfigurationProperties(prefix = "student")
    @Profile("prod")
    public StudentConfigProperties studentConfigPropertiesProd(){
        return new StudentConfigProperties();
    }

}
